package com.coupon.common.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.RewardLoyaltyPoint;
import com.coupon.common.init.RewardLoyaltyPointInit;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation class for RewardLoyaltyPoint
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("RewardLoyaltyPointBean")
public class RewardLoyaltyPointBean extends RewardLoyaltyPoint implements Bean, Hierarchy {

	private static final long serialVersionUID = -6327726101195496039L;

	@Null(message="rlpId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="rlpId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="rlpId needs to be unsigned number of 19 digits or less.")
	private Long rlpId;
	@Override public Long getId() { return rlpId; }
	@Override public void setId(Long rlpId) { this.rlpId = rlpId; }

	@NotNull(message="rId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="rId needs to be unsigned number of 19 digits or less.")
	private Long rId;
	@Override public Long getParentId() { return rId; }
	@Override public void setParentId(Long rId) { this.rId = rId; }

	@NotNull(message="loyaltyProgramName is required.")
	@Size(max=MAX_LOYALTY_PROGRAM_NAME_LENGTH,
			message="loyaltyProgramName needs to be " + MAX_LOYALTY_PROGRAM_NAME_LENGTH + " characters or less.")
	private String loyaltyProgramName;
	@Override public String getLoyaltyProgramName() { return loyaltyProgramName; }
    @Override public void setLoyaltyProgramName(String loyaltyProgramName) { this.loyaltyProgramName = loyaltyProgramName; }

	@NotNull(message="loyaltyPointsQuantity is required.")
	private Integer loyaltyPointsQuantity;
	@Override public Integer getLoyaltyPointsQuantity() { return loyaltyPointsQuantity; }
	@Override public void setLoyaltyPointsQuantity(Integer loyaltyPointsQuantity) { this.loyaltyPointsQuantity = loyaltyPointsQuantity; }

	/**
     * Default constructor. 
     */
    public RewardLoyaltyPointBean() {
    }

	@Override public RewardLoyaltyPointBean init(RewardLoyaltyPointInit rlpi) {

		rlpi.dispatchInit(this);

		return this;
    }

	@Override public RewardLoyaltyPointBean dispatchInit(RewardLoyaltyPointBean rlpb) {

		super.dispatchInit(rlpb);

	    	rlpb.setId(getId());
	    	rlpb.setParentId(getParentId());
	    	
	    	return rlpb;
    }

}