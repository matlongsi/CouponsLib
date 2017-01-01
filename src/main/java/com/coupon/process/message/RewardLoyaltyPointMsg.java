package com.coupon.process.message;

import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.RewardLoyaltyPoint;
import com.coupon.common.init.RewardLoyaltyPointInit;


/**
 * Message implementation class for RewardLoyaltyPoint
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("RewardLoyaltyPointMsg")
public class RewardLoyaltyPointMsg extends RewardLoyaltyPoint {

	private static final long serialVersionUID = -6327726101195496039L;

	@Size(max=RewardLoyaltyPoint.MAX_LOYALTY_PROGRAM_NAME_LENGTH,
			message="loyaltyProgramName needs to be " + RewardLoyaltyPoint.MAX_LOYALTY_PROGRAM_NAME_LENGTH + " characters or less.")
	private String loyaltyProgramName;
    @Override public String getLoyaltyProgramName() { return loyaltyProgramName; }
    @Override public void setLoyaltyProgramName(String loyaltyProgramName) { this.loyaltyProgramName = loyaltyProgramName; }

	private Integer rewardedLoyaltyPointsQuantity;
	@Override public Integer getLoyaltyPointsQuantity() { return rewardedLoyaltyPointsQuantity; }
	@Override public void setLoyaltyPointsQuantity(Integer rewardedLoyaltyPointsQuantity) { this.rewardedLoyaltyPointsQuantity = rewardedLoyaltyPointsQuantity; }

	/**
     * Default constructor. 
     */
    public RewardLoyaltyPointMsg() {
    }

    @Override public RewardLoyaltyPointMsg init(RewardLoyaltyPointInit rlpi) {
    	
    	rlpi.dispatchInit(this);
    	
    	return this;
    }

}