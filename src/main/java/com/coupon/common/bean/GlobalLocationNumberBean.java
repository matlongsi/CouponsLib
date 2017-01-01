package com.coupon.common.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.GlobalLocationNumber;
import com.coupon.common.validator.GlobalNumber;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;

/**
 * Bean implementation for GlobalLocationNumber
 */
@GlobalNumber
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("GlobalLocationNumberBean")
public class GlobalLocationNumberBean extends GlobalLocationNumber implements Bean {

	private static final long serialVersionUID = -6001400526960520020L;

	@Null(message="glnId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="glnId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="glnId needs to be unsigned number of 19 digits or less.")
	private Long glnId;
	@Override public Long getId() { return glnId; }
	@Override public void setId(Long glnId) { this.glnId = glnId; }

    @NotNull(message="companyPrefix is required.")
	@Number(digits=11, message="companyPrefix needs to be unsigned number of 11 digits or less.")
	private Long companyPrefix;
	@Override public Long getCompanyPrefix() { return companyPrefix; }
	@Override public void setCompanyPrefix(Long companyPrefix) { this.companyPrefix = companyPrefix; }
    
    @NotNull(message="locationReference is required.")
    @Number(digits=5, message="locationReference needs to be unsigned number of 5 digits or less.")
	private Integer locationReference;
    @Override public Integer getLocationReference() { return locationReference; }
    @Override public void setLocationReference(Integer locationReference) { this.locationReference = locationReference; }
	
    @NotNull(message="checkDigit is required.")
    @Number(digits=1, message="checkDigit needs to be between 0 and 9.")
	private Byte checkDigit;
    @Override public Byte getCheckDigit() { return checkDigit; }
    @Override public void setCheckDigit(Byte checkDigit) { this.checkDigit = checkDigit; }

    /**
     * Default constructor. 
     */
    public GlobalLocationNumberBean() {
    }

    public GlobalLocationNumberBean(
    		Long companyPrefix,
    		Integer locationReference,
    		Byte checkDigit) {
    	
	    	this.companyPrefix = companyPrefix;
	    	this.locationReference = locationReference;
	    	this.checkDigit = checkDigit;
    }

	@Override public GlobalLocationNumberBean init(GlobalLocationNumber gln) {
    	
		super.init(gln);

		setId(Bean.class.cast(gln).getId());

		return this;
	}

}