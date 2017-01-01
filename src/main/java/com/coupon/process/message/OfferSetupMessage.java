package com.coupon.process.message;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
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
import com.coupon.common.AwarderDetail;
import com.coupon.common.bean.AwarderDetailBean;
import com.coupon.common.DistributionDetail;
import com.coupon.common.bean.DistributionDetailBean;
import com.coupon.common.FinancialSettlementDetail;
import com.coupon.common.bean.FinancialSettlementDetailBean;
import com.coupon.common.MarketingMaterial;
import com.coupon.common.bean.MarketingMaterialBean;
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
 * Message implementation for OfferSetup
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class OfferSetupMessage implements Serializable {

	private static final long serialVersionUID = 6550981349134962642L;
	
	@NotNull(message="header is a required element of OfferSetupMessage.") @Valid
	private HeaderMsg header;
	public HeaderMsg getHeader() { return header; }
	public void setHeader(HeaderMsg header) { this.header = header; }

	@NotNull(message="issuerNumber is a required element of OfferSetupMessage.") @Valid
	private GlobalLocationNumber issuerNumber;
	public GlobalLocationNumber getIssuerNumber() { return issuerNumber; }
	public void setIssuerNumber(GlobalLocationNumber issuerNumber) {

		this.issuerNumber = new GlobalLocationNumberBean().init(issuerNumber);
	}
	
	@NotNull(message="distributorNumber is a required element of OfferSetupMessage.") @Valid
	private GlobalLocationNumber distributorNumber;
	public GlobalLocationNumber getDistributorNumber() { return distributorNumber; }
	public void setDistributorNumber(GlobalLocationNumber distributorNumber) {
		
		this.distributorNumber = new GlobalLocationNumberBean().init(distributorNumber);
	}
	
	@NotNull(message="couponNumber is a required element of OfferSetupMessage.") @GlobalNumber(serializable=false)
	private GlobalCouponNumber offerNumber;
	public GlobalCouponNumber getOfferNumber() { return offerNumber; }
	public void setOfferNumber(GlobalCouponNumber offerNumber) {
		
		this.offerNumber = new GlobalCouponNumberBean().init(offerNumber);
	}
	
	@NotNull(message="timePeriod is a required element of OfferSetupMessage.") @Valid
	private TimePeriod timePeriod;
	public TimePeriod getTimePeriod() { return timePeriod; }
	public void setTimePeriod(TimePeriod timePeriod) {
		
		this.timePeriod = new TimePeriodBean().init(timePeriod);
	}
	
	@NotNull(message="offerType is a required element of OfferSetupMessage.")
    private OfferType offerType;
	public OfferType getOfferType() { return offerType; }
	public void setOfferType(OfferType offerType) { this.offerType = offerType; }
	
	@NotNull(message="timeZone is a required element of OfferSetupMessage.")
    private String timeZone;
	public String getTimeZone() { return timeZone; }
	public void setTimeZone(String timeZone) { this.timeZone = timeZone; }
	
	private DistributionDetail distributionDetail;
	public DistributionDetail getDistributionDetail() { return distributionDetail; }
	public void setDistributionDetail(DistributionDetail distributionDetail) {
		
		this.distributionDetail = new DistributionDetailBean().init(distributionDetail);
	}

	private MarketingMaterial marketingMaterial;
	public MarketingMaterial getMarketingMaterial() { return marketingMaterial; }
	public void setMarketingMaterial(MarketingMaterial marketingMaterial) {
		
		this.marketingMaterial = new MarketingMaterialBean().init(marketingMaterial);
	}
	
	@NotNull(message="reward is a required element of OfferSetupMessage.")
	private Reward reward;
	public Reward getReward() { return reward; }
	public void setReward(Reward reward) {
		
		this.reward = new RewardBean().init(reward);
	}
	
	@NotNull(message="purchaseRequirement is a required element of OfferSetupMessage.")
	private PurchaseRequirement purchaseRequirement;
	public PurchaseRequirement getPurchaseRequirement() { return purchaseRequirement; }
	public void setPurchaseRequirement(PurchaseRequirement purchaseRequirement) {
		
		this.purchaseRequirement = new PurchaseRequirementBean().init(purchaseRequirement);
	}

	private UsageCondition usageCondition;
	public UsageCondition getUsageCondition() { return usageCondition; }
	public void setUsageCondition(UsageCondition usageCondition) {
		
		this.usageCondition = new UsageConditionBean().init(usageCondition);
	}
	
	private FinancialSettlementDetail financialSettlementDetail;
	public FinancialSettlementDetail getFinancialSettlementDetail() { return financialSettlementDetail; }
	public void setFinancialSettlementDetail(FinancialSettlementDetail financialSettlementDetail) {
		
		this.financialSettlementDetail = new FinancialSettlementDetailBean().init(financialSettlementDetail);
	}

	private List<AwarderDetail> awarderDetails;
	public List<AwarderDetail> getAwarderDetails() { return awarderDetails; }
	public <T extends AwarderDetail> void setAwarderDetails(List<T> awarderDetails) {
		
		this.awarderDetails = new ArrayList<AwarderDetail>();
		for (T ad : awarderDetails) {
			
			getAwarderDetails().add(new AwarderDetailBean().init(ad));
		}
	}

	/**
     * Default constructor. 
     */
    public OfferSetupMessage() {
    }

}