package com.coupon.process.message;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.coupon.common.bean.GlobalCouponNumberBean;
import com.coupon.common.bean.GlobalLocationNumberBean;
import com.coupon.common.GlobalServiceRelationNumber;
import com.coupon.common.bean.GlobalServiceRelationNumberBean;
import com.coupon.common.validator.GlobalNumber;


/**
 * Message implementation for ValidateRedemptionRequest
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class RedemptionValidationRequestMessage implements Serializable {

	private static final long serialVersionUID = 7957513622121893954L;

	@NotNull @Valid
	private HeaderMsg header;
	public HeaderMsg getHeader() { return header; }
	public void setHeader(HeaderMsg header) { this.header = header; }

	@NotNull @GlobalNumber
	private GlobalCouponNumberBean couponNumber;
	public GlobalCouponNumberBean getCouponNumber() { return couponNumber; }
	public void setCouponNumber(GlobalCouponNumberBean couponNumber) { this.couponNumber = couponNumber; }

	@NotNull @Valid
	private GlobalLocationNumberBean awarderNumber;
	public GlobalLocationNumberBean getAwarderNumber() { return awarderNumber; }
	public void setAwarderNumber(GlobalLocationNumberBean awarderNumber) { this.awarderNumber = awarderNumber; }

	@Valid
	private GlobalServiceRelationNumberBean accountNumber;
	public GlobalServiceRelationNumberBean getAccountNumber() { return accountNumber; }
	public void setAccountNumber(GlobalServiceRelationNumberBean accountNumber) { this.accountNumber = accountNumber; }

	@Size(max=GlobalServiceRelationNumber.ALTERNATE_ACCOUNT_ID_LENGTH,
			message="alternateAccountId needs to be of " + GlobalServiceRelationNumber.ALTERNATE_ACCOUNT_ID_LENGTH + " characters or less.")
	private String alternateAccountId;
	public String getAlternateAccountId() { return alternateAccountId; }
	public void setAlternateAccountId(String alternateAccountId) { this.alternateAccountId = alternateAccountId; }

	@Past
	private Date validateDateTime;
	public Date getValidateDateTime() { return validateDateTime; }
	public void setValidateDateTime(Date validateDateTime) { this.validateDateTime = validateDateTime; }

	private float purchaseMonetaryAmount;
	public float getPurchaseMonetaryAmount() { return purchaseMonetaryAmount; }
	public void setPurchaseMonetaryAmount(float purchaseMonetaryAmount) { this.purchaseMonetaryAmount = purchaseMonetaryAmount; }

	@Valid
    private List<QualifyingTradeItemMsg> purchaseTradeItems;
	public List<QualifyingTradeItemMsg> getPurchaseTradeItems() { return purchaseTradeItems; }
	public void setPurchaseTradeItems(List<QualifyingTradeItemMsg> purchaseTradeItems) { this.purchaseTradeItems = purchaseTradeItems; }

	/**
     * Default constructor. 
     */
    public RedemptionValidationRequestMessage() {
    }

}