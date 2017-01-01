package com.coupon.common.bean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.RewardTradeItem;
import com.coupon.common.init.RewardTradeItemInit;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation class for RewardTradeItem
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("RewardTradeItemBean")
public class RewardTradeItemBean extends RewardTradeItem implements Bean, Hierarchy {

	private static final long serialVersionUID = 906540110768575117L;

	@Null(message="rtiId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="rtiId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="rtiId needs to be unsigned number of 19 digits or less.")
	private Long rtiId;
    @Override public Long getId() { return rtiId; }
	@Override public void setId(Long rtiId) { this.rtiId = rtiId; }

	@NotNull(message="rId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="rId needs to be unsigned number of 19 digits or less.")
	private Long rId;
	@Override public Long getParentId() { return rId; }
	@Override public void setParentId(Long rId) { this.rId = rId; }

	@NotNull(message="tradeItemNumber is required.")
    @Valid
    @ConvertGroup.List({
		@ConvertGroup(from=PostValidate.class, to=Default.class),
		@ConvertGroup(from=PutValidate.class, to=Default.class)})
	private GlobalTradeIdentificationNumberBean tradeItemNumber;
    @Override public GlobalTradeIdentificationNumberBean getTradeItemNumber() { return tradeItemNumber; }
	@Override public void setTradeItemNumber(GlobalTradeIdentificationNumber tradeItemNumber) {
		
		this.tradeItemNumber = (tradeItemNumber == null) ?
				null : new GlobalTradeIdentificationNumberBean().init(tradeItemNumber);
	}

	@NotNull(message="tradeItemQuantity is required.")
	private Short tradeItemQuantity;
	@Override public Short getTradeItemQuantity() { return tradeItemQuantity; }
	@Override public void setTradeItemQuantity(Short tradeItemQuantity) { this.tradeItemQuantity = tradeItemQuantity; }

    /**
     * Default constructor. 
     */
    public RewardTradeItemBean() {
    }

	@Override public RewardTradeItemBean init(RewardTradeItemInit rtii) {

		rtii.dispatchInit(this);
		
		return this;
    }

	@Override public RewardTradeItemBean dispatchInit(RewardTradeItemBean rtib) {

		super.dispatchInit(rtib);
		
	    	rtib.setId(getId());
	    	rtib.setParentId(getParentId());
	    	
	    	return rtib;
    }

}