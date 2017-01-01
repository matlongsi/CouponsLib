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

import com.coupon.common.ShortDescription;
import com.coupon.common.init.ShortDescriptionInit;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation for class ShortDescription
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("ShortDescriptionBean")
public class ShortDescriptionBean extends ShortDescription implements Bean, Hierarchy {

	private static final long serialVersionUID = -1018461692085062811L;

	@Null(message="sdId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="sdId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="sdId needs to be unsigned number of 19 digits or less.")
	private Long sdId;
	@Override public Long getId() { return sdId; }
	@Override public void setId(Long sdId) { this.sdId = sdId; }

	@NotNull(message="mmId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="mmId needs to be unsigned number of 19 digits or less.")
	private Long mmId;
    @Override public Long getParentId() { return mmId; }
    @Override public void setParentId(Long mmId) { this.mmId = mmId; }

    @NotNull(message="shortDescription is required.")
	@Size(max=MAX_DESCRIPTION_LENGTH,
			message="shortDescription needs to be " + MAX_DESCRIPTION_LENGTH + " characters or less.")
	private String shortDescription;
    @Override public String getShortDescription() { return shortDescription; }
    @Override public void setShortDescription(String shortDescription) { this.shortDescription = shortDescription; }

    /**
     * Default constructor.
     */
    public ShortDescriptionBean() {
    }

	@Override public ShortDescriptionBean init(ShortDescriptionInit sdi) {
    	
		sdi.dispatchInit(this);

		return this;
    }

	@Override public ShortDescriptionBean dispatchInit(ShortDescriptionBean sdb) {
    	
		super.dispatchInit(sdb);

		sdb.setId(getId());
        sdb.setParentId(getParentId());

        return sdb;
    }

}