package lfs.callout;

import com.flexnet.lfs.callout.*;
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
import java.util.*;

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
public class CapabilityCalloutServlet extends HttpServlet {
  private static final String version = "Revenera GCS: FNE callout service";

  private final static Log logger = Log.create(CapabilityCalloutServlet.class);

  //TODO: FINALIZE HOST
  static final ICallout finalized_host_callout = payload -> {
    logger.log(Log.Level.info,"finalized_host_callout");

    return new Response() {
      {
        this.getHostActionsBuilder()
            .withAddToVendorDictionary("FINALIZE_HOST", Instant.now().toString())
            .withDenyAccess(true)
            .withHostType(payload.hostInfo.hostType)
            .withDenyCreate(true)
            .withEnterpriseId(payload.hostInfo.enterpriseId)
            .build();

        payload.addOnInfo.forEach(addon -> {
          this.getAddonActionsBuilder()
              .withActivationId(addon.activationId)
              .withDenied(true)
              .build();
        });
      }
    };
  };

  //TODO: CHECK ACCESS
  static final ICallout check_access_callout = payload -> {
    logger.log(Log.Level.info,"check_access_callout");

    return new Response() {
      {
        this.getHostActionsBuilder()
            .withAddToVendorDictionary("CHECK_ACCESS", Instant.now().toString())
            .withDenyAccess(true)
            .withHostType(payload.hostInfo.hostType)
            .withDenyCreate(true)
            .withEnterpriseId(payload.hostInfo.enterpriseId)
            .build();

        payload.addOnInfo.forEach(addon -> {
          this.getAddonActionsBuilder()
              .withActivationId(addon.activationId)
              .withDenied(true)
              .build();

          this.getResponseActionsBuilder()
              .withAddToStatusList(0, "????")
              .withLifetime(0)
              .build();
        });
      }
    };
  };

  //TODO: FINALIZE RESPONSE
  static final ICallout finalize_response_callout = payload -> {
    logger.log(Log.Level.info,"finalize_response_callout");

    return new Response() {
      {
        this.getHostActionsBuilder()
            .withAddToVendorDictionary("FINALIZE_RESPONSE", Instant.now().toString())
            .withDenyCreate(false)
            .withDenyAccess(false)
            .withHostType("FLX_CLIENT")
            .withEnterpriseId(payload.hostInfo.enterpriseId)
            .build();

        payload.addOnInfo.forEach(addon -> {
          this.getAddonActionsBuilder()
              .withActivationId(addon.activationId)
              .withSkipConfirmation(false)
              .withDenied(true)
              .build();
        });
      }
    };
  };

  private final static List<CalloutWrapper> endpoints = Arrays.asList(
      new CalloutWrapper(Endpoints.CHECK_ACCESS,"/checkAccess", check_access_callout),
      new CalloutWrapper(Endpoints.FINALIZE_HOST,"/finalizeHost", finalized_host_callout),
      new CalloutWrapper(Endpoints.FINALIZE_RESPONSE, "/finalizeResponse", finalize_response_callout));

    private final static CalloutFactory factory = new CalloutFactory();

  static {
    logger.array(Log.Level.info, "Service starting", Instant.now().toString());

    final String config = System.getenv("REVENERA_SERVICE_CONFIG");

    factory.removeAllCallouts();

    if (config != null) {
      logger.array(Log.Level.debug, "Revenera callout service configuration found", config);
      endpoints.forEach(data -> {
        if (config.contains(data.getResource())) {
          factory.addCallout(data.getEndpoint(), data.getCallout());
        }
      });
    }
    else {
      logger.log(Log.Level.debug,"configuration not found");
    }
  }

  boolean debug;

  public CapabilityCalloutServlet() {
    logger.array(Log.Level.info, "Service created", Instant.now().toString());

    CustomResponse.start();

    this.debug = false;
  }

  @Override
  public void init() throws ServletException {
    logger.in();
    try {
      logger.log(Log.Level.info, "service initialized");
      logger.json(Log.Level.info, ApplicationProperties.getBuildProperties());
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
      logger.json(Log.Level.info, ApplicationProperties.create());
    }
    finally {
      logger.out();
    }
  }

  static Endpoints findByMethodName(final String restMethodName) throws ServiceException {

    return endpoints.stream()
        .filter(e -> restMethodName.contains(e.getResource()))
        .map(CalloutWrapper::getEndpoint)
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
      if (request.getServletPath().contains("/health")) {
        Utils.json_mapper.writeValue(response.getOutputStream(), new CustomResponse<Map<Object,Object>>() {
          {
            this.payload = ApplicationProperties.getBuildProperties();
          };
        });
      }
      else if (request.getServletPath().contains("/ping")) {
        Utils.json_mapper.writeValue(response.getOutputStream(), new CustomResponse<ApplicationProperties>() {
          {
            this.payload = ApplicationProperties.create();
          }
        });
      }
      else {
        unimplemented(request, response);
      }
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
