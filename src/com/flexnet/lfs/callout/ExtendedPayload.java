package com.flexnet.lfs.callout;

import java.util.Map; /**
 * This class defines the actions to be performed upon return from the capability request call-out
 */
public class ExtendedPayload<T> extends Response {
  public String timestamp;
  public T payload;
}
