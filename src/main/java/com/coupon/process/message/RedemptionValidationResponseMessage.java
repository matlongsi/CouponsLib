package com.coupon.process.message;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.coupon.process.type.ValidationResponseType;


/**
 * Message implementation for ValidateRedemptionResponse
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class RedemptionValidationResponseMessage implements Serializable {

	private static final long serialVersionUID = 7957513622121893954L;
	
	private boolean redeemable;
	public boolean isRedeemable() { return redeemable; }
	public void setRedeemable(boolean redeemable) { this.redeemable = redeemable; }
	
	private List<ValidationResponseType> responses;
	public List<ValidationResponseType> getResponses() { return responses; }
	public void setResponses(List<ValidationResponseType> responses) { this.responses = responses; }

	private long validationReference;
	public long getValidationReference() { return validationReference; }
	public void setValidationReference(long validationReference) { this.validationReference = validationReference; }	
	
	/**
     * Default constructor. 
     */
    public RedemptionValidationResponseMessage() {
    }

}