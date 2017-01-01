package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.PurchaseTradeItemBean;
import com.coupon.common.init.PurchaseTradeItemInit;
import com.coupon.process.message.QualifyingTradeItemMsg;


/**
 * Bean abstract class for PurchaseRequirementTradeItem
 */
@XmlSeeAlso({PurchaseTradeItemBean.class, QualifyingTradeItemMsg.class})
@XmlDiscriminatorNode("@type")
public abstract class PurchaseTradeItem implements Serializable, Comparable<PurchaseTradeItem>, PurchaseTradeItemInit {

	private static final long serialVersionUID = -5624340637483101731L;
	
	public static final int MAX_TRADE_ITEM_GROUP_NAME_LENGTH = 50; 

	public abstract String getTradeItemGroup();
	public abstract void setTradeItemGroup(String tradeItemGroup);

	public abstract GlobalTradeIdentificationNumber getTradeItemNumber();
	public abstract void setTradeItemNumber(GlobalTradeIdentificationNumber tradeItemNumber);

	public abstract Short getTradeItemQuantity();
	public abstract void setTradeItemQuantity(Short tradeItemQuantity);

    /**
     * Default constructor. 
     */
    public PurchaseTradeItem() {
    }

    @Override public boolean equals(Object obj) {
	
	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !PurchaseTradeItem.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	PurchaseTradeItem pti = PurchaseTradeItem.class.cast(obj);
	    	
	    	return ((getTradeItemQuantity() == null) ?
					(pti.getTradeItemQuantity() == null) : getTradeItemQuantity().equals(pti.getTradeItemQuantity()) &&
	    			((getTradeItemGroup() == null) ?
    					(pti.getTradeItemGroup() == null) : getTradeItemGroup().equals(pti.getTradeItemGroup())) &&
	    			((getTradeItemNumber() == null) ?
	    				(pti.getTradeItemNumber() == null) : getTradeItemNumber().equals(pti.getTradeItemNumber())));
    }

    @Override public int compareTo(PurchaseTradeItem pti) {
    	
	    	//ascending
	    	return (getTradeItemNumber() != null) ?
	    				getTradeItemNumber().compareTo(pti.getTradeItemNumber()) :
	    			(pti.getTradeItemNumber() == null) ? 0 : -1;
    }

    @Override public PurchaseTradeItem doInit(PurchaseTradeItem pti) {
    	
	    	pti.setTradeItemNumber(getTradeItemNumber());
	    	pti.setTradeItemGroup(getTradeItemGroup());
	    	pti.setTradeItemQuantity(getTradeItemQuantity());
	    	
	    	return pti;
    }

}