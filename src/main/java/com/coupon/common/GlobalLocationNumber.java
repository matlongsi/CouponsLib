package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.GlobalLocationNumberBean;


/**
 * Bean abstract class for GlobalLocationNumber
 */
@XmlSeeAlso({GlobalLocationNumberBean.class})
@XmlDiscriminatorNode("@type")
public abstract class GlobalLocationNumber implements Serializable, Comparable<GlobalLocationNumber> {

	private static final long serialVersionUID = -53041365569964181L;

	public abstract Long getCompanyPrefix();
	public abstract void setCompanyPrefix(Long companyPrefix);
    
	public abstract Integer getLocationReference();
	public abstract void setLocationReference(Integer locationReference);
	
    public abstract Byte getCheckDigit();
	public abstract void setCheckDigit(Byte checkDigit);

    /**
     * Default constructor. 
     */
    public GlobalLocationNumber() {
    }

    @Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !GlobalLocationNumber.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	GlobalLocationNumber gln = GlobalLocationNumber.class.cast(obj);
	    	
	    	return ((getCompanyPrefix() == null) ?
					(gln.getCompanyPrefix() == null) : getCompanyPrefix().equals(gln.getCompanyPrefix()) &&
				(getLocationReference() == null) ?
					(gln.getLocationReference() == null) : getLocationReference().equals(gln.getLocationReference()) &&
				(getCheckDigit() == null) ?
					(gln.getCheckDigit() == null) : getCheckDigit().equals(gln.getCheckDigit()));
    }
    
    @Override public String toString() {
    	
	    	return getCompanyPrefix() + "-"
	    			+ getLocationReference() + "-"
	    			+ getCheckDigit();
    }

    @Override public int hashCode() {
        
    		return toString().hashCode();
    }

    @Override public int compareTo(GlobalLocationNumber gln) {

	    	//ascending
	    	return toString().compareTo(gln.toString());
    }

	public GlobalLocationNumber init(GlobalLocationNumber gln) {
    	
		setCompanyPrefix(gln.getCompanyPrefix());
		setLocationReference(gln.getLocationReference());
		setCheckDigit(gln.getCheckDigit());
		
		return this;
	}

}