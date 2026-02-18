package com.flexnet.lfs.callout;

/**
 * Directly called (not via REST) implementations of the capability request call-out must implement this interface.
 */
public interface ICallout {
  /**
   * This method is called during processing of a capability request when registered as a capability request call-out.
   *
   * @param params The information passed to the call-out.  Includes detail about the incoming capability request, the target host
   *               and any mapped add-ons.
   * @return The return value encodes any actions to be performed on behalf of the call-out.  Actions supported are:
   * <ul>
   *     <li>deny creation of unknown host (only at finalize host time)</li>
   *     <li>set newly created target host's host type (only at finalize host time)</li>
   *     <li>set or remove vendor dictionary entries on target host instance (only at finalize host or response time)</li>
   *     <li>set target host's owner (enterprise ID) (only at finalize host or response time)</li>
   *     <li>add status list items to capability response (at any time)</li>
   *     <li>deny access to target host (only at check access time)</li>
   *     <li>add vendor dictionary to capability response (only at finalize response time)</li>
   *     <li>override default capability response lifetime (only at finalize response time)</li>
   *     <li>skip confirmation when reducing add-on copies (only at finalize response time)</li>
   *     <li>deny mapping of add-on or inclusion of mapped add-on in generated license (only at finalize response time)</li>
   *     <li>set add-on mapping expiration date override (only at finalize response time)</li>
   * </ul>
   */
  Response invoke(Payload params);
}

