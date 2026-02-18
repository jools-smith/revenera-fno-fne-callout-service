package lfs.callout;

import com.flexnet.lfs.callout.Payload;
import com.flexnet.lfs.callout.PingInfo;
import com.flexnet.lfs.callout.Response;
import com.revenera.gcs.utils.Log;
import com.revenera.gcs.utils.Utils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * This is an example servlet that implements a capability request call-out.
 * It responds to the checkAccess, finalizeHost and finalizeResponse REST endpoints.
 */
@WebServlet(
    name = "Revenera GCS FNE Callout Service",
    urlPatterns = {
        "/checkAccess",
        "/finalizeHost",
        "/finalizeResponse",
        "/health",
        "/ping"
    },
    asyncSupported = true)
//@WebFilter("/*")
//@WebListener
public class CapabilityCalloutServlet extends HttpServlet {
  private static String version = "Revenera GCS: FNE callout service - version 0.0";

  private final static Log logger = Log.create(CapabilityCalloutServlet.class);

  private final static Map<Endpoints, String> endpoints = new HashMap<Endpoints, String>() {
    {
      put(Endpoints.HEALTH, "/health");
      put(Endpoints.PING, "/ping");
      put(Endpoints.CHECK_ACCESS, "/checkAccess");
      put(Endpoints.FINALIZE_HOST, "/finalizeHost");
      put(Endpoints.FINALIZE_RESPONSE, "/finalizeResponse");
    }
  };

  private final static CalloutFactory factory = new CalloutFactory(true);

  static {
    logger.array(Log.Level.info, "Service starting", Instant.now().toString());

    final String config = System.getenv("REVENERA_SERVICE_CONFIG");

    factory.removeAllCallouts();

    if (config != null) {
      logger.array(Log.Level.debug, "Revenera callout service configuration found", config);
      endpoints.forEach((key, value) -> {
        if (config.contains(value)) {
          factory.implementDefaultCallout(key);
        }
      });
    }
    else {
      logger.log(Log.Level.debug,"configuration not found");
      factory
        .implementDefaultCallout(Endpoints.HEALTH)
        .implementDefaultCallout(Endpoints.PING)
        .implementDefaultCallout(Endpoints.CHECK_ACCESS)
        .implementDefaultCallout(Endpoints.FINALIZE_HOST)
        .implementDefaultCallout(Endpoints.FINALIZE_RESPONSE);
    }

  }

  boolean debug;

  public CapabilityCalloutServlet() {
    logger.array(Log.Level.info, "Service created", Instant.now().toString());

    this.debug = true;
  }

  @Override
  public void init() throws ServletException {
    logger.in();
    try {
      logger.log(Log.Level.info, "service initialized");
      logger.json(Log.Level.info, PingInfo.create());
    }
    finally {
      logger.out();
    }
  }

  @Override
  public String getServletInfo() {
    logger.in();
    try {
      return version;
    }
    finally {
      logger.out();
    }
  }

  @Override
  public void destroy()  {
    logger.in();
    try {
      logger.log(Log.Level.info, "service destroyed");
      logger.json(Log.Level.info, PingInfo.create());
    }
    finally {
      logger.out();
    }
  }

  static Endpoints findByMethodName(final String restMethodName) throws ServiceException {

    return endpoints.entrySet().stream()
        .filter(e -> restMethodName.contains(e.getValue()))
        .map(Map.Entry::getKey)
        .findFirst()
        .orElseThrow(() -> new ServiceException("unrecognized resource " + restMethodName, HttpServletResponse.SC_BAD_REQUEST));
  }

  //TODO: really should be using Java 9+ here!
  @Deprecated
  private static byte[] readAllBytes(InputStream inputStream) throws IOException {
    byte[] bytes;
    try (ByteArrayOutputStream outputStream = new ByteArrayOutputStream()) {
      byte[] buf = new byte[1];

      while(inputStream.read(buf, 0, buf.length) != -1) {
        outputStream.write(buf[0]);
      }

      bytes = outputStream.toByteArray();
    }

    return bytes;
  }
  /**
   * This method is called when a message is POSTed to the servlet
   */
  @Override
  protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
    // get the servlet path which is the endpoint that was invoked, convert to enumeration value for call-out
    logger.in();
    try {
      //TODO: log entry details
      logger.array(Log.Level.info, request.getMethod(), request.getRequestURI());

      //TODO: debug
      final InputStream inputStream = request.getInputStream();
      if (inputStream == null) {
        throw new ServiceException("input stream is null", HttpServletResponse.SC_NO_CONTENT);
      }

      //TODO: debug
      final byte[] bytes = readAllBytes(inputStream);
      if (bytes.length == 0) {
        throw new ServiceException("no payload", HttpServletResponse.SC_NO_CONTENT);
      }

      // TODO:Debug
      if (this.debug) {
        Optional.ofNullable(Utils.json_mapper.readValue(bytes, Object.class)).ifPresent(obj -> {
          logger.json(Log.Level.info, obj);
        });
      }

      final Payload payload = Utils.json_mapper.readValue(bytes,Payload.class);
      logger.json(Log.Level.trace, payload);

      //TODO: is this the correct place?
      final Endpoints resource = findByMethodName(request.getServletPath());

      //TODO: call the callout but we should not need the resource which is implied!
      final Response content = factory.of(resource).invoke(payload);

      logger.json(Log.Level.trace, content);
      Utils.json_mapper.writeValue(response.getOutputStream(), content);
    }
    catch (final ServiceException e) {
      logger.exception(e);

      response.setStatus(e.status);

      response.getOutputStream().println(e.getLocalizedMessage());
    }
    catch (final Throwable t) {
      logger.exception(t);

      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

      response.getOutputStream().println(t.getLocalizedMessage());
    }
    finally {
      logger.out();
    }
  }

  private void unimplemented(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
    try {
      response.getOutputStream().println(request.getMethod() + " (" +  request.getServletPath() + ") is not supported");

      response.setStatus(HttpServletResponse.SC_NOT_IMPLEMENTED);
    }
    catch (final Throwable t) {
      logger.exception(t);

      response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);

      response.getOutputStream().println(t.getLocalizedMessage());
    }
  }

  @Override
  protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
    logger.in();
    try {
      unimplemented(request, response);
    }
    finally {
      logger.out();
    }
  }

  @Override
  protected void doPut(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
    logger.in();
    try {
      unimplemented(request, response);
    }
    finally {
      logger.out();
    }
  }

  @Override
  protected void doDelete(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
    logger.in();
    try {
      unimplemented(request, response);
    }
    finally {
      logger.out();
    }
  }

  @Override
  protected void doHead(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
    logger.in();
    try {
      unimplemented(request, response);
    }
    finally {
      logger.out();
    }
  }

  @Override
  protected void doOptions(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
    logger.in();
    try {
      unimplemented(request, response);
    }
    finally {
      logger.out();
    }
  }

  @Override
  protected void doTrace(final HttpServletRequest request, final HttpServletResponse response) throws IOException {
    logger.in();
    try {
      unimplemented(request, response);
    }
    finally {
      logger.out();
    }
  }

}
