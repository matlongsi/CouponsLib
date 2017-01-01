package com.coupon.process.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import com.coupon.common.GlobalCouponNumber;
import com.coupon.common.bean.GlobalCouponNumberBean;
import com.coupon.common.GlobalLocationNumber;
import com.coupon.common.bean.GlobalLocationNumberBean;
import com.coupon.common.AwarderPointOfSale;
import com.coupon.common.bean.AwarderPointOfSaleBean;
import com.coupon.common.FinancialSettlementDetail;
import com.coupon.common.bean.FinancialSettlementDetailBean;
import com.coupon.common.Reward;
import com.coupon.common.bean.RewardBean;
import com.coupon.common.UsageCondition;
import com.coupon.common.bean.UsageConditionBean;
import com.coupon.common.PurchaseRequirement;
import com.coupon.common.bean.PurchaseRequirementBean;
import com.coupon.common.TimePeriod;
import com.coupon.common.bean.TimePeriodBean;
import com.coupon.common.type.OfferType;
import com.coupon.common.validator.GlobalNumber;


/**
 * Message implementation for OfferNotification
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class OfferNotificationMessage implements Serializable {

	private static final long serialVersionUID = 7957513622121893954L;

	@NotNull @Valid
	private HeaderMsg header;
	public HeaderMsg getHeader() { return header; }
	public void setHeader(HeaderMsg header) { this.header = header; }

	@NotNull @Valid
	private GlobalLocationNumber issuerNumber;
	public GlobalLocationNumber getIssuerNumber() { return issuerNumber; }
	public void setIssuerNumber(GlobalLocationNumber issuerNumber) {

		this.issuerNumber = new GlobalLocationNumberBean().init(issuerNumber);
	}
	
	@Valid
	private GlobalLocationNumber issuerClearingAgentNumber;
	public GlobalLocationNumber getIssuerClearingAgentNumber() { return issuerClearingAgentNumber; }
	public void setIssuerClearingAgentNumber(GlobalLocationNumber issuerClearingAgentNumber) {

		this.issuerClearingAgentNumber = new GlobalLocationNumberBean().init(issuerClearingAgentNumber);
	}

	@NotNull @Valid
	private GlobalLocationNumber awarderNumber;
	public GlobalLocationNumber getAwarderNumber() { return awarderNumber; }
	public void setAwarderNumber(GlobalLocationNumber awarderNumber) {

		this.awarderNumber = new GlobalLocationNumberBean().init(awarderNumber);
	}
	
	@Future
	private Date latestAcceptanceDate;
	public Date getLatestAcceptanceDate() { return latestAcceptanceDate; }
	public void setLatestAcceptanceDate(Date latestAcceptanceDate) { this.latestAcceptanceDate = latestAcceptanceDate; }

	@NotNull @GlobalNumber(serializable=false)
	private GlobalCouponNumber couponNumber;
	public GlobalCouponNumber getCouponOfferNumber() { return couponNumber; }
	public void setCouponNumber(GlobalCouponNumber couponNumber) {
		
		this.couponNumber = new GlobalCouponNumberBean().init(couponNumber);
	}
	
	@NotNull @Valid
	private TimePeriod timePeriod;
	public TimePeriod getTimePeriod() { return timePeriod; }
	public void setTimePeriod(TimePeriod timePeriod) {
		
		this.timePeriod = new TimePeriodBean().init(timePeriod);
	}
	
	@NotNull
    private OfferType offerTypeCode;
	public OfferType getOfferTypeCode() { return offerTypeCode; }
	public void setOfferTypeCode(OfferType offerTypeCode) { this.offerTypeCode = offerTypeCode; }
	
	@Valid
	private UsageCondition usageCondition;
	public UsageCondition getUsageCondition() { return usageCondition; }
	public void setUsageCondition(UsageCondition usageCondition) {
		
		this.usageCondition = new UsageConditionBean().init(usageCondition);
	}
	
	@Valid
	private FinancialSettlementDetail financialSettlementDetail;
	public FinancialSettlementDetail getFinancialSettlementDetail() { return financialSettlementDetail; }
	public void setFinancialSettlementDetail(FinancialSettlementDetail financialSettlementDetail) {
		
		this.financialSettlementDetail = new FinancialSettlementDetailBean().init(financialSettlementDetail);
	}

	@Valid
	private List<AwarderPointOfSale> awarderPointOfSales;
	public List<AwarderPointOfSale> getAwarderPointOfSales() { return awarderPointOfSales; }
	public <T extends AwarderPointOfSale> void setAwarderPointOfSales(List<T> awarderPointOfSales) {

		this.awarderPointOfSales = new ArrayList<AwarderPointOfSale>();
		for (T oapos : awarderPointOfSales) {

			getAwarderPointOfSales().add(new AwarderPointOfSaleBean().init(oapos));
    	}
	}

	@NotNull @Valid
	private Reward offerReward;
	public Reward getOfferReward() { return offerReward; }
	public void setOfferReward(Reward offerReward) {
		
		this.offerReward = new RewardBean().init(offerReward);
	}

	@NotNull @Valid
	private PurchaseRequirement purchaseRequirement;
	public PurchaseRequirement getPurchaseRequirement() { return purchaseRequirement; }
	public void setPurchaseRequirement(PurchaseRequirement purchaseRequirement) {
		
		this.purchaseRequirement = new PurchaseRequirementBean().init(purchaseRequirement);
	}

	/**
     * Default constructor. 
     */
    public OfferNotificationMessage() {
    }

}