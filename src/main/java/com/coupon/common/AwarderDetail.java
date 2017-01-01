package com.coupon.common;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.AwarderDetailBean;
import com.coupon.common.init.AwarderDetailInit;
import com.coupon.common.utils.ListCompare;


/**
 * Abstract class for OfferAwarderDetail
 */
@XmlSeeAlso({AwarderDetailBean.class})
@XmlDiscriminatorNode("@type")
public abstract class AwarderDetail implements Serializable, Comparable<AwarderDetail>, AwarderDetailInit {

	private static final long serialVersionUID = -2478906773002434759L;

	public abstract GlobalLocationNumber getAwarderNumber();
	public abstract void setAwarderNumber(GlobalLocationNumber awarderNumber);

	public abstract GlobalLocationNumber getAwarderClearingAgentNumber();
	public abstract void setAwarderClearingAgentNumber(GlobalLocationNumber awarderClearingAgentNumber);

	public abstract List<? extends AwarderPointOfSale> getPointOfSales();
	public abstract <T extends AwarderPointOfSale> void setPointOfSales(List<T> pointOfSales);

	public abstract List<? extends RedemptionPeriod> getRedemptionPeriods();
	public abstract <T extends RedemptionPeriod> void setRedemptionPeriods(List<T> redemptionPeriods);

    /**
     * Default constructor. 
     */
    public AwarderDetail() {
    }

    @Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !AwarderDetail.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	AwarderDetail ad = AwarderDetail.class.cast(obj);
	    	
	    	return ((getAwarderNumber() == null) ?
	    				(ad.getAwarderNumber() == null) : getAwarderNumber().equals(ad.getAwarderNumber())) &&
	    			ListCompare.<RedemptionPeriod>equal(getRedemptionPeriods(), ad.getRedemptionPeriods()) &&
	    			ListCompare.<AwarderPointOfSale>equal(getPointOfSales(), ad.getPointOfSales());
    }

    @Override public int compareTo(AwarderDetail ad) {
    	
	    	//ascending
	    	return (getAwarderNumber() != null) ?
	    				getAwarderNumber().compareTo(ad.getAwarderNumber()) :
	    			(ad.getAwarderNumber() == null) ? 0 : -1;
    }

	@Override public AwarderDetail doInit(AwarderDetail ad) {

	    	ad.setAwarderNumber(getAwarderNumber());
	    	ad.setRedemptionPeriods(getRedemptionPeriods());
	    	ad.setPointOfSales(getPointOfSales());
	
	    	if (getAwarderClearingAgentNumber() != null) {
	    		
	        	ad.setAwarderClearingAgentNumber(getAwarderClearingAgentNumber());
	    	}
	    	
	    	return ad;
    }

}