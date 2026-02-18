package com.flexnet.lfs.callout.model;

import java.util.Date;

/**
 * This class holds the target host add-on information passed to the capability request call-out
 */
public class AddOnInfo {
  public String activationId;
  public int requested;
  public int consumed;
  public boolean waitingForConfirmation;
  public Date expirationOveride;
  public Date createDate;
  public Date lastModifiedDate;
  public String licenseModel;
  public String vendorString;
  public String notice;
  public String serialNumber;
  public String issuer;

//  /**
//   * Get the add-on's activation ID.
//   *
//   * @return The add-on's activation ID.
//   */
//  public String getActivationId() {
//    return activationId;
//  }
//
//  /**
//   * Set the add-on's activation ID.
//   * This method is used internally for JSON deserialization.
//   *
//   * @param activationId The add-on's new activation ID.
//   */
//  public void setActivationId(String activationId) {
//    this.activationId = activationId;
//  }
//
//  /**
//   * Get the number of copies requested for this add-on.
//   *
//   * @return The number of copies requested.
//   */
//  public int getRequested() {
//    return requested;
//  }
//
//  /**
//   * Set the number of copies requested for this add-on.
//   * This method is used internally for JSON deserialization.
//   *
//   * @param requested The new number of copies requested.
//   */
//  public void setRequested(int requested) {
//    this.requested = requested;
//  }
//
//  /**
//   * Get the number of copies consumed for this add-on.
//   *
//   * @return The number of copies consumed.
//   */
//  public int getConsumed() {
//    return consumed;
//  }
//
//  /**
//   * Set the number of copies consumed for this add-on.
//   * This method is used internally for JSON deserialization.
//   *
//   * @param consumed The new  number of copies consumed.
//   */
//  public void setConsumed(int consumed) {
//    this.consumed = consumed;
//  }
//
//  /**
//   * Is this add-on waiting for confirmation to reduce the number of copies consumed for this add-on?
//   *
//   * @return True if waiting for confirmation, false otherwise.
//   */
//  public boolean isWaitingForConfirmation() {
//    return waitingForConfirmation;
//  }
//
//  /**
//   * Set waiting for confirmation status for this add-on.
//   * This method is used internally for JSON deserialization.
//   *
//   * @param waitingForConfirmation Set true if waiting for confirmation, false otherwise.
//   */
//  public void setWaitingForConfirmation(boolean waitingForConfirmation) {
//    this.waitingForConfirmation = waitingForConfirmation;
//  }
//
//  /**
//   * Get the expiration date override for this add-on.
//   *
//   * @return The expiration date override, or null if the entitlement expiration will be used.
//   */
//  public Date getExpirationOveride() {
//    return expirationOveride;
//  }
//
//  /**
//   * Set the expiration date override for this add-on.
//   * This method is used internally for JSON deserialization.
//   *
//   * @param expirationOveride The new expiration date override.
//   */
//  public void setExpirationOveride(Date expirationOveride) {
//    this.expirationOveride = expirationOveride;
//  }
//
//  /**
//   * Get the name of the license model used for this add-on.
//   *
//   * @return The license model name.
//   */
//  public String getLicenseModel() {
//    return licenseModel;
//  }
//
//  /**
//   * Set the name of the license model used for this add-on.
//   * This method is used internally for JSON deserialization.
//   *
//   * @param licenseModel The new license model name.
//   */
//  public void setLicenseModel(String licenseModel) {
//    this.licenseModel = licenseModel;
//  }
//
//  /**
//   * Get the vendor string for this add-on.
//   *
//   * @return The vendor string, or null if none defined.
//   */
//  public String getVendorString() {
//    return vendorString;
//  }
//
//  /**
//   * Set the vendor string for this add-on.
//   * This method is used internally for JSON deserialization.
//   *
//   * @param vendorString The new vendor string.
//   */
//  public void setVendorString(String vendorString) {
//    this.vendorString = vendorString;
//  }
//
//  /**
//   * Get the notice for this add-on.
//   *
//   * @return The notice, or null if none defined.
//   */
//  public String getNotice() {
//    return notice;
//  }
//
//  /**
//   * Set the notice for this add-on.
//   * This method is used internally for JSON deserialization.
//   *
//   * @param notice The new notice.
//   */
//  public void setNotice(String notice) {
//    this.notice = notice;
//  }
//
//  /**
//   * Get the serial number for this add-on.
//   *
//   * @return The serial number, or null if none defined.
//   */
//  public String getSerialNumber() {
//    return serialNumber;
//  }
//
//  /**
//   * Set the serial number for this add-on.
//   * This method is used internally for JSON deserialization.
//   *
//   * @param serialNumber The serial number, or null if none defined.
//   */
//  public void setSerialNumber(String serialNumber) {
//    this.serialNumber = serialNumber;
//  }
//
//  /**
//   * Get the issuer for this add-on.
//   *
//   * @return The issuer, or null if none defined.
//   */
//  public String getIssuer() {
//    return issuer;
//  }
//
//  /**
//   * Set the issuer for this add-on.
//   * This method is used internally for JSON deserialization.
//   *
//   * @param issuer The issuer, or null if none defined.
//   */
//  public void setIssuer(String issuer) {
//    this.issuer = issuer;
//  }


}