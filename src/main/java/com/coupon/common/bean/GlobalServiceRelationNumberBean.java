package com.coupon.common.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.GlobalServiceRelationNumber;
import com.coupon.common.validator.GlobalNumber;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;


/**
 * Bean implementation for GlobalServiceRelationNumber
 */
@GlobalNumber
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("GlobalServiceRelationNumberBean")
public class GlobalServiceRelationNumberBean extends GlobalServiceRelationNumber implements Bean {

	private static final long serialVersionUID = -4341426808193128529L;

	@Null(message="gsrnId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="gsrnId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="gsrnId needs to be unsigned number of 19 digits or less.")
	private Long gsrnId;
	@Override public Long getId() { return gsrnId; }
	@Override public void setId(Long gsrnId) { this.gsrnId = gsrnId; }

    @NotNull(message="companyPrefix is required.")
	@Number(digits=11, message="companyPrefix needs to be unsigned number of 11 digits or less.")
    private Long companyPrefix;
	@Override public Long getCompanyPrefix() { return companyPrefix; }
	@Override public void setCompanyPrefix(Long companyPrefix) { this.companyPrefix = companyPrefix; }

    @NotNull(message="serviceReference is required.")
    @Number(digits=10, message="serviceReference needs to be unsigned number of 10 digits or less.")
	private Long serviceReference;
    @Override public Long getServiceReference() { return serviceReference; }
    @Override public void setServiceReference(Long serviceReference) { this.serviceReference = serviceReference; }

    @NotNull(message="checkDigit is required.")
    @Number(digits=1, message="checkDigit needs to be between 0 and 9.")
	private Byte checkDigit;
    @Override public Byte getCheckDigit() { return checkDigit; }
    @Override public void setCheckDigit(Byte checkDigit) { this.checkDigit = checkDigit; }

    /**
     * Default constructor. 
     */
    public GlobalServiceRelationNumberBean() {
    }

    public GlobalServiceRelationNumberBean(
    		Long companyPrefix,
    		Long serviceReference,
    		Byte checkDigit) {
    	
	    	this.companyPrefix = companyPrefix;
	    	this.serviceReference = serviceReference;
	    	this.checkDigit = checkDigit;
    }

    @Override public GlobalServiceRelationNumberBean init(GlobalServiceRelationNumber gsrn) {

	    	super.init(gsrn);
	
	    	setId(Bean.class.cast(gsrn).getId());
	    	
	    	return this;
    }

}