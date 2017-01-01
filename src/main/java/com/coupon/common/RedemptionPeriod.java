package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.RedemptionPeriodBean;
import com.coupon.common.init.RedemptionPeriodInit;


/**
 * Bean abstract class for OfferRedemptionPeriod
 */
@XmlSeeAlso({RedemptionPeriodBean.class})
@XmlDiscriminatorNode("@type")
public abstract class RedemptionPeriod implements Serializable, Comparable<RedemptionPeriod>, RedemptionPeriodInit {

	private static final long serialVersionUID = 9055492298847672575L;

	public abstract TimePeriod getTimePeriod();
	public abstract void setTimePeriod(TimePeriod timePeriod);

	/**
     * Default constructor. 
     */
    public RedemptionPeriod() {
    }

    @Override public boolean equals(Object obj) {
		
		if (obj == this) {
			return true;
		}
		if ((obj == null) || !RedemptionPeriod.class.isInstance(obj)) {
			return false;
		}
		
		RedemptionPeriod rp = RedemptionPeriod.class.cast(obj);
		
		return ((getTimePeriod() == null) ?
				(rp.getTimePeriod() == null) : getTimePeriod().equals(rp.getTimePeriod()));
    }

    @Override public int compareTo(RedemptionPeriod rp) {

	    	//ascending
	    	return (getTimePeriod() != null) ?
					getTimePeriod().compareTo(rp.getTimePeriod()) :
				(rp.getTimePeriod() == null) ? 0 : -1;
    }
    
	@Override public RedemptionPeriod doInit(RedemptionPeriod rp) {

	    	rp.setTimePeriod(getTimePeriod());

	    	return rp;
    }

}