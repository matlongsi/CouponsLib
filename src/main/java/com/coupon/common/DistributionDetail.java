package com.coupon.common;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.DistributionDetailBean;
import com.coupon.common.init.DistributionDetailInit;
import com.coupon.common.utils.ListCompare;


/**
 * Bean abstract class for OfferDistributionDetail
 */
@XmlSeeAlso({DistributionDetailBean.class})
@XmlDiscriminatorNode("@type")
public abstract class DistributionDetail implements Serializable, DistributionDetailInit {

	private static final long serialVersionUID = 5811491420809211428L;

    public abstract List<? extends AcquisitionPeriod> getAcquisitionPeriods();
	public abstract <T extends AcquisitionPeriod> void setAcquisitionPeriods(List<T> acquisitionPeriods);

	/**
	 * Maximum number of coupons that may be acquired in total (across consumers) for a particular offer.
	 */
	public abstract Long getMaximumOfferAcquisition();
	public abstract void setMaximumOfferAcquisition(Long maximumOfferAcquisition);

	public abstract Long getTotalAcquisitionCount();
	public abstract void setTotalAcquisitionCount(Long totalAcquisitionCount);

	public abstract PublicationPeriod getPublicationPeriod();
	public abstract void setPublicationPeriod(PublicationPeriod publicationPeriod);

	@Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !DistributionDetail.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	DistributionDetail dd = DistributionDetail.class.cast(obj);
	    	
	    	return ((getMaximumOfferAcquisition() == null) ?
	    				(dd.getMaximumOfferAcquisition() == null) : getMaximumOfferAcquisition().equals(dd.getMaximumOfferAcquisition())) &&
	    			((getTotalAcquisitionCount() == null) ?
		    			(dd.getTotalAcquisitionCount() == null) : getTotalAcquisitionCount().equals(dd.getTotalAcquisitionCount())) &&
	    			((getPublicationPeriod() == null) ?
	    				(dd.getPublicationPeriod() == null) : getPublicationPeriod().equals(dd.getPublicationPeriod())) &&
	    			ListCompare.<AcquisitionPeriod>equal(getAcquisitionPeriods(), dd.getAcquisitionPeriods());
    }

    /**
     * Default constructor. 
     */
    public DistributionDetail() {
    }

    @Override public DistributionDetail doInit(DistributionDetail dd) {
    	
	    	dd.setMaximumOfferAcquisition(getMaximumOfferAcquisition());
	    	dd.setTotalAcquisitionCount(getTotalAcquisitionCount());
		dd.setPublicationPeriod(getPublicationPeriod());
	    	dd.setAcquisitionPeriods(getAcquisitionPeriods());

	    	return dd;
    }

}