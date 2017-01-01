package com.coupon.common.bean;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.UsageCondition;
import com.coupon.common.init.UsageConditionInit;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation class for UsageCondition
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("UsageConditionBean")
public class UsageConditionBean extends UsageCondition implements Bean, Hierarchy {

	private static final long serialVersionUID = -7113436787299916840L;

	@Null(message="ucId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="ucId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="ucId needs to be unsigned number of 19 digits or less.")
	private Long ucId;
	@Override public Long getId() { return ucId; }
	@Override public void setId(Long ucId) { this.ucId = ucId; }

	@NotNull(message="offerId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="offerId needs to be unsigned number of 19 digits or less.")
	private Long offerId;
	@Override public Long getParentId() { return offerId; }
	@Override public void setParentId(Long offerId) { this.offerId = offerId; }

	@Min(value=1, message="maximumCumulativeUse needs to be greater than 0")
	@Max(value=MAX_CUMULATIVE_USE, message="maximumCumulativeUse needs to be within " + MAX_CUMULATIVE_USE)
    private Short maximumCumulativeUse;
    @Override public Short getMaximumCumulativeUse() { return maximumCumulativeUse; }
	@Override public void setMaximumCumulativeUse(Short maximumCumulativeUse) { this.maximumCumulativeUse = maximumCumulativeUse; }

	@Min(value=1, message="maximumUsePerTransaction needs to be greater than 0")
	@Max(value=MAX_USE_PER_TRANSACTION, message="maximumUsePerTransaction needs to be within " + MAX_USE_PER_TRANSACTION)
	private Short maximumUsePerTransaction;
    @Override public Short getMaximumUsePerTransaction() { return maximumUsePerTransaction; }
	@Override public void setMaximumUsePerTransaction(Short maximumUsesPerTransaction) { this.maximumUsePerTransaction = maximumUsesPerTransaction; }

	/**
     * Default constructor. 
     */
    public UsageConditionBean() {
    }

    @Override public UsageConditionBean init(UsageConditionInit uci) {

	    	uci.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public UsageConditionBean dispatchInit(UsageConditionBean ucb) {

		super.dispatchInit(ucb);
		
		ucb.setId(getId());
		ucb.setParentId(getParentId());

		return ucb;
    }

}