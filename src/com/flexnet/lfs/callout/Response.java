package com.flexnet.lfs.callout;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexnet.lfs.callout.model.AddOnActions;
import com.flexnet.lfs.callout.model.HostActions;
import com.flexnet.lfs.callout.model.ResponseActions;

import java.util.*;

public class Response {
  public ResponseActions responseActions;
  public HostActions hostActions;
  public LinkedList<AddOnActions> addOnActions;

  @JsonIgnore
  public AddOnActions.Builder getAddonActionsBuilder() {
    if (addOnActions == null) {
      this.addOnActions = new LinkedList<>();
    }
    this.addOnActions.add(new AddOnActions());

    return this.addOnActions.getLast().createBuilder();
  }

  @JsonIgnore
  public HostActions.Builder getHostActionsBuilder() {
    if (hostActions == null) {
      this.hostActions = new HostActions();
    }
    return this.hostActions.createBuilder();
  }

  @JsonIgnore
  public ResponseActions.Builder getResponseActionsBuilder() {
    if (responseActions == null) {
      this.responseActions = new ResponseActions();
    }
    return this.responseActions.createBuilder();
  }

//  /**
//   * Get the response actions defined by the call-out response.
//   *
//   * @return The response actions to perform.
//   */
//  public ResponseActions getResponseActions() {
//    return responseActions;
//  }
//
//  /**
//   * Create and add response actions to the call-out response.
//   *
//   * @return The newly created response actions.
//   */
//  public ResponseActions addResponseActions() {
//    if (responseActions == null) {
//      responseActions = new ResponseActions();
//    }
//    return responseActions;
//  }
//
//  /**
//   * Get the host actions defined by the call-out response.
//   *
//   * @return The host actions to perform.
//   */
//  public HostActions getHostActions() {
//    return addHostActions();
//  }
//
//  /**
//   * Create and add host actions to the call-out response.
//   *
//   * @return The newly created host actions.
//   */
//  public HostActions addHostActions() {
//    if (hostActions == null)
//      hostActions = new HostActions();
//
//    return hostActions;
//  }
//
//  /**
//   * Get the add-on actions defined by the call-out response.
//   *
//   * @return The add-on actions to perform.
//   */
//  public List<AddOnActions> getAddOnActions() {
//    return addOnActions;
//  }
//
//  /**
//   * Create and add add-on actions to the call-out response.
//   *
//   * @param activationId The activation ID to set on the add-on actions added.
//   * @return The newly created add-on actions.
//   */
//  public AddOnActions addAddOnActions(String activationId) {
//    if (addOnActions == null)
//      addOnActions = new LinkedList<>();
//    AddOnActions aa = new AddOnActions();
//    aa.activationId = activationId;
//    int found = addOnActions.indexOf(aa);
//    if (found < 0)
//      addOnActions.add(aa);
//    else
//      aa = addOnActions.get(found);
//
//    return aa;
//  }


}

