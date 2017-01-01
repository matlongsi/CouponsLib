package com.coupon.common.bean;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.ConvertGroup;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.Reward;
import com.coupon.common.RewardLoyaltyPoint;
import com.coupon.common.RewardTradeItem;
import com.coupon.common.init.RewardInit;
import com.coupon.common.type.RewardType;
import com.coupon.common.validator.Amount;
import com.coupon.common.validator.ChildValidate;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation class for Reward
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("RewardBean")
public class RewardBean extends Reward implements Bean, Hierarchy {

	private static final long serialVersionUID = 6474438332201842067L;

	@Null(message="rId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="rId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="rId needs to be unsigned number of 19 digits or less.")
	private Long rId;
    @Override public Long getId() { return rId; }
	@Override public void setId(Long rId) { this.rId = rId; }

	@NotNull(message="offerId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="offerId needs to be unsigned number of 19 digits or less.")
	private Long offerId;
	@Override public Long getParentId() { return offerId; }
	@Override public void setParentId(Long offerId) { this.offerId = offerId; }

	@NotNull(message="rewardType is required.")
	private RewardType rewardType;
	@Override public RewardType getRewardType() { return rewardType; }
	@Override public void setRewardType(RewardType rewardType) { this.rewardType = rewardType; }

	@Amount(totalDigits=10, decimalDigits=2, optional=true,
			message="rewardMonetaryAmount should be of 10 digits or less, with no more than 2 decimal digits.")
	private Float rewardMonetaryAmount;
    @Override public Float getRewardMonetaryAmount() { return rewardMonetaryAmount; }
	@Override public void setRewardMonetaryAmount(Float rewardMonetaryAmount) { this.rewardMonetaryAmount = rewardMonetaryAmount; }

    @Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private List<RewardLoyaltyPointBean> rewardLoyaltyPoints;
	@Override public List<RewardLoyaltyPointBean> getRewardLoyaltyPoints() { return rewardLoyaltyPoints; }
	@Override public <T extends RewardLoyaltyPoint> void setRewardLoyaltyPoints(List<T> rewardLoyaltyPoints) {

		this.rewardLoyaltyPoints = new ArrayList<RewardLoyaltyPointBean>();
		for (T rlp : rewardLoyaltyPoints) {
			this.rewardLoyaltyPoints.add(new RewardLoyaltyPointBean().init(rlp));
		}
	}

    @Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private List<RewardTradeItemBean> rewardTradeItems;
	@Override public List<RewardTradeItemBean> getRewardTradeItems() { return rewardTradeItems; }
	@Override public <T extends RewardTradeItem> void setRewardTradeItems(List<T> rewardTradeItems) {

		this.rewardTradeItems = new ArrayList<RewardTradeItemBean>();
		for (T rti : rewardTradeItems) {
			this.rewardTradeItems.add(new RewardTradeItemBean().init(rti));
		}
	}

    /**
     * Default constructor. 
     */
    public RewardBean() {
    }

	@Override public RewardBean init(RewardInit ri) {
    	
		ri.dispatchInit(this);

		return this;
	}

	@Override public RewardBean dispatchInit(RewardBean rb) {
    	
		super.dispatchInit(rb);

	    	rb.setId(getId());
	    	rb.setParentId(getParentId());

	    	return rb;
	}

}