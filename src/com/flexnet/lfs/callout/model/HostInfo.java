package com.flexnet.lfs.callout.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.flexnet.lm.SharedConstants.HostIdType;
import com.flexnet.lm.SharedConstants.MachineType;

/** This class holds the target host information passed to the capability request call-out */
public final class HostInfo {
	public String id;
	public HostIdType idType;
	public boolean server;
	public String hostType;
	public String hostClass;
	public String alias;
	public String identityName;
	public String publisherName;
	public Map<String,Object>  vendorDictionary;
	public Date firstActivated;
	public MachineType machineType;
	public String vmName;
	public String baseProductId;
	public Long enterpriseId;
	public String user;
	public Long userId;

//    /**
//     * Get the target host identifier value.
//     *
//     * @return The target host ID value.
//     */
//	public String getId() {
//		return id;
//	}
//
//	/**
//	 * Sets the host identifier value.
//     * This method is used internally for JSON deserialization.
//	 *
//	 * @param id The new host ID value.
//	 */
//	public void setId(String id) {
//		this.id = id;
//	}
//
//	/**
//	 * Gets the target host identifier type.
//	 *
//	 * @return The target host ID type.
//	 */
//	public HostIdType getIdType() {
//		return idType;
//	}
//
//	/**
//	 * Sets the target host identifier type.
//     * This method is used internally for JSON deserialization.
//	 *
//	 * @param idType The new host ID type.
//	 */
//	public void setIdType(HostIdType idType) {
//		this.idType = idType;
//	}
//
//    /**
//     * Is the target host a server?
//     *
//     * @return True if the target host is a server, false otherwise.
//     */
//	public boolean isServer() {
//        return server;
//    }
//
//    /**
//     * Sets the server attribute.
//     * This method is used internally for JSON deserialization.
//     *
//     * @param server The new value, true if a server, false otherwise.
//     */
//    public void setServer(boolean server) {
//        this.server = server;
//    }
//
//    /**
//     * Gets the target host's type name.
//     *
//     * @return The host type of the target host.
//     */
//	public String getHostType() {
//		return hostType;
//	}
//
//    /**
//     * Sets the target host's type name.
//     * This method is used internally for JSON deserialization.
//     *
//     * @param hostType The new host type of the target host.
//     */
//	public void setHostType(String hostType) {
//		this.hostType = hostType;
//	}
//
//    /**
//     * Gets the target host's alias, if any.
//     *
//     * @return The target host's alias, or null if none defined.
//     */
//	public String getAlias() {
//		return alias;
//	}
//
//    /**
//     * Sets the target host's alias.
//     * This method is used internally for JSON deserialization.
//     *
//     * @param alias The new target host's alias.
//     */
//	public void setAlias(String alias) {
//		this.alias = alias;
//	}
//
//	/**
//	 * Gets the name of the target host's publisher identity.
//	 *
//	 * @return The identity name.
//	 */
//    public String getIdentityName() {
//		return identityName;
//	}
//
//    /**
//     * Sets the name of the target host's publisher identity.
//     * This method is used internally for JSON deserialization.
//     *
//     * @param identityName The new identity name.
//     */
//	public void setIdentityName(String identityName) {
//		this.identityName = identityName;
//	}
//
//	/**
//	 * Gets the name of the target host's associated publisher.
//	 *
//	 * @return The publisher name.
//	 */
//	public String getPublisherName() {
//		return publisherName;
//	}
//
//	/**
//	 * Sets the name of the target host's associated publisher.
//     * This method is used internally for JSON deserialization.
//     *
//	 * @param publisherName The new publisher name.
//	 */
//	public void setPublisherName(String publisherName) {
//		this.publisherName = publisherName;
//	}
//
//	/**
//     * Gets the target host's vendor dictionary, if any.
//     *
//     * @return The target host's vendor dictionary, or null if none defined.
//     */
//	public Map<String, Object> getVendorDictionary() {
//		return vendorDictionary;
//	}
//
//    /**
//     * Sets the target host's vendor dictionary.
//     * This method is used internally for JSON deserialization.
//     *
//     * @param vendorDictionary The new target host's vendor dictionary.
//     */
//	public void setVendorDictionary(Map<String, Object> vendorDictionary) {
//		this.vendorDictionary = vendorDictionary;
//	}
//
//    /**
//     * Convenience method to create and set the target host's vendor dictionary.
//     * This method is only used internally.
//     *
//     * @return The newly created target host's vendor dictionary.
//     */
//	public Map<String,Object> addVendorDictionary() {
//		return this.vendorDictionary = new HashMap<>();
//	}
//
//    /**
//     * Gets the target host's first activation date, if any.
//     *
//     * @return The target host's vendor dictionary, or null if never activated.
//     */
//	public Date getFirstActivated() {
//		return firstActivated;
//	}
//
//    /**
//     * Sets the target host's first activation date, if any.
//     * This method is used internally for JSON deserialization.
//     *
//     * @param firstActivated The new target host's first activation date.
//     */
//	public void setFirstActivated(Date firstActivated) {
//		this.firstActivated = firstActivated;
//	}
//
//    /**
//     * Gets the target host's machine type, if defined.
//     *
//     * @return The target host's machine type, or null if not defined.
//     */
//	public MachineType getMachineType() {
//		return machineType;
//	}
//
//    /**
//     * Sets the target host's machine type.
//     * This method is used internally for JSON deserialization.
//     *
//     * @param machineType The new target host's machine type.
//     */
//	public void setMachineType(MachineType machineType) {
//		this.machineType = machineType;
//	}
//
//    /**
//     * Gets the target host's VM name, if defined.
//     *
//     * @return The target host's VM name, or null if not defined.
//     */
//	public String getVmName() {
//		return vmName;
//	}
//
//    /**
//     * Sets the target host's VM name.
//     * This method is used internally for JSON deserialization.
//     *
//     * @param vmName The target host's new VM name.
//     */
//	public void setVmName(String vmName) {
//		this.vmName = vmName;
//	}
//
//    /**
//     * Gets the target host's base product ID, if defined.
//     *
//     * @return
//     */
//	public String getBaseProductId() {
//		return baseProductId;
//	}
//
//    /**
//     * Sets the target host's base product ID.
//     * This method is used internally for JSON deserialization.
//     *
//     * @param baseProductId The target host's base product ID, or null if not defined.
//     */
//	public void setBaseProductId(String baseProductId) {
//		this.baseProductId = baseProductId;
//	}
//
//    /**
//     * Gets the target host's owner, if defined.
//     *
//     * @return The target host's owner, or null if none defined.
//     */
//	public Long getEnterpriseId() {
//		return enterpriseId;
//	}
//
//    /**
//     * Sets the target host's owner.
//     * This method is used internally for JSON deserialization.
//     *
//     * @param enterpriseId The new target host's owner.
//     */
//	public void setEnterpriseId(Long enterpriseId) {
//		this.enterpriseId = enterpriseId;
//	}
//
//    /**
//     * Gets the target host's user name (typically email address), if defined.
//     *
//     * @return The target host's user name, or null if none defined.
//     */
//	public String getUser() {
//		return user;
//	}
//
//    /**
//     * Sets the target host's user name (typically email address).
//     * This method is used internally for JSON deserialization.
//     *
//     * @param user The target host's new user name.
//     */
//	public void setUser(String user) {
//		this.user = user;
//	}
//
//    /**
//     * Gets the target host's user ID, if defined.
//     *
//     * @return The target host's user ID, or null if none defined.
//     */
//	public Long getUserId() {
//		return userId;
//	}
//
//    /**
//     * Sets the target host's user ID.
//     * This method is used internally for JSON deserialization.
//     *
//     * @param userId The target host's new user ID.
//     */
//	public void setUserId(Long userId) {
//		this.userId = userId;
//	}
	

}