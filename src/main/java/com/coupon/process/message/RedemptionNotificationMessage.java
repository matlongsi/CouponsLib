package com.coupon.process.message;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.coupon.common.GlobalLocationNumber;


/**
 * Message implementation for CouponRedemptionNotification
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class RedemptionNotificationMessage implements Serializable {

	private static final long serialVersionUID = 7957513622121893954L;

	@NotNull @Valid
	private HeaderMsg header;
	public HeaderMsg getHeader() { return header; }
	public void setHeader(HeaderMsg header) { this.header = header; }

	@NotNull @Valid
	private GlobalLocationNumber awarderGln;
	public GlobalLocationNumber getAwarderGln() { return awarderGln; }
	public void setAwarderGln(GlobalLocationNumber awarderGln) { this.awarderGln = awarderGln; }

	@Size(min=1, message="1 or more CouponRedemptionRecordMessage required.")
	private List<CouponRedemptionRecordMessage> redemptionRecords;
	public List<CouponRedemptionRecordMessage> getRedemptionRecords() { return redemptionRecords; }
	public void setRedemptionRecords(List<CouponRedemptionRecordMessage> redemptionRecords) { this.redemptionRecords = redemptionRecords; }

	/**
     * Default constructor. 
     */
    public RedemptionNotificationMessage() {
    }

}