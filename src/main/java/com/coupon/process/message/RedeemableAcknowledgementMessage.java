package com.coupon.process.message;

import java.io.Serializable;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.coupon.common.GlobalCouponNumber;
import com.coupon.common.bean.GlobalCouponNumberBean;
import com.coupon.common.validator.GlobalNumber;
import com.coupon.process.type.AcquisitionResponseType;


/**
 * Message implementation for RedeemableAcknowledgement
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class RedeemableAcknowledgementMessage implements Serializable {

	private static final long serialVersionUID = -2999202225688505080L;
	
	@NotNull @Valid
	private HeaderMsg header;
	public HeaderMsg getHeader() { return header; }
	public void setHeader(HeaderMsg header) { this.header = header; }

	@NotNull @GlobalNumber(serializable=true)
	private GlobalCouponNumber couponInstance;
	public GlobalCouponNumber getCouponInstance() { return couponInstance; }
	public void setCouponInstance(GlobalCouponNumber couponInstance) {
		
		this.couponInstance = new GlobalCouponNumberBean().init(couponInstance);
	}
	
	@NotNull
    private AcquisitionResponseType responseCode;
	public AcquisitionResponseType getResponseCode() { return responseCode; }
	public void setResponseCode(AcquisitionResponseType responseCode) { this.responseCode = responseCode; }

	@Past
	private Date acknowledgeDateTime;
	public Date getAcknowledgeDateTime() { return acknowledgeDateTime; }
	public void setAcknowledgeDateTime(Date acknowledgeDateTime) { this.acknowledgeDateTime = acknowledgeDateTime; }

	/**
     * Default constructor.
     */
    public RedeemableAcknowledgementMessage() {
    }

}