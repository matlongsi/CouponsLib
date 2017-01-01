package com.coupon.common;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.GlobalCouponNumberBean;


/**
 * Bean abstract class for GlobalCouponNumber
 */
@XmlSeeAlso({GlobalCouponNumberBean.class})
@XmlDiscriminatorNode("@type")
public abstract class GlobalCouponNumber implements Serializable, Comparable<GlobalCouponNumber> {

	private static final long serialVersionUID = -3603507862362627795L;
	
	public static final Long OFFER_SERIAL_COMPONENT = 0L;

	public abstract Long getCompanyPrefix();
	public abstract void setCompanyPrefix(Long companyPrefix);
	
	public abstract Integer getCouponReference();
    public abstract void setCouponReference(Integer couponReference);
	
    /**
     * Check digit computed for companyPrefix and couponReference (does not include serialComponent).
     */
    public abstract Byte getCheckDigit();
	public abstract void setCheckDigit(Byte checkDigit);
	
	public abstract Long getSerialComponent();
	public abstract void setSerialComponent(Long serialComponent);
    
    /**
     * Default constructor. 
     */
    public GlobalCouponNumber() {
    }

    @Override public boolean equals(Object obj) {
	
	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !GlobalCouponNumber.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	GlobalCouponNumber gcn = GlobalCouponNumber.class.cast(obj);
	    	
	    	return ((getCompanyPrefix() == null) ?
					(gcn.getCompanyPrefix() == null) : getCompanyPrefix().equals(gcn.getCompanyPrefix()) &&
				(getCouponReference() == null) ?
					(gcn.getCouponReference() == null) : getCouponReference().equals(gcn.getCouponReference()) &&
				(getCheckDigit() == null) ?
					(gcn.getCheckDigit() == null) : getCheckDigit().equals(gcn.getCheckDigit()) &&
				(getSerialComponent() == null) ?
					(gcn.getSerialComponent() == null) : getSerialComponent().equals(gcn.getSerialComponent()));
    }

    @Override public String toString() {
	    	
	    	return getCompanyPrefix() + "-"
	    			+ getCouponReference() + "-"
	    			+ getCheckDigit() + "-"
	    			+ getSerialComponent();
    }

    @Override public int hashCode() {
        
	    	return toString().hashCode();
    }

    @Override public int compareTo(GlobalCouponNumber gcn) {

	    	//ascending
	    	return toString().compareTo(gcn.toString());
	}
	
	public GlobalCouponNumber init(GlobalCouponNumber gcn) {
    	
		setCompanyPrefix(gcn.getCompanyPrefix());
		setCouponReference(gcn.getCouponReference());
		setCheckDigit(gcn.getCheckDigit());
		setSerialComponent(gcn.getSerialComponent());
		
		return this;
	}

}