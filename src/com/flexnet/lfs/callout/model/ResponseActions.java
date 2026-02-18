package com.flexnet.lfs.callout.model;

import com.revenera.gcs.utils.Log;
import lfs.callout.CalloutFactory;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** This class defines the capability response specific actions to be performed upon return from the capability request call-out */
public class ResponseActions {
  private final static Log logger = Log.create(ResponseActions.class);

  public Map<String,Object> vendorDictionary;
  public List<StatusItem> addToStatusList;
  public Integer lifetime;

  public Builder createBuilder() {
    return new Builder();
  }

  public class Builder {
    private Builder() {

    }

    public Builder withVendorDictionary(final String key, final Object value) {
      if (ResponseActions.this.vendorDictionary == null) {
        ResponseActions.this.vendorDictionary = new HashMap<>();
      }
      ResponseActions.this.vendorDictionary.put(key, value);
      return this;
    }

    public Builder withAddToStatusList(final StatusItem statusItem) {
      if (ResponseActions.this.addToStatusList == null) {
        ResponseActions.this.addToStatusList = new LinkedList<>();
      }
      ResponseActions.this.addToStatusList.add(statusItem);
      return this;
    }

    public Builder withAddToStatusList(final int code, final String detail) {
      return withAddToStatusList(new StatusItem(code, detail));
    }

    public Builder withLifetime(final int lifetime) {
      ResponseActions.this.lifetime = lifetime;
      return this;
    }

    public void build() {
      logger.json(Log.Level.info, ResponseActions.this);
    }
  }
//    /**
//     * Get the vendor dictionary entries to be added to the capability response.
//     *
//     * @return The vendor dictionary entries to be added.
//     */
//    public Map<String,Object> getVendorDictionary() {
//		return vendorDictionary;
//	}
//
//    /**
//     * Set the vendor dictionary entries to be added to the capability response.
//     *
//     * @param vendorDictionary The vendor dictionary entries to be added.
//     */
//	public void setVendorDictionary(Map<String,Object> vendorDictionary) {
//		this.vendorDictionary = vendorDictionary;
//	}
//
//    /**
//     * Create and add container for vendor dictionary entries to be added to the capability response.
//     * Don't mix calls to this method with calls to {@link #setVendorDictionary(Map)}.
//     *
//     * @return The newly created container for vendor dictionary entries.
//     */
//	public Map<String,Object> addVendorDictionary() {
//        if (vendorDictionary == null)
//            vendorDictionary = new HashMap<>();
//
//        return vendorDictionary;
//	}
//
//    /**
//     * Add a single vendor dictionary entry to be added to the capability response.
//     * This method may be called multiple time.  Don't mix calls to this method
//     * with calls to {@link #setVendorDictionary(Map)}.
//     *
//     * @param key The entry's key.
//     * @param value The entry's value.
//     */
//    public void addToVendorDictionary(String key, Object value) {
//        addVendorDictionary().put(key, value);
//    }
//
//    /**
//     * Get the status list items to be added to the capability response.
//     *
//     * @return The status list items to be added.
//     */
//	public List<StatusItem> getAddToStatusList() {
//		return addToStatusList;
//	}
//
//    /**
//     * Set status list items to be added to the capability response.
//     *
//     * @param addToStatusList The list of status items.
//     */
//	public void setAddToStatusList(List<StatusItem> addToStatusList) {
//		this.addToStatusList = addToStatusList;
//	}
//
//    /**
//     * Create and add container for status list items to be added to the capability response.
//     * Don't mix calls to this method
//     * with calls to {@link #setAddToStatusList(List)}.
//     *
//     * @return The newly created container for status list items.
//     */
//    public List<StatusItem> addAddToStatusList() {
//        if (addToStatusList == null)
//            addToStatusList = new LinkedList<>();
//
//        return addToStatusList;
//    }
//
//    /**
//     * Add a single status list item to be added to the capability response.
//     * This method may be called multiple time.  Don't mix calls to this method
//     * with calls to {@link #setAddToStatusList(List)}.
//     *
//     * @param key The entry's key.
//     * @param value The entry's value.
//     */
//    public void addStatus(StatusItem item) {
//        addAddToStatusList().add(item);
//    }
//
//    /**
//     * Get the capability response life time to be used for the capability response.
//     *
//     * @return The response life time, in seconds.  Zero for no expiration.
//     */
//	public Integer getLifetime() {
//		return lifetime;
//	}
//
//    /**
//     * Set the response life time to be used for the capability response.
//     *
//     * @param lifetime The response life time, in seconds.  Zero for no expiration.
//     */
//	public void setLifetime(Integer lifetime) {
//		this.lifetime = lifetime;
//	}


}