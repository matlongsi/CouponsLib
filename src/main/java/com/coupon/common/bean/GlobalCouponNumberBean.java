package com.coupon.common.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.GlobalCouponNumber;
import com.coupon.common.validator.GlobalNumber;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;


/**
 * Bean implementation for GlobalCouponNumber
 */
@GlobalNumber
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("GlobalCouponNumberBean")
public class GlobalCouponNumberBean extends GlobalCouponNumber implements Bean {

	private static final long serialVersionUID = -3603507862362627795L;

	@Null(message="gcnId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="gcnId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="gcnId needs to be unsigned number of 19 digits or less.")
	private Long gcnId;
    @Override public Long getId() { return gcnId; }
    @Override public void setId(Long gcnId) { this.gcnId = gcnId; }

    @NotNull(message="companyPrefix is required.")
    @Number(digits=11, message="companyPrefix needs to be unsigned number of 11 digits or less.")
    private Long companyPrefix;
    @Override public Long getCompanyPrefix() { return companyPrefix; }
    @Override public void setCompanyPrefix(Long companyPrefix) { this.companyPrefix = companyPrefix; }
	
    @NotNull(message="couponReference is required.")
    @Number(digits=5, message="couponReference needs to be unsigned number of 5 digits or less.")
    private Integer couponReference;
    @Override public Integer getCouponReference() { return couponReference; }
    @Override public void setCouponReference(Integer couponReference) { this.couponReference = couponReference; }
	
    @NotNull(message="checkDigit is required.")
    @Number(digits=1, message="checkDigit needs to be between 0 and 9.")
    private Byte checkDigit;
    @Override public Byte getCheckDigit() { return checkDigit; }
    @Override public void setCheckDigit(Byte checkDigit) { this.checkDigit = checkDigit; }
	
    @Number(digits=12, message="serialComponent needs to be unsigned number of 12 digits or less.")
    private Long serialComponent;
    @Override public Long getSerialComponent() { return serialComponent; }
    @Override public void setSerialComponent(Long serialComponent) { this.serialComponent = serialComponent; }
    
    /**
     * Default constructor. 
     */
    public GlobalCouponNumberBean() {
    }

    public GlobalCouponNumberBean(
    		Long companyPrefix,
    		Integer couponReference,
    		Byte checkDigit,
    		Long serialComponent) {
    	
	    	this.companyPrefix = companyPrefix;
	    	this.couponReference = couponReference;
	    	this.checkDigit = checkDigit;
	    	this.serialComponent = serialComponent;
    }

	@Override public GlobalCouponNumberBean init(GlobalCouponNumber gcn) {

		super.init(gcn);

		setId(Bean.class.cast(gcn).getId());
		
		return this;
	}

}