package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.ShortDescriptionBean;
import com.coupon.common.init.ShortDescriptionInit;


/**
 * Bean abstract class for OfferShortDescription
 */
@XmlDiscriminatorNode("@type")
@XmlSeeAlso({ShortDescriptionBean.class})
public abstract class ShortDescription implements Serializable, Comparable<ShortDescription>, ShortDescriptionInit {

	private static final long serialVersionUID = -1018461692085062811L;

	public static final int MAX_DESCRIPTION_LENGTH = 80;

	public abstract String getShortDescription();
	public abstract void setShortDescription(String shortDescription);

    /**
     * Default constructor. 
     */
    public ShortDescription() {
    }

    @Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !ShortDescription.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	ShortDescription sd = ShortDescription.class.cast(obj);
	    	
	    	return ((getShortDescription() == null) ?
				(sd.getShortDescription() == null) : getShortDescription().equals(sd.getShortDescription()));
    }

    @Override public int compareTo(ShortDescription sd) {
    	
	    	//ascending
	    	return (getShortDescription() != null) ?
	    				getShortDescription().compareTo(sd.getShortDescription()) :
				(sd.getShortDescription() == null) ? 0 : -1;
    }

	@Override public ShortDescription doInit(ShortDescription sd) {
    	
	    	sd.setShortDescription(getShortDescription());
	    	
	    	return this;
    }

}