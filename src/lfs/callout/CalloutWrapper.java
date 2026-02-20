package lfs.callout;

import com.flexnet.lfs.callout.ICallout;

public class CalloutWrapper {
  private final Endpoints endpoint;
  private final ICallout callout;
  private final String resource;

  CalloutWrapper(final Endpoints endpoint, final String resource, final ICallout callout) {
    this.endpoint = endpoint;
    this.callout = callout;
    this.resource = resource;
  }

  public Endpoints getEndpoint() {
    return endpoint;
  }
  public ICallout getCallout() {
    return callout;
  }
  public String getResource() {
    return resource;
  }
}
