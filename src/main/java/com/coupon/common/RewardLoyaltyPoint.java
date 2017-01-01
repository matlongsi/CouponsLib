package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.RewardLoyaltyPointBean;
import com.coupon.common.init.RewardLoyaltyPointInit;
import com.coupon.process.message.RewardLoyaltyPointMsg;


/**
 * Bean abstract class for OfferRewardLoyaltyPoints
 */
@XmlSeeAlso({RewardLoyaltyPointBean.class, RewardLoyaltyPointMsg.class})
@XmlDiscriminatorNode("@type")
public abstract class RewardLoyaltyPoint implements Serializable, Comparable<RewardLoyaltyPoint>, RewardLoyaltyPointInit {

	private static final long serialVersionUID = -6327726101195496039L;

	public static final int MAX_LOYALTY_PROGRAM_NAME_LENGTH = 50;
	
    public abstract String getLoyaltyProgramName();
	public abstract void setLoyaltyProgramName(String loyaltyProgramName);

	public abstract Integer getLoyaltyPointsQuantity();
	public abstract void setLoyaltyPointsQuantity(Integer loyaltyPointsQuantity);

	/**
     * Default constructor. 
     */
    public RewardLoyaltyPoint() {
    }

    @Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !RewardLoyaltyPoint.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	RewardLoyaltyPoint rlp = RewardLoyaltyPoint.class.cast(obj);
	    	
	    	return (getLoyaltyPointsQuantity() == null) ?
					(rlp.getLoyaltyPointsQuantity() == null) : getLoyaltyPointsQuantity().equals(rlp.getLoyaltyPointsQuantity()) &&
	    			((getLoyaltyProgramName() == null) ?
	    				(rlp.getLoyaltyProgramName() == null) : getLoyaltyProgramName().equals(rlp.getLoyaltyProgramName()));
    }

    @Override public int compareTo(RewardLoyaltyPoint rlp) {
    	
	    	//ascending
	    	return (getLoyaltyProgramName() != null) ?
	    				getLoyaltyProgramName().compareTo(rlp.getLoyaltyProgramName()) :
	    			(rlp.getLoyaltyProgramName() == null) ? 0 : -1;
    }
    
	@Override public RewardLoyaltyPoint doInit(RewardLoyaltyPoint rlp) {
		
	    	rlp.setLoyaltyPointsQuantity(getLoyaltyPointsQuantity());
	    	rlp.setLoyaltyProgramName(getLoyaltyProgramName());
	    	
	    	return rlp;
    }

}