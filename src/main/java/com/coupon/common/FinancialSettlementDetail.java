package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.FinancialSettlementDetailBean;
import com.coupon.common.init.FinancialSettlementDetailInit;


/**
 * Bean abstract class for OfferFinancialSettlementDetail
 */
@XmlSeeAlso({FinancialSettlementDetailBean.class})
@XmlDiscriminatorNode("@type")
public abstract class FinancialSettlementDetail implements Serializable, FinancialSettlementDetailInit {

	private static final long serialVersionUID = 646346781104011948L;
	
	public static final int MAX_CLEARING_INSTRUCTION_LENGTH = 500;

    public abstract String getOfferClearingInstruction();
	public abstract void setOfferClearingInstruction(String offerClearingInstruction);

	/**
     * Default constructor. 
     */
    public FinancialSettlementDetail() {
    }
    
	@Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !FinancialSettlementDetail.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	FinancialSettlementDetail fsd = FinancialSettlementDetail.class.cast(obj);
    	
    		return ((getOfferClearingInstruction() == null) ?
    				(fsd.getOfferClearingInstruction() == null) : getOfferClearingInstruction().equals(fsd.getOfferClearingInstruction()));
    }

	@Override public FinancialSettlementDetail doInit(FinancialSettlementDetail fsd) {
		
	    	fsd.setOfferClearingInstruction(getOfferClearingInstruction());
	    	
	    	return fsd;
	}

}