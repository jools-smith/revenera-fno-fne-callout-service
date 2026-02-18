package com.flexnet.lfs.callout;

import com.flexnet.lfs.callout.model.AddOnInfo;
import com.flexnet.lfs.callout.model.HostInfo;
import com.flexnet.lfs.callout.model.RequestInfo;
import com.flexnet.lfs.callout.model.StatusItem;

import java.util.LinkedList;
import java.util.List;

/**
 * This class holds the data passed to the capability request call-out
 */
public class Payload {
  public RequestInfo requestInfo;
  public HostInfo hostInfo;
  public List<AddOnInfo> addOnInfo;
  public List<StatusItem> statusList;

//  public RequestInfo getRequestInfo() {
//    return requestInfo;
//  }
//
//  public void setRequestInfo(RequestInfo request) {
//    this.requestInfo = request;
//  }
//
//  public RequestInfo addRequestInfo() {
//    return requestInfo = new RequestInfo();
//  }
//
//  public HostInfo getHostInfo() {
//    return hostInfo;
//  }
//
//  public void setHostInfo(HostInfo host) {
//    this.hostInfo = host;
//  }
//
//  public HostInfo addHostInfo() {
//    return hostInfo = new HostInfo();
//  }
//
//  public List<AddOnInfo> getAddOnInfo() {
//    return addOnInfo;
//  }
//
//  public void setAddOnInfo(List<AddOnInfo> addOns) {
//    this.addOnInfo = addOns;
//  }
//
//  public AddOnInfo addAddOnInfo() {
//    final AddOnInfo info = new AddOnInfo();
//    try {
//      return info;
//    }
//    finally {
//      if (this.addOnInfo == null) {
//        this.addOnInfo = new LinkedList<>();
//      }
//      this.addOnInfo.add(info);
//    }
//  }
//
//  public List<StatusItem> getStatusList() {
//    return statusList;
//  }
//
//  public void setStatusList(List<StatusItem> statusList) {
//    this.statusList = statusList;
//  }
//
//  public StatusItem addStatus() {
//    final StatusItem status = new StatusItem();
//    try {
//      return status;
//    }
//    finally {
//      if (this.statusList == null) {
//        this.statusList = new LinkedList<>();
//      }
//      this.statusList.add(status);
//    }
//  }


}