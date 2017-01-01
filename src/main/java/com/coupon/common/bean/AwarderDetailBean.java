package com.coupon.common.bean;

import java.util.ArrayList;
import java.util.List;

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

import com.coupon.common.AwarderDetail;
import com.coupon.common.AwarderPointOfSale;
import com.coupon.common.GlobalLocationNumber;
import com.coupon.common.RedemptionPeriod;
import com.coupon.common.init.AwarderDetailInit;
import com.coupon.common.validator.ChildValidate;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation class for AwarderDetail
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("AwarderDetailBean")
public class AwarderDetailBean extends AwarderDetail implements Bean, Hierarchy {

	private static final long serialVersionUID = -2478906773002434759L;

	@Null(message="adId value not supported for method.", groups={PostValidate.class})
	@NotNull(message="adId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="adId needs to be unsigned number of 19 digits or less.")
	private Long adId;
	@Override public Long getId() { return adId; }
	@Override public void setId(Long adId) { this.adId = adId; }

	@NotNull(message="offerId is required.", groups={RootValidate.class})
    @Number(digits=19, optional=true, message="offerId needs to be unsigned number of 19 digits or less.")
	private Long offerId;
    @Override public Long getParentId() { return offerId; }
	@Override public void setParentId(Long offerId) { this.offerId = offerId; }

	@NotNull(message="awarderNumber is required.")
	@Valid
    @ConvertGroup.List({
    		@ConvertGroup(from=PostValidate.class, to=Default.class),
    		@ConvertGroup(from=PutValidate.class, to=Default.class)})
	private GlobalLocationNumberBean awarderNumber;
	@Override public GlobalLocationNumberBean getAwarderNumber() { return awarderNumber; }
	@Override public void setAwarderNumber(GlobalLocationNumber awarderNumber) {
		
		this.awarderNumber = (awarderNumber == null) ?
				null : new GlobalLocationNumberBean().init(awarderNumber);
	}

	@Valid
    @ConvertGroup.List({
		@ConvertGroup(from=PostValidate.class, to=Default.class),
		@ConvertGroup(from=PutValidate.class, to=Default.class)})
	private GlobalLocationNumberBean awarderClearingAgentNumber;
	@Override public GlobalLocationNumberBean getAwarderClearingAgentNumber() { return awarderClearingAgentNumber; }
	@Override public void setAwarderClearingAgentNumber(GlobalLocationNumber awarderClearingAgentNumber) {

		this.awarderClearingAgentNumber = (awarderClearingAgentNumber == null) ?
				null : new GlobalLocationNumberBean().init(awarderClearingAgentNumber);
	}
	
	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private List<RedemptionPeriodBean> redemptionPeriods;
	@Override public List<RedemptionPeriodBean> getRedemptionPeriods() { return redemptionPeriods; }
	@Override public <T extends RedemptionPeriod> void setRedemptionPeriods(List<T> redemptionPeriods) {

		this.redemptionPeriods = new ArrayList<RedemptionPeriodBean>();
		for (T rp : redemptionPeriods) {
			getRedemptionPeriods().add(new RedemptionPeriodBean().init(rp));
		}
	}

	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private List<AwarderPointOfSaleBean> pointOfSales;
	@Override public List<AwarderPointOfSaleBean> getPointOfSales() { return pointOfSales; }
	@Override public <T extends AwarderPointOfSale> void setPointOfSales(List<T> pointOfSales) {

		this.pointOfSales = new ArrayList<AwarderPointOfSaleBean>();
		for (T apos : pointOfSales) {
			getPointOfSales().add(new AwarderPointOfSaleBean().init(apos));
    		}
	}

    /**
     * Default constructor. 
     */
    public AwarderDetailBean() {
    }

	@Override public AwarderDetailBean init(AwarderDetailInit adi) {
    	
		adi.dispatchInit(this);
		
		return this;
    }

	@Override public AwarderDetailBean dispatchInit(AwarderDetailBean adb) {
    	
		super.dispatchInit(adb);

	    	adb.setId(getId());
	    	adb.setParentId(getParentId());
	
	    	return adb;
    }

}