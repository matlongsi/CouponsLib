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

import com.coupon.common.RedemptionPeriod;
import com.coupon.common.TimePeriod;
import com.coupon.common.init.RedemptionPeriodInit;
import com.coupon.common.validator.ChildValidate;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation class for RedemptionPeriod
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("RedemptionPeriodBean")
public class RedemptionPeriodBean extends RedemptionPeriod implements Bean, Hierarchy {

	private static final long serialVersionUID = 9055492298847672575L;

	@Null(message="rpId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="rpId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="rpId needs to be unsigned number of 19 digits or less.")
	private Long rpId;
	@Override public Long getId() { return rpId; }
	@Override public void setId(Long rpId) { this.rpId = rpId; }

	@NotNull(message="adId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="adId needs to be unsigned number of 19 digits or less.")
	private Long adId;
    @Override public Long getParentId() { return adId; }
	@Override public void setParentId(Long adId) { this.adId = adId; }

	@NotNull(message="timePeriod is required.")
    @Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private TimePeriodBean timePeriod;
	@Override public TimePeriodBean getTimePeriod() { return timePeriod; }
	@Override public void setTimePeriod(TimePeriod timePeriod) {
		
		this.timePeriod = (timePeriod == null) ?
				null : TimePeriodBean.class.cast(new TimePeriodBean().init(timePeriod));
	}

    /**
     * Default constructor. 
     */
    public RedemptionPeriodBean() {
    }

	@Override public RedemptionPeriodBean init(RedemptionPeriodInit rpi) {
    	
		rpi.dispatchInit(this);

		return this;
    }

	@Override public RedemptionPeriodBean dispatchInit(RedemptionPeriodBean rpb) {
    	
		super.dispatchInit(rpb);

	    	rpb.setId(getId());
	    	rpb.setParentId(getParentId());
	    	
	    	return rpb;
    }

}