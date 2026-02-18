package com.flexnet.lfs.callout;

import java.util.Map; /**
 * This class defines the actions to be performed upon return from the capability request call-out
 */
public class PingResponse extends Response {
  public String timestamp;
  public PingInfo ping;
}
