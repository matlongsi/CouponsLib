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

import com.coupon.common.GlobalLocationNumber;


/**
 * Message implementation for Header
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class HeaderMsg implements Serializable {

	private static final long serialVersionUID = -428833685611668190L;

	@NotNull(message="referenceId is a required element of HeaderMessage.")
	private long referenceId;
	public long getReferenceId() { return referenceId; }
	public void setReferenceId(long referenceId) { this.referenceId = referenceId; }

	@NotNull(message="senderNumber is a required element of HeaderMessage.") @Valid
	private GlobalLocationNumber senderNumber;
	public GlobalLocationNumber getSenderNumber() { return senderNumber; }
	public void setSenderNumber(GlobalLocationNumber senderNumber) { this.senderNumber = senderNumber; }

	@NotNull(message="recipientNumber is a required element of HeaderMessage.") @Valid
	private GlobalLocationNumber recipientNumber;
	public GlobalLocationNumber getRecipientNumber() { return recipientNumber; }
	public void setRecipientNumber(GlobalLocationNumber recipientNumber) { this.recipientNumber = recipientNumber; }

	@NotNull(message="creationDateTime is a required element of HeaderMessage.") @Past(message="creationDateTime must be in past.")
	private Date creationDateTime;
	public Date getCreationDateTime() { return creationDateTime; }
	public void setCreationDateTime(Date creationDateTime) { this.creationDateTime = creationDateTime; }

	@Past(message="changeDateTime must be in past.")
	private Date changeDateTime;
	public Date getChangeDateTime() { return changeDateTime; }
	public void setChangeDateTime(Date changeDateTime) { this.changeDateTime = changeDateTime; }

	private String changeReason;
	public String getChangeReason() { return changeReason; }
	public void setChangeReason(String changeReason) { this.changeReason = changeReason; }

	/**
     * Default constructor. 
     */
    public HeaderMsg() {
    }

}