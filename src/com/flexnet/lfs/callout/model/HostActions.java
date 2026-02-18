package com.flexnet.lfs.callout.model;

import com.revenera.gcs.utils.Log;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/** This class defines the target host specific actions to be performed upon return from the capability request call-out */
public class HostActions {
	private final static Log logger = Log.create(HostActions.class);

	public Map<String,Object> addToVendorDictionary;
	public List<String> removeFromVendorDictionary;
	public boolean denyCreate;
	public boolean denyAccess;
	public String hostType;
	public Long enterpriseId;

	public Builder createBuilder() {
		return new Builder();
	}

	public class Builder {
		private Builder() {
		}

		public Builder withAddToVendorDictionary(final String key,final Object value) {
			if (HostActions.this.addToVendorDictionary == null) {
				HostActions.this.addToVendorDictionary = new HashMap<>();
			}
			HostActions.this.addToVendorDictionary.put(key, value);
			return this;
		}

		public Builder withRemoveFromVendorDictionary(final String key,final Object value) {
			if (HostActions.this.removeFromVendorDictionary == null) {
				HostActions.this.removeFromVendorDictionary = new LinkedList<>();
			}
			HostActions.this.removeFromVendorDictionary.add(key);
			return this;
		}

		public Builder withDenyCreate(final boolean value) {
			HostActions.this.denyCreate = value;
			return this;
		}
		public Builder withDenyAccess(final boolean value) {
			HostActions.this.denyAccess = value;
			return this;
		}
		public Builder withHostType(final String value) {
			HostActions.this.hostType = value;
			return this;
		}
		public Builder withEnterpriseId(final long value) {
			HostActions.this.enterpriseId = value;
			return this;
		}
		public void build() {
			logger.json(Log.Level.info, HostActions.this);
		}
	}
//    /**
//     * Get the vendor dictionary entries to be added to the target host instance.
//     *
//     * @return The vendor dictionary entries to be added.
//     */
//    public Map<String, Object> getAddToVendorDictionary() {
//		return addToVendorDictionary;
//	}
//
//    /**
//     * Set the vendor dictionary entries to be added to the target host instance.
//     *
//     * @param addToVendorDictionary The vendor dictionary entries to be added.
//     */
//	public void setAddToVendorDictionary(Map<String, Object> addToVendorDictionary) {
//		this.addToVendorDictionary = addToVendorDictionary;
//	}
//
//    /**
//     * Add a single vendor dictionary entry to be added to the target host instance.
//     * This method may be called multiple time.  Don't mix calls to this method
//     * with calls to {@link #setAddToVendorDictionary(Map)}
//     *
//     * @param key The entry's key.
//     * @param value The entry's value.
//     */
//    public void addToVendorDictionary(String key, Object value) {
//        if (addToVendorDictionary == null)
//            addToVendorDictionary = new HashMap<>();
//
//        addToVendorDictionary.put(key, value);
//    }
//
//    /**
//     * Get the keys of vendor dictionary entries to be removed from the target host instance.
//     *
//     * @return The keys of the vendor dictionary entries to be removed.
//     */
//	public List<String> getRemoveFromVendorDictionary() {
//		return removeFromVendorDictionary;
//	}
//
//    /**
//     * Set the keys of vendor dictionary entries to be removed from the target host instance.
//     *
//     * @param removeFromVendorDictionary The keys of the vendor dictionary entries to be removed.
//     */
//	public void setRemoveFromVendorDictionary(List<String> removeFromVendorDictionary) {
//		this.removeFromVendorDictionary = removeFromVendorDictionary;
//	}
//
//    /**
//     * Add the key of a vendor dictionary entry to be removed from the target host instance.
//     * This method may be called multiple time.
//     *
//     * @param removeFromVendorDictionary The keys of the vendor dictionary entries to be removed.
//     */
//	public void removeFromVendorDictionary(String key) {
//        if (removeFromVendorDictionary == null)
//            removeFromVendorDictionary = new LinkedList<>();
//
//        removeFromVendorDictionary.add(key);
//	}
//
//    /**
//     * Is creation of unknown target host to be denied?
//     *
//     * @return True to deny host creation, false to allow.
//     */
//	public boolean isDenyCreate() {
//		return denyCreate;
//	}
//
//    /**
//     * Allow or deny creation of unknown target host.
//     *
//     * @param denyCreate Set true to deny host creation, false to allow.
//     */
//	public void setDenyCreate(boolean denyCreate) {
//		this.denyCreate = denyCreate;
//	}
//
//	/**
//	 * Is access to target host to be denied?
//	 *
//	 * @return True to deny host access, false to allow.
//	 */
//    public boolean isDenyAccess() {
//		return denyAccess;
//	}
//
//    /**
//     * Allow or deny access to target host.
//     *
//     * @param denyAccess Set true to deny host access, false to allow.
//     */
//	public void setDenyAccess(boolean denyAccess) {
//		this.denyAccess = denyAccess;
//	}
//
//	/**
//     * Get the host type name to be set on the target host instance.
//     *
//     * @return The host type name to be set.
//     */
//	public String getHostType() {
//		return hostType;
//	}
//
//    /**
//     * Set the host type name to be set on the target host instance.
//     *
//     * @param hostType The host type name to be set.
//     */
//	public void setHostType(String hostType) {
//		this.hostType = hostType;
//	}
//
//    /**
//     * Get the host owner to be set on the target host instance.
//     *
//     * @return The host owner to be set.
//     */
//	public Long getEnterpriseId() {
//		return enterpriseId;
//	}
//
//    /**
//     * Set the host owner to be set on the target host instance.
//     *
//     * @param enterpriseId The host owner to be set.
//     */
//	public void setEnterpriseId(Long enterpriseId) {
//		this.enterpriseId = enterpriseId;
//	}


}