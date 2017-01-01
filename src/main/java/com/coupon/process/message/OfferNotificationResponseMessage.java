package com.coupon.process.message;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.coupon.common.GlobalCouponNumber;
import com.coupon.common.bean.GlobalCouponNumberBean;
import com.coupon.common.GlobalLocationNumber;
import com.coupon.common.bean.GlobalLocationNumberBean;
import com.coupon.common.validator.GlobalNumber;
import com.coupon.process.type.NotificationResponseType;


/**
 * Message implementation for OfferNotificationResponse
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class OfferNotificationResponseMessage implements Serializable {

	private static final long serialVersionUID = -4092658656579612092L;
	
	@NotNull @Valid
	private HeaderMsg header;
	public HeaderMsg getHeader() { return header; }
	public void setHeader(HeaderMsg header) { this.header = header; }

	@NotNull @Valid
	private GlobalLocationNumber issuerNumber;
	public GlobalLocationNumber getIssuerNumber() { return issuerNumber; }
	public void setIssuerNumber(GlobalLocationNumber issuerNumber) {

		this.issuerNumber = new GlobalLocationNumberBean().init(issuerNumber);
	}
	
	@Valid
	private GlobalLocationNumber issuerClearingAgentNumber;
	public GlobalLocationNumber getIssuerClearingAgentNumber() { return issuerClearingAgentNumber; }
	public void setIssuerClearingAgentNumber(GlobalLocationNumber issuerClearingAgentNumber) {

		this.issuerClearingAgentNumber = new GlobalLocationNumberBean().init(issuerClearingAgentNumber);
	}

	@NotNull @Valid
	private GlobalLocationNumber awarderNumber;
	public GlobalLocationNumber getAwarderNumber() { return awarderNumber; }
	public void setAwarderNumber(GlobalLocationNumber awarderNumber) {

		this.awarderNumber = new GlobalLocationNumberBean().init(awarderNumber);
	}
	
	@Valid
	private GlobalLocationNumber awarderClearingAgentNumber;
	public GlobalLocationNumber getAwarderClearingAgentNumber() { return awarderClearingAgentNumber; }
	public void setAwarderClearingAgentNumber(GlobalLocationNumber awarderClearingAgentNumber) {

		this.awarderClearingAgentNumber = new GlobalLocationNumberBean().init(awarderClearingAgentNumber);
	}

	@NotNull @GlobalNumber(serializable=false)
	private GlobalCouponNumber offerNumber;
	public GlobalCouponNumber getOfferNumber() { return offerNumber; }
	public void setOfferNumber(GlobalCouponNumber offerNumber) {
		
		this.offerNumber = new GlobalCouponNumberBean().init(offerNumber);
	}
	
	@NotNull
    private NotificationResponseType responseCode;
	public NotificationResponseType getResponseCode() { return responseCode; }
	public void setResponseCode(NotificationResponseType responseCode) { this.responseCode = responseCode; }

	/**
     * Default constructor.
     */
    public OfferNotificationResponseMessage() {
    }

}