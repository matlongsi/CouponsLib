package com.coupon.common.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.validator.GlobalNumber;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;


/**
 * Bean implementation for GlobalTradeIdentificationNumber
 */
@GlobalNumber
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("GlobalTradeIdentificationNumberBean")
public class GlobalTradeIdentificationNumberBean extends GlobalTradeIdentificationNumber implements Bean {

	private static final long serialVersionUID = -1791175452124637190L;

	@Null(message="gtinId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="gtinId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="gtinId needs to be unsigned number of 19 digits or less.")
	private Long gtinId;
	@Override public Long getId() { return gtinId; }
	@Override public void setId(Long gtinId) { this.gtinId = gtinId; }

    @NotNull(message="companyPrefix is required.")
	@Number(digits=11, message="companyPrefix needs to be unsigned number of 11 digits or less.")
    private Long companyPrefix;
	@Override public Long getCompanyPrefix() { return companyPrefix; }
	@Override public void setCompanyPrefix(Long companyPrefix) { this.companyPrefix = companyPrefix; }
    
    @NotNull(message="itemReference is required.")
    @Number(digits=5, message="itemReference needs to be unsigned number of 5 digits or less.")
	private Integer itemReference;
    @Override public Integer getItemReference() { return itemReference; }
    @Override public void setItemReference(Integer itemReference) { this.itemReference = itemReference; }
    
    @NotNull(message="checkDigit is required.")
    @Number(digits=1, message="checkDigit needs to be between 0 and 9.")
	private Byte checkDigit;
    @Override public Byte getCheckDigit() { return checkDigit; }
    @Override public void setCheckDigit(Byte checkDigit) { this.checkDigit = checkDigit; }

    /**
     * Default constructor. 
     */
    public GlobalTradeIdentificationNumberBean() {
    }

    public GlobalTradeIdentificationNumberBean(
    		Long companyPrefix,
    		Integer itemReference,
    		Byte checkDigit) {
    	
	    	this.companyPrefix = companyPrefix;
	    	this.itemReference = itemReference;
	    	this.checkDigit = checkDigit;
    }

	@Override public GlobalTradeIdentificationNumberBean init(GlobalTradeIdentificationNumber gtin) {

		super.init(gtin);
		
		setId(Bean.class.cast(gtin).getId());
		
		return this;
	}

}