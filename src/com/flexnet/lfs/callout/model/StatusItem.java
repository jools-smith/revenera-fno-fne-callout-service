package com.flexnet.lfs.callout.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flexnet.lm.SharedConstants.PropStatusCode;

/** This class holds a status list item passed to the capability request call-out */
public class StatusItem {
  public int code;
  public String detail;

  public StatusItem(int code, String detail) {
    this.code = code;
    this.detail = detail;
  }

//    /** Create uninitialized status item. */
//    public StatusItem() {}
//
//    /**
//     * Create status item.
//     *
//     * @param code The status code, as a number.
//     * @param detail The detail message.
//     */

//
//    /**
//     * Create status item.
//     *
//     * @param code The status code, as a status code enumeration value.
//     *             Translated to a number internally.
//     * @param detail The detail message.
//     */
//    public StatusItem(PropStatusCode code, String detail) {
//        setStatus(code);
//        setDetail(detail);
//    }
//
//    /**
//     * Get the status code for this item.
//     *
//     * @return The status code.
//     */
//    public int getCode() {
//		return code;
//	}
//
//    /**
//     * Set the status code for this item.
//     * @param code The status code, as a number.
//     */
//	public void setCode(int code) {
//		this.code = code;
//	}
//
//    /**
//     * Set the status code for this item.
//     * @param code The status code, as a status code enumeration value.
//     *             Translated to a number internally.
//     */
//	@JsonIgnore
//	public void setStatus(PropStatusCode code) {
//		this.code = code.getId();
//	}
//
//    /**
//     * Get the detail message for this item.
//     *
//     * @return The detail message.
//     */
//	public String getDetail() {
//		return detail;
//	}
//
//    /**
//     * Set the detail message for this item.
//     *
//     * @param detail The new detail message.
//     */
//	public void setDetail(String detail) {
//		this.detail = detail;
//	}
//

}