package lfs.callout;

import com.flexnet.lfs.callout.ICallout;
import com.flexnet.lfs.callout.Response;
import com.revenera.gcs.utils.Log;

import java.util.LinkedHashMap;
import java.util.Map;

public final class CalloutFactory {
  private final static Log logger = Log.create(CalloutFactory.class);

  static final ICallout not_implemented_callout = payload -> {
    logger.log(Log.Level.info,"not_implemented_callout");

    return new Response();
  };

  private final Map<Endpoints, ICallout> implementors = new LinkedHashMap<>();

  public CalloutFactory addCallout(final Endpoints endpoint, final ICallout callout){
//    logger.log(Log.Level.debug,"implementSpecificCallout " + endpoint.toString());
    this.implementors.put(endpoint, callout);
    return this;
  }

  public CalloutFactory removeCallout(final Endpoints endpoint){
//    logger.log(Log.Level.debug,"removeCallout " + endpoint.toString());
    this.implementors.remove(endpoint);
    return this;
  }

  public CalloutFactory removeAllCallouts(){
//    logger.log(Log.Level.debug,"removeAllCallouts");
    this.implementors.clear();
    return this;
  }

  public ICallout of(final Endpoints type) {
    return this.implementors.getOrDefault(type, not_implemented_callout);
  }
}
