package com.coupon.common;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.RewardBean;
import com.coupon.common.init.RewardInit;
import com.coupon.common.type.RewardType;
import com.coupon.common.utils.ListCompare;


/**
 * Bean abstract class for OfferReward
 */
@XmlSeeAlso({RewardBean.class})
@XmlDiscriminatorNode("@type")
public abstract class Reward implements Serializable, RewardInit {

	private static final long serialVersionUID = 6474438332201842067L;

    public abstract Float getRewardMonetaryAmount();
	public abstract void setRewardMonetaryAmount(Float rewardMonetaryAmount);

	public abstract RewardType getRewardType();
	public abstract void setRewardType(RewardType rewardType);

	public abstract List<? extends RewardLoyaltyPoint> getRewardLoyaltyPoints();
	public abstract <T extends RewardLoyaltyPoint> void setRewardLoyaltyPoints(List<T> rewardLoyaltyPoints);

	public abstract List<? extends RewardTradeItem> getRewardTradeItems();
	public abstract <T extends RewardTradeItem> void setRewardTradeItems(List<T> rewardTradeItems);

    /**
     * Default constructor. 
     */
    public Reward() {
    }

	@Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !Reward.class.isInstance(obj)) {
	    		return false;
	    	}
	
	    	Reward r = Reward.class.cast(obj);
	
	    	if (getRewardType() != r.getRewardType()) {
	    		return false;
	    	}
	    	switch (getRewardType()) {
	    	
	    	case MONETARY_REWARD:
	    		return (getRewardMonetaryAmount() == null) ?
						(r.getRewardMonetaryAmount() == null) : getRewardMonetaryAmount().equals(r.getRewardMonetaryAmount());
	    		
	    	case LOYALTY_POINTS_REWARD:
	    		return ListCompare.<RewardLoyaltyPoint>equal(getRewardLoyaltyPoints(), r.getRewardLoyaltyPoints());
	    		
	    	case TRADE_ITEM_REWARD:
	    		return ListCompare.<RewardTradeItem>equal(getRewardTradeItems(), r.getRewardTradeItems());
	
	    	default:
	    		return false;
	    	}
    }

	@Override public Reward doInit(Reward r) {
    	
	    	r.setRewardType(getRewardType());
	    	switch(r.getRewardType()) {
	
		case LOYALTY_POINTS_REWARD:
			r.setRewardLoyaltyPoints(getRewardLoyaltyPoints());
			break;
	
	    	case TRADE_ITEM_REWARD:
	    		r.setRewardTradeItems(getRewardTradeItems());
	    		break;
	    		
	    	case MONETARY_REWARD:
	        	r.setRewardMonetaryAmount(getRewardMonetaryAmount());
	    		break;
	    		
		default:
			break;
	    	}
	
	    	return r;
    }

}