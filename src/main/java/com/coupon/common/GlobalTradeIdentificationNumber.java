package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.GlobalTradeIdentificationNumberBean;


/**
 * Bean abstract class for GlobalTradeIdentificationNumber
 */
@XmlSeeAlso({GlobalTradeIdentificationNumberBean.class})
@XmlDiscriminatorNode("@type")
public abstract class GlobalTradeIdentificationNumber implements Serializable, Comparable<GlobalTradeIdentificationNumber> {

	private static final long serialVersionUID = -1791175452124637190L;

    public abstract Long getCompanyPrefix();
	public abstract void setCompanyPrefix(Long companyPrefix);
    
    public abstract Integer getItemReference();
	public abstract void setItemReference(Integer itemReference);
    
    public abstract Byte getCheckDigit();
	public abstract void setCheckDigit(Byte checkDigit);

    /**
     * Default constructor. 
     */
    public GlobalTradeIdentificationNumber() {
    }

    @Override public boolean equals(Object obj) {
	
	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !GlobalTradeIdentificationNumber.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	GlobalTradeIdentificationNumber gtin = GlobalTradeIdentificationNumber.class.cast(obj);
	    	
	    	return ((getCompanyPrefix() == null) ?
					(gtin.getCompanyPrefix() == null) : getCompanyPrefix().equals(gtin.getCompanyPrefix()) &&
				(getItemReference() == null) ?
					(gtin.getItemReference() == null) : getItemReference().equals(gtin.getItemReference()) &&
				(getCheckDigit() == null) ?
						(gtin.getCheckDigit() == null) : getCheckDigit().equals(gtin.getCheckDigit()));
    }

    @Override public String toString() {
	    	
	    	return getCompanyPrefix() + "-"
	    			+ getItemReference() + "-"
	    			+ getCheckDigit();
    }

    @Override public int hashCode() {
    
	    	return toString().hashCode();
    }
    
    @Override public int compareTo(GlobalTradeIdentificationNumber gtin) {
    	
	    	//ascending
	    	return toString().compareTo(gtin.toString());
    }

	public GlobalTradeIdentificationNumber init(GlobalTradeIdentificationNumber gtin) {
    	
		setCompanyPrefix(gtin.getCompanyPrefix());
		setItemReference(gtin.getItemReference());
		setCheckDigit(gtin.getCheckDigit());
		
		return this;
	}

}