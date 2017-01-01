package com.coupon.process.message;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Message implementation for OfferNotificationReceipt
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class OfferNotificationReceiptMessage implements Serializable {

	private static final long serialVersionUID = -2999202225688505080L;
	
	@NotNull @Valid
	private HeaderMsg header;
	public HeaderMsg getHeader() { return header; }
	public void setHeader(HeaderMsg header) { this.header = header; }

	@NotNull
    private long reference;
	public long getReference() { return reference; }
	public void setReference(long reference) { this.reference = reference; }

	/**
     * Default constructor. 
     */
    public OfferNotificationReceiptMessage() {
    }

}