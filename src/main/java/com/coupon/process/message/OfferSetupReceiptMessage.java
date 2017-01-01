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


/**
 * Message implementation for OfferSetupReceipt
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class OfferSetupReceiptMessage implements Serializable {

	private static final long serialVersionUID = 1382007009419363744L;
	
	@NotNull(message="header is a required element of OfferSetupReceiptMessage.") @Valid
	private HeaderMsg header;
	public HeaderMsg getHeader() { return header; }
	public void setHeader(HeaderMsg header) { this.header = header; }

	@NotNull(message="reference is a required element of OfferSetupReceiptMessage.")
    private long reference;
	public long getReference() { return reference; }
	public void setReference(long reference) { this.reference = reference; }

	@Past(message="acknowledgeDateTime must be in past.")
	private Date acknowledgeDateTime;
	public Date getAcknowledgeDateTime() { return acknowledgeDateTime; }
	public void setAcknowledgeDateTime(Date acknowledgeDateTime) { this.acknowledgeDateTime = acknowledgeDateTime; }

	/**
     * Default constructor. 
     */
    public OfferSetupReceiptMessage() {
    }

}