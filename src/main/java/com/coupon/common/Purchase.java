package com.coupon.common;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.PurchaseRequirementBean;
import com.coupon.common.utils.ListCompare;

/**
 * Bean abstract class for PurchaseRequirement
 */
@XmlSeeAlso({PurchaseRequirementBean.class})
@XmlDiscriminatorNode("@type")
public abstract class Purchase implements Serializable {

	private static final long serialVersionUID = 200163578954385741L;

	public abstract Float getPurchaseMonetaryAmount();
	public abstract void setPurchaseMonetaryAmount(Float purchaseMonetaryAmount);

	public abstract List<? extends PurchaseTradeItem> getPurchaseTradeItems();
	public abstract <T extends PurchaseTradeItem> void setPurchaseTradeItems(List<T> list);

    /**
     * Default constructor. 
     */
    public Purchase() {
    }

	@Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !Purchase.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	Purchase p = Purchase.class.cast(obj);
	    	
	    	return (getPurchaseMonetaryAmount() == null) ?
					(p.getPurchaseMonetaryAmount() == null) : getPurchaseMonetaryAmount().equals(p.getPurchaseMonetaryAmount()) &&
	    			ListCompare.<PurchaseTradeItem>equal(getPurchaseTradeItems(), p.getPurchaseTradeItems());
    }

	public Purchase doInit(Purchase p) {

       	setPurchaseMonetaryAmount(p.getPurchaseMonetaryAmount());
   		setPurchaseTradeItems(p.getPurchaseTradeItems());
    	
   		return this;
    }

}