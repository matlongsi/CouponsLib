package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.LongDescriptionBean;
import com.coupon.common.init.LongDescriptionInit;


/**
 * Bean abstract class for OfferLongDescription
 */
@XmlDiscriminatorNode("@type")
@XmlSeeAlso({LongDescriptionBean.class})
public abstract class LongDescription implements Serializable, Comparable<LongDescription>, LongDescriptionInit {

	private static final long serialVersionUID = -4923762172719781545L;

	public static final int MAX_DESCRIPTION_LENGTH = 200;

	public abstract String getLongDescription();
	public abstract void setLongDescription(String longDescription);

    /**
     * Default constructor. 
     */
    public LongDescription() {
    }

    @Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !LongDescription.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	LongDescription ld = LongDescription.class.cast(obj);
	    	
	    	return ((getLongDescription() == null) ?
				(ld.getLongDescription() == null) : getLongDescription().equals(ld.getLongDescription()));
    }

    @Override public int compareTo(LongDescription ld) {

	    	//ascending
	    	return getLongDescription().compareTo(ld.getLongDescription());
    }

	@Override public LongDescription doInit(LongDescription ld) {
	    	
	    	ld.setLongDescription(getLongDescription());
	    	
	    	return ld;
    }

}