package com.coupon.common.bean;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;
import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorValue;

import com.coupon.common.Offer;
import com.coupon.common.GlobalCouponNumber;
import com.coupon.common.GlobalLocationNumber;
import com.coupon.common.AwarderDetail;
import com.coupon.common.DistributionDetail;
import com.coupon.common.FinancialSettlementDetail;
import com.coupon.common.MarketingMaterial;
import com.coupon.common.Reward;
import com.coupon.common.UsageCondition;
import com.coupon.common.PurchaseRequirement;
import com.coupon.common.TimePeriod;
import com.coupon.common.init.OfferInit;
import com.coupon.common.type.OfferStatusType;
import com.coupon.common.type.OfferType;
import com.coupon.common.validator.ChildValidate;
import com.coupon.common.validator.GlobalNumber;
import com.coupon.common.validator.Number;
import com.coupon.common.validator.PostValidate;
import com.coupon.common.validator.PutValidate;
import com.coupon.common.validator.RootValidate;


/**
 * Bean implementation class for Offer
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
@XmlDiscriminatorValue("OfferBean")
public class OfferBean extends Offer implements Bean {

	private static final long serialVersionUID = -8223413281597691268L;

	@NotNull(message="offerId is required.", groups={PutValidate.class})
    @Number(digits=19, optional=true, message="offerId needs to be unsigned number of 19 digits or less.")
	private Long offerId;
    @Override public Long getId() { return offerId; }
	@Override public void setId(Long offerId) { this.offerId = offerId; }

	@NotNull(message="issuerNumber is required.")
	@Valid
    @ConvertGroup.List({
		@ConvertGroup(from=PostValidate.class, to=Default.class),
		@ConvertGroup(from=PutValidate.class, to=Default.class)})
	private GlobalLocationNumberBean issuerNumber;
	@Override public GlobalLocationNumberBean getIssuerNumber() { return issuerNumber; }
	@Override public void setIssuerNumber(GlobalLocationNumber issuerNumber) {

		this.issuerNumber = (issuerNumber == null) ?
				null : new GlobalLocationNumberBean().init(issuerNumber);
	}
	
	@Valid
    @ConvertGroup.List({
		@ConvertGroup(from=PostValidate.class, to=Default.class),
		@ConvertGroup(from=PutValidate.class, to=Default.class)})
	private GlobalLocationNumberBean issuerClearingAgentNumber;
	@Override public GlobalLocationNumberBean getIssuerClearingAgentNumber() { return issuerClearingAgentNumber; }
	@Override public void setIssuerClearingAgentNumber(GlobalLocationNumber issuerClearingAgentNumber) {

		//check for null values (e.g., object created directly by JSONReader)
		this.issuerClearingAgentNumber = (issuerClearingAgentNumber == null) ?
				null : new GlobalLocationNumberBean().init(issuerClearingAgentNumber);
	}
	
	@NotNull(message="distributorNumber is required.")
	@Valid
    @ConvertGroup.List({
		@ConvertGroup(from=PostValidate.class, to=Default.class),
		@ConvertGroup(from=PutValidate.class, to=Default.class)})
	private GlobalLocationNumberBean distributorNumber;
	@Override public GlobalLocationNumberBean getDistributorNumber() { return distributorNumber; }
	@Override public void setDistributorNumber(GlobalLocationNumber distributorNumber) {
		
		this.distributorNumber = (distributorNumber == null) ?
				null : new GlobalLocationNumberBean().init(distributorNumber);
	}
	
	@NotNull(message="offerNumber is required.")
	@GlobalNumber(serializable=false)
	@Valid
    @ConvertGroup.List({
		@ConvertGroup(from=PostValidate.class, to=Default.class),
		@ConvertGroup(from=PutValidate.class, to=Default.class)})
	private GlobalCouponNumberBean offerNumber;
	@Override public GlobalCouponNumberBean getOfferNumber() { return offerNumber; }
	@Override public void setOfferNumber(GlobalCouponNumber offerNumber) {

		this.offerNumber = (offerNumber == null) ?
				null : new GlobalCouponNumberBean().init(offerNumber);
	}
	
	@NotNull(message="timePeriod is required.")
	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private TimePeriodBean timePeriod;
	@Override public TimePeriodBean getTimePeriod() { return timePeriod; }
	@Override public void setTimePeriod(TimePeriod timePeriod) {

		this.timePeriod = (timePeriod == null) ?
				null : TimePeriodBean.class.cast(new TimePeriodBean().init(timePeriod));
	}
	
	@NotNull(message="offerType is required.")
    private OfferType offerType;
	@Override public OfferType getOfferType() { return offerType; }
	@Override public void setOfferType(OfferType offerType) { this.offerType = offerType; }
	
	@NotNull(message="timeZone is required.")
	@Size(max=MAX_TIMEZONE_NAME_LENGTH,
			message="timeZone needs to be " + MAX_TIMEZONE_NAME_LENGTH + " characters or less.")
    private String timeZone;
	@Override public String getTimeZone() { return timeZone; }
	@Override public void setTimeZone(String timeZone) { this.timeZone = timeZone; }
	
	@NotNull(message="offerStatus is required.")
	private OfferStatusType offerStatus;
	@Override public OfferStatusType getOfferStatus() { return offerStatus; }
	@Override public void setOfferStatus(OfferStatusType offerStatus) { this.offerStatus = offerStatus; }
	
	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private DistributionDetailBean distributionDetail;
	@Override public DistributionDetailBean getDistributionDetail() { return distributionDetail; }
	@Override public void setDistributionDetail(DistributionDetail distributionDetail) {
		
		this.distributionDetail = (distributionDetail == null) ?
				null : new DistributionDetailBean().init(distributionDetail);
	}

	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private MarketingMaterialBean marketingMaterial;
	@Override public MarketingMaterialBean getMarketingMaterial() { return marketingMaterial; }
	@Override public void setMarketingMaterial(MarketingMaterial marketingMaterial) {
		
		this.marketingMaterial = (marketingMaterial == null) ?
				null : new MarketingMaterialBean().init(marketingMaterial);
	}
	
	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private RewardBean reward;
	@Override public RewardBean getReward() { return reward; }
	@Override public void setReward(Reward reward) {

		this.reward = (reward == null) ?
				null : new RewardBean().init(reward);
	}
	
	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private PurchaseRequirementBean purchaseRequirement;
	@Override public PurchaseRequirementBean getPurchaseRequirement() { return purchaseRequirement; }
	@Override public void setPurchaseRequirement(PurchaseRequirement purchaseRequirement) {

		this.purchaseRequirement = (purchaseRequirement == null) ?
				null : new PurchaseRequirementBean().init(purchaseRequirement);
	}

	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private UsageConditionBean usageCondition;
	@Override public UsageConditionBean getUsageCondition() { return usageCondition; }
	@Override public void setUsageCondition(UsageCondition usageCondition) {
		
		this.usageCondition = (usageCondition == null) ?
				null : new UsageConditionBean().init(usageCondition);
	}
	
	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private FinancialSettlementDetailBean financialSettlementDetail;
	@Override public FinancialSettlementDetailBean getFinancialSettlementDetail() { return financialSettlementDetail; }
	@Override public void setFinancialSettlementDetail(FinancialSettlementDetail financialSettlementDetail) {

		this.financialSettlementDetail = (financialSettlementDetail == null) ?
				null : new FinancialSettlementDetailBean().init(financialSettlementDetail);
	}

	@Valid
    @ConvertGroup(from=RootValidate.class, to=ChildValidate.class)
	private List<AwarderDetailBean> awarderDetails;
	@Override public List<AwarderDetailBean> getAwarderDetails() { return awarderDetails; }
	@Override public <T extends AwarderDetail> void setAwarderDetails(List<T> awarderDetails) {
		
		this.awarderDetails = new ArrayList<AwarderDetailBean>();
		for (T ad : awarderDetails) {
			this.awarderDetails.add(new AwarderDetailBean().init(ad));
		}
	}
	
    /**
     * Default constructor. 
     */
    public OfferBean() {
    }

	@Override public OfferBean init(OfferInit oi) {
    	
		oi.dispatchInit(this);

		return this;
	}
	
	@Override public OfferBean dispatchInit(OfferBean ob) {
		
		super.dispatchInit(ob);
		
		ob.setId(getId());
		
		return ob;
	}

}