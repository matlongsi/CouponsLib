package com.coupon.common.bean;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.LongDescription;
import com.coupon.common.init.LongDescriptionInit;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation for class LongDescription
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("LongDescriptionBean")
public class LongDescriptionBean extends LongDescription implements Bean, Hierarchy {

	private static final long serialVersionUID = -4923762172719781545L;

	@Null(message="ldId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="ldId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="ldId needs to be unsigned number of 19 digits or less.")
	private Long ldId;
	@Override public Long getId() { return ldId; }
	@Override public void setId(Long ldId) { this.ldId = ldId; }

	@NotNull(message="mmId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="mmId needs to be unsigned number of 19 digits or less.")
	private Long mmId;
	@Override public Long getParentId() { return mmId; }
	@Override public void setParentId(Long mmId) { this.mmId = mmId; }

	@NotNull(message="LongDescription is required.")
	@Size(max=MAX_DESCRIPTION_LENGTH,
			message="LongDescription needs to be " + MAX_DESCRIPTION_LENGTH + " characters or less.")
	private String LongDescription;
	@Override public String getLongDescription() { return LongDescription; }
	@Override public void setLongDescription(String LongDescription) { this.LongDescription = LongDescription; }

    /**
     * Default constructor. 
     */
    public LongDescriptionBean() {
    }

	@Override public LongDescriptionBean init(LongDescriptionInit ldi) {

		ldi.dispatchInit(this);

		return this;
    }

	@Override public LongDescriptionBean dispatchInit(LongDescriptionBean ldb) {

		super.dispatchInit(ldb);

	    	ldb.setId(getId());
	    	ldb.setParentId(getParentId());
	    	
	    	return ldb;
    }

}