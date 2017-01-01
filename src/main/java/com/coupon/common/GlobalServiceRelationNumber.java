package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.GlobalServiceRelationNumberBean;


/**
 * Bean abstract class for GlobalServiceRelationNumber
 */
@XmlSeeAlso({GlobalServiceRelationNumberBean.class})
@XmlDiscriminatorNode("@type")
public abstract class GlobalServiceRelationNumber implements Serializable, Comparable<GlobalServiceRelationNumber> {

	private static final long serialVersionUID = -2248660818839834476L;

	public static final int ALTERNATE_ACCOUNT_ID_LENGTH = 20;

	public abstract Long getCompanyPrefix();
	public abstract void setCompanyPrefix(Long companyPrefix);

	public abstract Long getServiceReference();
	public abstract void setServiceReference(Long serviceReference);

    public abstract Byte getCheckDigit();
	public abstract void setCheckDigit(Byte checkDigit);

    @Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !GlobalServiceRelationNumber.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	GlobalServiceRelationNumber gsrn = GlobalServiceRelationNumber.class.cast(obj);

	    	return ((getCompanyPrefix() == null) ?
					(gsrn.getCompanyPrefix() == null) : getCompanyPrefix().equals(gsrn.getCompanyPrefix()) &&
				(getServiceReference() == null) ?
					(gsrn.getServiceReference() == null) : getServiceReference().equals(gsrn.getServiceReference()) &&
				(getCheckDigit() == null) ?
					(gsrn.getCheckDigit() == null) : getCheckDigit().equals(gsrn.getCheckDigit()));
    }

	@Override public String toString() {
		
	    	return getCompanyPrefix() + "-"
	    			+ getServiceReference() + "-"
	    			+ getCheckDigit();
    }

    @Override public int hashCode() {
        
    		return toString().hashCode();
    }

    @Override public int compareTo(GlobalServiceRelationNumber gsrn) {

	    	//ascending
	    	return toString().compareTo(gsrn.toString());
	}

    public GlobalServiceRelationNumber init(GlobalServiceRelationNumber gsrn) {

	    	setCompanyPrefix(gsrn.getCompanyPrefix());
	    	setServiceReference(gsrn.getServiceReference());
	    	setCheckDigit(gsrn.getCheckDigit());
	    	
	    	return this;
    }

}