package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.RewardTradeItemBean;
import com.coupon.common.init.RewardTradeItemInit;
import com.coupon.process.message.RewardTradeItemMsg;


/**
 * Bean abstract class for OfferRewardTradeItem
 */
@XmlSeeAlso({RewardTradeItemBean.class, RewardTradeItemMsg.class})
@XmlDiscriminatorNode("@type")
public abstract class RewardTradeItem implements Serializable, Comparable<RewardTradeItem>, RewardTradeItemInit {

	private static final long serialVersionUID = 906540110768575117L;

    public abstract GlobalTradeIdentificationNumber getTradeItemNumber();
	public abstract void setTradeItemNumber(GlobalTradeIdentificationNumber tradeItemNumber);

	public abstract Short getTradeItemQuantity();
	public abstract void setTradeItemQuantity(Short tradeItemQuantity);

    /**
     * Default constructor. 
     */
    public RewardTradeItem() {
    }

    @Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !RewardTradeItem.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	RewardTradeItem rti = RewardTradeItem.class.cast(obj);
	    	
	    	return ((getTradeItemQuantity() == rti.getTradeItemQuantity()) &&
	    			((getTradeItemNumber() == null) ?
	    				(rti.getTradeItemNumber() == null) : getTradeItemNumber().equals(rti.getTradeItemNumber())));
    }

    @Override public int compareTo(RewardTradeItem rti) {
    	
	    	//ascending
	    	return (getTradeItemNumber() != null) ?
	    				getTradeItemNumber().compareTo(rti.getTradeItemNumber()) :
	    			(rti.getTradeItemNumber() == null) ? 0 : -1;
    }
    
	@Override public RewardTradeItem doInit(RewardTradeItem rti) {
		
	    	rti.setTradeItemQuantity(getTradeItemQuantity());
	    	rti.setTradeItemNumber(getTradeItemNumber());
	    	
	    	return rti;
    }

}