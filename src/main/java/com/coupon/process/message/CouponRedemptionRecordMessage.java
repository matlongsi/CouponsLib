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
import com.coupon.common.AwarderPointOfSale;
import com.coupon.common.validator.GlobalNumber;


/**
 * Message implementation for CouponRedemptionRecord
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class CouponRedemptionRecordMessage implements Serializable {

	private static final long serialVersionUID = 7957513622121893954L;

	@Valid
	private GlobalLocationNumberBean storeGln;
	public GlobalLocationNumberBean getStoreGln() { return storeGln; }
	public void setStoreGln(GlobalLocationNumberBean storeGln) { this.storeGln = storeGln; }

	@Size(max=AwarderPointOfSale.MAX_STORE_INTERNAL_ID_LENGTH,
			message="storeInternalId needs to be of " + AwarderPointOfSale.MAX_STORE_INTERNAL_ID_LENGTH + " characters or less.")
	private String storeInternalId;
	public String getStoreInternalId() { return storeInternalId; }
	public void setStoreInternalId(String storeInternalId) { this.storeInternalId = storeInternalId; }

	@Size(max=AwarderPointOfSale.MAX_POS_TERMINAL_ID_LENGTH,
			message="posTerminalId needs to be of " + AwarderPointOfSale.MAX_POS_TERMINAL_ID_LENGTH + " characters or less.")
	private String posTerminalId;
	public String getPosTerminalId() { return posTerminalId; }
	public void setPosTerminalId(String posTerminalId) { this.posTerminalId = posTerminalId; }
	
	@NotNull @GlobalNumber(serializable=true)
	private GlobalCouponNumberBean couponInstance;
	public GlobalCouponNumberBean getCouponInstance() { return couponInstance; }
	public void setCouponInstance(GlobalCouponNumberBean couponInstance) { this.couponInstance = couponInstance; }
	
	@Valid
	private GlobalServiceRelationNumberBean accountNumber;
	public GlobalServiceRelationNumberBean getAccountNumber() { return accountNumber; }
	public void setAccountNumber(GlobalServiceRelationNumberBean accountNumber) { this.accountNumber = accountNumber; }

	@Size(max=GlobalServiceRelationNumber.ALTERNATE_ACCOUNT_ID_LENGTH,
			message="alternateAccountId needs to be of " + GlobalServiceRelationNumber.ALTERNATE_ACCOUNT_ID_LENGTH + " characters or less.")
	private String alternateAccountId;
	public String getAlternateAccountId() { return alternateAccountId; }
	public void setAlternateAccountId(String alternateAccountId) { this.alternateAccountId = alternateAccountId; }

	@NotNull @Past
	private Date redemptionDateTime;
	public Date getRedemptionDateTime() { return redemptionDateTime; }
	public void setRedemptionDateTime(Date redemptionDateTime) { this.redemptionDateTime = redemptionDateTime; }

	private float rewardMonetaryAmount;
	public float getRewardMonetaryAmount() { return rewardMonetaryAmount; }
	public void setRewardMonetaryAmount(float rewardMonetaryAmount) { this.rewardMonetaryAmount = rewardMonetaryAmount; }

    private List<RewardLoyaltyPointMsg> rewardLoyaltyPoints;
	public List<RewardLoyaltyPointMsg> getRewardLoyaltyPoints() { return rewardLoyaltyPoints; }
	public void setRewardLoyaltyPoints(List<RewardLoyaltyPointMsg> rewardLoyaltyPoints) { this.rewardLoyaltyPoints = rewardLoyaltyPoints; }

    private List<RewardTradeItemMsg> rewardTradeItems;
	public List<RewardTradeItemMsg> getRewardTradeItems() { return rewardTradeItems; }
	public void setRewardTradeItems(List<RewardTradeItemMsg> rewardTradeItems) { this.rewardTradeItems = rewardTradeItems; }

	private float qualifyingPurchaseAmount;
	public float getQualifyingPurchaseAmount() { return qualifyingPurchaseAmount; }
	public void setQualifyingPurchaseAmount(float qualifyingPurchaseAmount) { this.qualifyingPurchaseAmount = qualifyingPurchaseAmount; }

    private List<QualifyingTradeItemMsg> qualifyingTradeItems;
	public List<QualifyingTradeItemMsg> getQualifyingTradeItems() { return qualifyingTradeItems; }
	public void setQualifyingTradeItems(List<QualifyingTradeItemMsg> qualifyingTradeItems) { this.qualifyingTradeItems = qualifyingTradeItems; }

	private String validationOverrideReference;
	public String getValidationOverrideReference() { return validationOverrideReference; }
	public void setValidationOverrideReference(String validationOverrideReference) { this.validationOverrideReference = validationOverrideReference; }

	/**
     * Default constructor.
     */
    public CouponRedemptionRecordMessage() {
    }

}