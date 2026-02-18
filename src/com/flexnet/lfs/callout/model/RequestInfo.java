package com.flexnet.lfs.callout.model;

import com.flexnet.lm.binary.ActivationId;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** This class holds the capability request derived information passed to the capability request call-out */
public final class RequestInfo {
	public boolean offline;
	public List<ActivationId> activationIds;
	public Map<String,Object>  vendorDictionary;
	public long lastResponseTime;

//    /**
//     * Return true if the incoming capability request if offline, otherwise it's from a connected client or server.
//     *
//     * @return True if offline, false if connected.
//     */
//	public boolean isOffline() {
//		return offline;
//	}
//
//	/**
//	 * Sets offline status.
//     * This method is used internally for JSON deserialization.
//	 *
//	 * @param offline True if offline, false if connected.
//	 */
//	public void setOffline(boolean offline) {
//		this.offline = offline;
//	}
//
//	/**
//	 * Return the activation IDs, if any, from the incoming capability request.
//	 *
//	 * @return The list of activation IDs or null if none present.
//	 */
//	public List<ActivationId> getActivationIds() {
//		return activationIds;
//	}
//
//    /**
//     * Sets the activation IDs, if any, from the incoming capability request.
//     * This method is used internally for JSON deserialization.
//     *
//     * @param activationIds The list of activation IDs.
//     */
//	public void setActivationIds(List<ActivationId> activationIds) {
//		this.activationIds = activationIds;
//	}
//
//	/**
//	 * Gets the vendor dictionary, if any, from the incoming capability request.
//     *
//	 * @return The vendor dictionary or null if none present.
//	 */
//	public Map<String,Object> getVendorDictionary() {
//		return vendorDictionary;
//	}
//
//	/**
//	 * Sets the vendor dictionary, if any, from the incoming capability request.
//     * This method is used internally for JSON deserialization.
//     *
//	 * @param vendorDictionary The new vendor dictionary.
//	 */
//	public void setVendorDictionary(Map<String,Object> vendorDictionary) {
//		this.vendorDictionary = vendorDictionary;
//	}
//
//	/**
//	 * Creates and sets new vendor dictionary. This method is used internally.
//	 *
//	 * @return The newly created vendor dictionary.
//	 */
//	public Map<String,Object> addVendorDictionary() {
//		return this.vendorDictionary = new HashMap<>();
//	}
//
//	/**
//	 * Gets the last response time from the incoming capability request.
//	 *
//	 * @return The last response time.
//	 */
//	public long getLastResponseTime() {
//		return lastResponseTime;
//	}
//
//	/**
//	 * Sets the last response time from the incoming capability request.
//     * This method is used internally for JSON deserialization.
//     *
//	 * @param lastResponseTime The new last response time.
//	 */
//	public void setLastResponseTime(long lastResponseTime) {
//		this.lastResponseTime = lastResponseTime;
//	}


}