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

import com.coupon.common.AwarderPointOfSale;
import com.coupon.common.GlobalLocationNumber;
import com.coupon.common.init.AwarderPointOfSaleInit;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation class for AwarderPointOfSale
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("AwarderPointOfSaleBean")
public class AwarderPointOfSaleBean extends AwarderPointOfSale implements Bean, Hierarchy {

	private static final long serialVersionUID = 8739487470308639452L;

	@Null(message="aposId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="aposId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="aposId needs to be unsigned number of 19 digits or less.")
	private Long aposId;
    @Override public Long getId() { return aposId; }
	@Override public void setId(Long aposId) { this.aposId = aposId; }

	@NotNull(message="adId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="adId needs to be unsigned number of 19 digits or less.")
	private Long adId;
    @Override public Long getParentId() { return adId; }
	@Override public void setParentId(Long adId) { this.adId = adId; }

	@Valid
    @ConvertGroup.List({
		@ConvertGroup(from=PostValidate.class, to=Default.class),
		@ConvertGroup(from=PutValidate.class, to=Default.class)})
	private GlobalLocationNumberBean storeNumber;
	@Override public GlobalLocationNumberBean getStoreNumber() { return storeNumber; }
	@Override public void setStoreNumber(GlobalLocationNumber storeNumber) {
		
		this.storeNumber = (storeNumber == null) ?
				null : new GlobalLocationNumberBean().init(storeNumber);
	}

	@Size(max=MAX_STORE_INTERNAL_ID_LENGTH,
			message="storeInternalId needs to be " + MAX_STORE_INTERNAL_ID_LENGTH + " characters or less.")
	private String storeInternalId;
	@Override public String getStoreInternalId() { return storeInternalId; }
	@Override public void setStoreInternalId(String storeInternalId) { this.storeInternalId = storeInternalId; }

    /**
     * Default constructor. 
     */
    public AwarderPointOfSaleBean() {
    }

	@Override public AwarderPointOfSaleBean init(AwarderPointOfSaleInit aposi) {
    	
		aposi.dispatchInit(this);
		
		return this;
    }

	@Override public AwarderPointOfSaleBean dispatchInit(AwarderPointOfSaleBean aposb) {
    	
		super.dispatchInit(aposb);

	    	aposb.setId(getId());
	    	aposb.setParentId(getParentId());
	    	
	    	return aposb;
    }

}