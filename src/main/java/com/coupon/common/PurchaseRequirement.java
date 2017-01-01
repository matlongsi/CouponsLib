package com.coupon.common;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.PurchaseRequirementBean;
import com.coupon.common.init.PurchaseRequirementInit;
import com.coupon.common.type.PurchaseRequirementType;
import com.coupon.common.utils.ListCompare;


/**
 * Bean abstract class for PurchaseRequirement
 */
@XmlSeeAlso({PurchaseRequirementBean.class})
@XmlDiscriminatorNode("@type")
public abstract class PurchaseRequirement extends Purchase implements PurchaseRequirementInit {

	private static final long serialVersionUID = -2884594357985776362L;

	public abstract PurchaseRequirementType getPurchaseRequirementType();
	public abstract void setPurchaseRequirementType(PurchaseRequirementType purchaseRequirementType);

    /**
     * Default constructor. 
     */
    public PurchaseRequirement() {
    }

	@Override public boolean equals(Object obj) {
	
	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !PurchaseRequirement.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	PurchaseRequirement pr = PurchaseRequirement.class.cast(obj);
	    	
	    	if (!getPurchaseRequirementType().equals(pr.getPurchaseRequirementType())) {
	    		return false;
	    	}
	    	switch (getPurchaseRequirementType()) {
	    	
	    	case SPECIFIED_PURCHASE_AMOUNT:
	    		return (getPurchaseMonetaryAmount() == null) ?
						(pr.getPurchaseMonetaryAmount() == null) : getPurchaseMonetaryAmount().equals(pr.getPurchaseMonetaryAmount());

	    	case ONE_ITEM_PER_GROUP:
	    	case ONE_OF_SPECIFIED_ITEMS:
	    	case ALL_SPECIFIED_ITEMS:
	    		return ListCompare.<PurchaseTradeItem>equal(getPurchaseTradeItems(), pr.getPurchaseTradeItems());
	    		
		default:
			return false;
	    	}
    }

	@Override public PurchaseRequirement doInit(PurchaseRequirement pr) {
    	
	    	pr.setPurchaseRequirementType(getPurchaseRequirementType());
	    	switch (pr.getPurchaseRequirementType()) {
	
	    	case SPECIFIED_PURCHASE_AMOUNT:
	        	pr.setPurchaseMonetaryAmount(getPurchaseMonetaryAmount());
	    		break;
	    		
	    	case ONE_ITEM_PER_GROUP:
	    	case ONE_OF_SPECIFIED_ITEMS:
	    	case ALL_SPECIFIED_ITEMS:
	    		pr.setPurchaseTradeItems(getPurchaseTradeItems());
	    		break;
	    		
		default:
			break;
	    	}
	    	
	    	return pr;
    }

}