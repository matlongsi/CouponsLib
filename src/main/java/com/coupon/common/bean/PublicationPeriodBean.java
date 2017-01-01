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

import com.coupon.common.PublicationPeriod;
import com.coupon.common.TimePeriod;
import com.coupon.common.init.PublicationPeriodInit;
import com.coupon.common.validator.ChildValidate;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation for PublicationPeriod
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("PublicationPeriodBean")
public class PublicationPeriodBean extends PublicationPeriod implements Bean, Hierarchy {

	private static final long serialVersionUID = -8117442088147127368L;

	@Null(message="ppId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="ppId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="ppId needs to be unsigned number of 19 digits or less.")
	private Long ppId;
	@Override public Long getId() { return ppId; }
	@Override public void setId(Long ppId) { this.ppId = ppId; }

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
    public PublicationPeriodBean() {
    }

    @Override public PublicationPeriodBean init(PublicationPeriodInit ppi) {
    	
	    	ppi.dispatchInit(this);
	    	
	    	return this;
    }

    @Override public PublicationPeriodBean dispatchInit(PublicationPeriodBean ppb) {

	    	super.dispatchInit(ppb);
	
	    	ppb.setId(getId());
		ppb.setParentId(getParentId());
		
		return ppb;
	}

}