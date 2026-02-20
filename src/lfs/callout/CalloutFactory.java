package lfs.callout;

import com.flexnet.lfs.callout.*;
import com.revenera.gcs.utils.Log;

import java.time.Instant;
import java.util.*;
import java.util.stream.Stream;

public final class CalloutFactory {
  private final static Log logger = Log.create(CalloutFactory.class);

//  //TODO: augment this...
  static final ICallout not_implemented_callout = payload -> {
    logger.log(Log.Level.info,"not_implemented_callout");

    return new Response();
  };
//
//  //TODO: augment this...
//  static final ICallout finalized_host_callout = payload -> {
//    logger.log(Log.Level.info,"finalized_host_callout");
//
//    return new Response() {
//      {
//        this.getHostActionsBuilder()
//            .withAddToVendorDictionary("FINALIZE_HOST", Instant.now().toString())
//            .withDenyAccess(true)
//            .withHostType(payload.hostInfo.hostType)
//            .withDenyCreate(true)
//            .withEnterpriseId(payload.hostInfo.enterpriseId)
//            .build();
//
//        payload.addOnInfo.forEach(addon -> {
//          this.getAddonActionsBuilder()
//              .withActivationId(addon.activationId)
//              .withDenied(true)
//              .build();
//        });
//      }
//    };
//  };
//
//  //TODO: implement this...
//  static final ICallout check_access_callout = payload -> {
//    logger.log(Log.Level.info,"check_access_callout");
//
//    return new Response() {
//      {
//        this.getHostActionsBuilder()
//            .withAddToVendorDictionary("CHECK_ACCESS", Instant.now().toString())
//            .withDenyAccess(true)
//            .withHostType(payload.hostInfo.hostType)
//            .withDenyCreate(true)
//            .withEnterpriseId(payload.hostInfo.enterpriseId)
//            .build();
//
//        payload.addOnInfo.forEach(addon -> {
//          this.getAddonActionsBuilder()
//              .withActivationId(addon.activationId)
//              .withDenied(true)
//              .build();
//
//          this.getResponseActionsBuilder()
//              .withAddToStatusList(0, "????")
//              .withLifetime(0)
//              .build();
//        });
//      }
//    };
//  };
//
//  //TODO: implement this...
//  static final ICallout finalize_response_callout = payload -> {
//    logger.log(Log.Level.info,"finalize_response_callout");
//
//    return new Response() {
//      {
//        this.getHostActionsBuilder()
//            .withAddToVendorDictionary("FINALIZE_RESPONSE", Instant.now().toString())
//            .withDenyCreate(false)
//            .withDenyAccess(false)
//            .withHostType("FLX_CLIENT")
//            .withEnterpriseId(payload.hostInfo.enterpriseId)
//            .build();
//
//        payload.addOnInfo.forEach(addon -> {
//          this.getAddonActionsBuilder()
//              .withActivationId(addon.activationId)
//              .withSkipConfirmation(false)
//              .withDenied(true)
//              .build();
//        });
//      }
//    };
//  };
//
//  static final ICallout health_callout = payload -> new ExtendedPayload<Map<String,Object>>() {
//    {
//      this.timestamp = Instant.now().toString();
//      this.payload = new TreeMap<String, Object>() {
//        {
//          System.getProperties().forEach((key, value) -> {
//            put(key.toString(), value);
//          });
//        }
//      };
//    }
//  };
//
//  static final ICallout ping_callout = payload -> new ExtendedPayload<PingInfo>() {
//    {
//      this.timestamp = Instant.now().toString();
//      this.payload = PingInfo.create();
//    }
//  };

  final Map<Endpoints, ICallout> implementors = new LinkedHashMap<>();

//  public CalloutFactory(final boolean implementAllCallouts) {
//    if (implementAllCallouts) {
//      Stream.of(Endpoints.values()).forEach(this::implementDefaultCallout);
//    }
//  }
//
//  public CalloutFactory implementAllDefaultCallouts() {
//    Stream.of(Endpoints.values()).forEach(this::implementDefaultCallout);
//    return this;
//  }

//  public ICallout getDefaultCallout(final Endpoints endpoint) {
//    switch (endpoint) {
//      case FINALIZE_HOST: return finalized_host_callout;
//      case CHECK_ACCESS: return check_access_callout;
//      case FINALIZE_RESPONSE: return finalize_response_callout;
//      case HEALTH: return health_callout;
//      case PING: return ping_callout;
//    }
//    throw new IllegalArgumentException("Unknown endpoint: " + endpoint);
//  }

//  public CalloutFactory implementDefaultCallout(final Endpoints endpoint) {
////    logger.log(Log.Level.debug,"implementDefaultCallout " + endpoint.toString());
//    implementSpecificCallout(endpoint, getDefaultCallout(endpoint));
//    return this;
//  }

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
