package com.coupon.common.bean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.ConvertGroup;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.AcquisitionPeriod;
import com.coupon.common.TimePeriod;
import com.coupon.common.init.AcquisitionPeriodInit;
import com.coupon.common.validator.ChildValidate;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation for AcquisitionPeriod
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("AcquisitionPeriodBean")
public class AcquisitionPeriodBean extends AcquisitionPeriod implements Bean, Hierarchy {

	private static final long serialVersionUID = 1432694112149145433L;

	@Null(message="apId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="apId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="apId needs to be unsigned number of 19 digits or less.")
	private Long apId;
	@Override public Long getId() { return apId; }
	@Override public void setId(Long apId) { this.apId = apId; }

	@NotNull(message="ddId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="ddId needs to be unsigned number of 19 digits or less.")
	private Long ddId;
	@Override public Long getParentId() { return ddId; }
	@Override public void setParentId(Long ddId) { this.ddId = ddId; }

	@NotNull(message="timePeriod is required.")
	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private TimePeriodBean timePeriod;
    @Override public TimePeriodBean getTimePeriod() { return timePeriod; }
    @Override public void setTimePeriod(TimePeriod timePeriod) {
    	
		this.timePeriod = (timePeriod == null) ?
				null : new TimePeriodBean().init(timePeriod);
    }

    /**
     * Default constructor. 
     */
    public AcquisitionPeriodBean() {
    }

    @Override public AcquisitionPeriodBean init(AcquisitionPeriodInit api) {
    	
	    	api.dispatchInit(this);
	    	
	    	return this;
    }

    @Override public AcquisitionPeriodBean dispatchInit(AcquisitionPeriodBean apb) {
		
    		super.dispatchInit(apb);

    		apb.setId(getId());
		apb.setParentId(getParentId());
		
		return apb;
	}

}