package com.coupon.common.bean;

import java.util.ArrayList;
import java.util.List;

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

import com.coupon.common.PurchaseRequirement;
import com.coupon.common.PurchaseTradeItem;
import com.coupon.common.init.PurchaseRequirementInit;
import com.coupon.common.type.PurchaseRequirementType;
import com.coupon.common.validator.Amount;
import com.coupon.common.validator.ChildValidate;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;

/**
 * Bean implementation for PurchaseRequirement
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("PurchaseRequirementBean")
public class PurchaseRequirementBean extends PurchaseRequirement implements Bean, Hierarchy {

	private static final long serialVersionUID = -2884594357985776362L;

	@Null(message="prId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="prId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="prId needs to be unsigned number of 19 digits or less.")
	private Long prId;
    @Override public Long getId() { return prId; }
	@Override public void setId(Long prId) { this.prId = prId; }

	@NotNull(message="offerId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="offerId needs to be unsigned number of 19 digits or less.")
	private Long offerId;
	@Override public Long getParentId() { return offerId; }
    @Override public void setParentId(Long offerId) { this.offerId = offerId; }

	@NotNull(message="purchaseRequirementType is required.")
	private PurchaseRequirementType purchaseRequirementType;
	@Override public PurchaseRequirementType getPurchaseRequirementType() { return purchaseRequirementType; }
	@Override public void setPurchaseRequirementType(PurchaseRequirementType purchaseRequirementType) { this.purchaseRequirementType = purchaseRequirementType; }

	@Amount(totalDigits=10, decimalDigits=2, optional=true,
			message="purchaseMonetaryAmount should be of 10 digits or less, with no more than 2 decimal digits.")
	private Float purchaseMonetaryAmount;
	@Override public Float getPurchaseMonetaryAmount() { return purchaseMonetaryAmount; }
	@Override public void setPurchaseMonetaryAmount(Float purchaseMonetaryAmount) { this.purchaseMonetaryAmount = purchaseMonetaryAmount; }

    @Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
    private List<PurchaseTradeItemBean> purchaseTradeItems;
	@Override public List<PurchaseTradeItemBean> getPurchaseTradeItems() { return purchaseTradeItems; }
	@Override public <T extends PurchaseTradeItem> void setPurchaseTradeItems(List<T> purchaseTradeItems) {

		this.purchaseTradeItems = new ArrayList<PurchaseTradeItemBean>();
		for (T prti : purchaseTradeItems) {
			this.purchaseTradeItems.add(new PurchaseTradeItemBean().init(prti));
		}
	}

    /**
     * Default constructor. 
     */
    public PurchaseRequirementBean() {
    }

	@Override public PurchaseRequirementBean init(PurchaseRequirementInit pri) {
    	
		pri.dispatchInit(this);

		return this;
	}

	@Override public PurchaseRequirementBean dispatchInit(PurchaseRequirementBean prb) {
    	
		super.dispatchInit(prb);

	    	prb.setId(getId());
	    	prb.setParentId(getParentId());
	    	
	    	return prb;
	}

}