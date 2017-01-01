package com.coupon.common.bean;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.PurchaseTradeItem;
import com.coupon.common.init.PurchaseTradeItemInit;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation class for PurchaseTradeItem
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("PurchaseTradeItemBean")
public class PurchaseTradeItemBean extends PurchaseTradeItem implements Bean, Hierarchy {

	private static final long serialVersionUID = -5624340637483101731L;

	@Null(message="ptiId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="ptiId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="prtiId needs to be unsigned number of 19 digits or less.")
	private Long ptiId;
	@Override public Long getId() { return ptiId; }
	@Override public void setId(Long ptiId) { this.ptiId = ptiId; }

	@NotNull(message="prId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="prId needs to be unsigned number of 19 digits or less.")
	private Long prId;
	@Override public Long getParentId() { return prId; }
	@Override public void setParentId(Long prId) { this.prId = prId; }

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

	@Size(max=MAX_TRADE_ITEM_GROUP_NAME_LENGTH,
			message="tradeItemGroup needs to be " + MAX_TRADE_ITEM_GROUP_NAME_LENGTH + " characters or less.")
	private String tradeItemGroup;
	@Override public String getTradeItemGroup() { return tradeItemGroup; }
	@Override public void setTradeItemGroup(String tradeItemGroup) { this.tradeItemGroup = tradeItemGroup; }

    /**
     * Default constructor. 
     */
    public PurchaseTradeItemBean() {
    }

    @Override public PurchaseTradeItemBean init(PurchaseTradeItemInit ptii) {

	    	ptii.dispatchInit(this);
	    	
	    	return this;
    }

    @Override public PurchaseTradeItemBean dispatchInit(PurchaseTradeItemBean ptib) {

	    	super.dispatchInit(ptib);
	    	
	    	ptib.setId(getId());
	    	ptib.setParentId(getParentId());
	    	
	    	return ptib;
    }

}