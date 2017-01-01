package com.coupon.process.message;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.coupon.common.GlobalCouponNumber;
import com.coupon.common.bean.GlobalCouponNumberBean;
import com.coupon.common.GlobalServiceRelationNumber;
import com.coupon.common.bean.GlobalServiceRelationNumberBean;
import com.coupon.common.validator.GlobalNumber;


/**
 * Message implementation for AcquisitionNotification
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class AcquisitionNotificationMessage implements Serializable {

	private static final long serialVersionUID = 7957513622121893954L;

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

	@Valid
	private GlobalServiceRelationNumber accountNumber;
	public GlobalServiceRelationNumber getAccountNumber() { return accountNumber; }
	public void setAccountNumber(GlobalServiceRelationNumber accountNumber) {
		
		this.accountNumber = new GlobalServiceRelationNumberBean().init(accountNumber);
	}

	@Size(max=GlobalServiceRelationNumber.ALTERNATE_ACCOUNT_ID_LENGTH,
			message="alternateAccountId needs to be of " + GlobalServiceRelationNumber.ALTERNATE_ACCOUNT_ID_LENGTH + " characters or less.")
	private String alternateAccountId;
	public String getAlternateAccountId() { return alternateAccountId; }
	public void setAlternateAccountId(String alternateAccountId) { this.alternateAccountId = alternateAccountId; }

	/**
     * Default constructor. 
     */
    public AcquisitionNotificationMessage() {
    }

}