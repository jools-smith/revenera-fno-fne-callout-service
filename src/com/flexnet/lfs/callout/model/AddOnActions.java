package com.flexnet.lfs.callout.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.revenera.gcs.utils.Log;

import java.util.Date;

/**
 * This class defines the add-on specific actions to be performed upon return from the capability request call-out
 */
public class AddOnActions {
  private final static Log logger = Log.create(AddOnActions.class);

  public String activationId;
  public boolean skipConfirmation;
  public boolean denied;
  public Date expiration;

  @JsonIgnore
  public Builder createBuilder() {
    return new Builder();
  }

  public class Builder {

    private Builder() {
    }

    public Builder withActivationId(final String activationId) {
      AddOnActions.this.activationId = activationId;
      return this;
    }
    public Builder withSkipConfirmation(final boolean skipConfirmation) {
      AddOnActions.this.skipConfirmation = skipConfirmation;
      return this;
    }
    public Builder withDenied(final boolean denied) {
      AddOnActions.this.denied = denied;
      return this;
    }
    public Builder withExpiration(final Date expiration) {
      AddOnActions.this.expiration = expiration;
      return this;
    }
    public void build() {
      logger.json(Log.Level.info, AddOnActions.this);
    }
  }
//
//  /**
//   * Get the activation ID of the add-on to perform actions upon.
//   *
//   * @return The activation ID of the target add-on.
//   */
//  public String getActivationId() {
//    return activationId;
//  }
//
//  /**
//   * Set the activation ID of the add-on to perform actions upon.
//   *
//   * @param activationId The activation ID of the target add-on.
//   */
//  public void setActivationId(String activationId) {
//    this.activationId = activationId;
//  }
//
//  /**
//   * Should copy reduction confirmation be skipped for the target add-on?
//   *
//   * @return True to skip confirmation, false to enforce.
//   */
//  public boolean isSkipConfirmation() {
//    return skipConfirmation;
//  }
//
//  /**
//   * Skip or enforce copy reduction confirmation for the target add-on.
//   *
//   * @param skipConfirmation Set true to skip confirmation, false to enforce.
//   */
//  public void setSkipConfirmation(boolean skipConfirmation) {
//    this.skipConfirmation = skipConfirmation;
//  }
//
//  /**
//   * Is this add-on to be denied mapping (if not mapped) or not included in the generated license?
//   *
//   * @return True to deny inclusion or mapping, false to allow.
//   */
//  public boolean isDenied() {
//    return denied;
//  }
//
//  /**
//   * Allow or deny mapping or inclusion for the target add-on.
//   *
//   * @param denied Set true to deny inclusion or mapping, false to allow.
//   */
//  public void setDenied(boolean denied) {
//    this.denied = denied;
//  }
//
//  /**
//   * Get the expiration override to be set on the target add-on.
//   *
//   * @return The expiration override date.
//   */
//  public Date getExpiration() {
//    return expiration;
//  }
//
//  /**
//   * Set the expiration override to be set on the target add-on.
//   *
//   * @param expiration The expiration override date.
//   */
//  public void setExpiration(Date expiration) {
//    this.expiration = expiration;
//  }
//
//  @Override
//  public boolean equals(Object other) {
//    return other instanceof AddOnActions && ((AddOnActions) other).activationId.equals(activationId);
//  }


}