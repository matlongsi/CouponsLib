package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.PublicationPeriodBean;
import com.coupon.common.init.PublicationPeriodInit;


/**
 * Bean abstract class for OfferPublicationPeriod
 */
@XmlDiscriminatorNode("@type")
@XmlSeeAlso({PublicationPeriodBean.class})
public abstract class PublicationPeriod implements Serializable, Comparable<PublicationPeriod>, PublicationPeriodInit {

	private static final long serialVersionUID = -8117442088147127368L;

	public abstract TimePeriod getTimePeriod();
	public abstract void setTimePeriod(TimePeriod timePeriod);

    @Override public boolean equals(Object obj) {
	
	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !PublicationPeriod.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	PublicationPeriod pp = PublicationPeriod.class.cast(obj);
	    	
	    	return ((getTimePeriod() == null) ?
				(pp.getTimePeriod() == null) : getTimePeriod().equals(pp.getTimePeriod()));
    }

    @Override public int compareTo(PublicationPeriod pp) {

	    	//ascending
	    	return (getTimePeriod() != null) ?
	    				getTimePeriod().compareTo(pp.getTimePeriod()) :
	    			(pp.getTimePeriod() == null) ? 0 : -1;
    }
    
	@Override public PublicationPeriod doInit(PublicationPeriod pp) {

	    	pp.setTimePeriod(getTimePeriod());
	
	    	return pp;
    }

}