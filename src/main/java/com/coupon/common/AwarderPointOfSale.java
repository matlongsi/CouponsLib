package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.AwarderPointOfSaleBean;
import com.coupon.common.init.AwarderPointOfSaleInit;


/**
 * Bean abstract class for OfferAwarderPointOfSale
 */
@XmlSeeAlso({AwarderPointOfSaleBean.class})
@XmlDiscriminatorNode("@type")
public abstract class AwarderPointOfSale implements Serializable, Comparable<AwarderPointOfSale>, AwarderPointOfSaleInit {

	private static final long serialVersionUID = 8739487470308639452L;
	
	public static final int MAX_STORE_INTERNAL_ID_LENGTH = 20;
	public static final int MAX_POS_TERMINAL_ID_LENGTH = 20;
	
	public abstract GlobalLocationNumber getStoreNumber();
	public abstract void setStoreNumber(GlobalLocationNumber storeNumber);

	public abstract String getStoreInternalId();
	public abstract void setStoreInternalId(String storeInternalId);

    /**
     * Default constructor. 
     */
    public AwarderPointOfSale() {
    }

    @Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !AwarderPointOfSale.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	AwarderPointOfSale apos = AwarderPointOfSale.class.cast(obj);
	
	    	return ((getStoreInternalId() == null) ?
					(apos.getStoreInternalId() == null) : getStoreInternalId().equals(apos.getStoreInternalId())) &&
		    		((getStoreNumber() == null) ?
					(apos.getStoreNumber() == null) : getStoreNumber().equals(apos.getStoreNumber()));
    }

    @Override public int compareTo(AwarderPointOfSale apos) {
    	
	    	//ascending
	    	return ((getStoreNumber() != null) && !getStoreNumber().equals(apos.getStoreNumber())) ?
	    				getStoreNumber().compareTo(apos.getStoreNumber()) :
				((getStoreInternalId() != null) && !getStoreInternalId().equals(apos.getStoreInternalId())) ?
					getStoreInternalId().compareTo(apos.getStoreInternalId()) :
				(apos.getStoreInternalId() == null) ? 0 : -1;
    }

	@Override public AwarderPointOfSale doInit(AwarderPointOfSale apos) {
    	
	    	apos.setStoreNumber(getStoreNumber());
	    	apos.setStoreInternalId(getStoreInternalId());
	    	
	    	return apos;
    }

}