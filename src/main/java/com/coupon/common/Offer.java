package com.coupon.common;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlSeeAlso;

import org.eclipse.persistence.oxm.annotations.XmlDiscriminatorNode;

import com.coupon.common.bean.OfferBean;
import com.coupon.common.init.OfferInit;
import com.coupon.common.type.OfferStatusType;
import com.coupon.common.type.OfferType;
import com.coupon.common.utils.ListCompare;


/**
 * Bean abstract class for Coupon
 */
@XmlSeeAlso({OfferBean.class})
@XmlDiscriminatorNode("@type")
public abstract class Offer implements Serializable, OfferInit {

	private static final long serialVersionUID = -8223413281597691268L;

	public final static int MAX_TIMEZONE_NAME_LENGTH = 50;
	
	public abstract GlobalCouponNumber getOfferNumber();
	public abstract void setOfferNumber(GlobalCouponNumber offerNumber);

	public abstract GlobalLocationNumber getDistributorNumber();
	public abstract void setDistributorNumber(GlobalLocationNumber distributorNumber);

	public abstract GlobalLocationNumber getIssuerNumber();
	public abstract void setIssuerNumber(GlobalLocationNumber issuerNumber);

	public abstract GlobalLocationNumber getIssuerClearingAgentNumber();
	public abstract void setIssuerClearingAgentNumber(GlobalLocationNumber issuerClearingAgentNumber);

	public abstract OfferType getOfferType();
	public abstract void setOfferType(OfferType offerType);

	public abstract OfferStatusType getOfferStatus();
	public abstract void setOfferStatus(OfferStatusType offerStatus);

	public abstract TimePeriod getTimePeriod();
	public abstract void setTimePeriod(TimePeriod timePeriod);

	public abstract String getTimeZone();
	public abstract void setTimeZone(String timeZone);

	public abstract Reward getReward();
	public abstract void setReward(Reward reward);

	public abstract DistributionDetail getDistributionDetail();
	public abstract void setDistributionDetail(DistributionDetail distributionDetail);

	public abstract MarketingMaterial getMarketingMaterial();
	public abstract void setMarketingMaterial(MarketingMaterial marketingMaterial);

	public abstract List<? extends AwarderDetail> getAwarderDetails();
	public abstract <T extends AwarderDetail> void setAwarderDetails(List<T> awarderDetails);

	public abstract PurchaseRequirement getPurchaseRequirement();
	public abstract void setPurchaseRequirement(PurchaseRequirement purchaseRequirement);

	public abstract UsageCondition getUsageCondition();
	public abstract void setUsageCondition(UsageCondition usageCondition);

	public abstract FinancialSettlementDetail getFinancialSettlementDetail();
	public abstract void setFinancialSettlementDetail(FinancialSettlementDetail financialSettlementDetail);

	/**
     * Default constructor. 
     */
    public Offer() {
    }

    @Override public boolean equals(Object obj) {

	    	if (obj == this) {
	    		return true;
	    	}
	    	if ((obj == null) || !Offer.class.isInstance(obj)) {
	    		return false;
	    	}
	    	
	    	Offer o = Offer.class.cast(obj);
	
	    	return (getOfferStatus() == o.getOfferStatus()) &&
	    			(getOfferType() == o.getOfferType()) &&
			    	getTimeZone().equals(o.getTimeZone()) &&
			    	((getIssuerNumber() == null) ? (o.getIssuerNumber() == null) :
						getIssuerNumber().equals(o.getIssuerNumber())) &&
				((getIssuerClearingAgentNumber() == null) ? (o.getIssuerClearingAgentNumber() == null) :
					getIssuerNumber().equals(o.getIssuerNumber())) &&
				((getDistributorNumber() == null) ? (o.getDistributorNumber() == null) :
					getDistributorNumber().equals(o.getDistributorNumber())) &&
				((getOfferNumber() == null) ? (o.getOfferNumber() == null) :
					getOfferNumber().equals(o.getOfferNumber())) &&
				((getDistributionDetail() == null) ? (o.getDistributionDetail() == null) :
					getDistributionDetail().equals(o.getDistributionDetail())) &&
				((getMarketingMaterial() == null) ? (o.getMarketingMaterial() == null) :
					getMarketingMaterial().equals(o.getMarketingMaterial())) &&
				((getUsageCondition() == null) ? (o.getUsageCondition() == null) :
					getUsageCondition().equals(o.getUsageCondition())) &&
				((getFinancialSettlementDetail() == null) ? (o.getFinancialSettlementDetail() == null) :
					getFinancialSettlementDetail().equals(o.getFinancialSettlementDetail())) &&
				((getReward() == null) ? (o.getReward() == null) :
					getReward().equals(o.getReward())) &&
				((getPurchaseRequirement() == null) ? (o.getPurchaseRequirement() == null) :
					getPurchaseRequirement().equals(o.getPurchaseRequirement())) &&
				((getTimePeriod() == null) ? (o.getTimePeriod() == null) :
					getTimePeriod().equals(o.getTimePeriod())) &&
				ListCompare.<AwarderDetail>equal(getAwarderDetails(), o.getAwarderDetails());
    }
    
	@Override public Offer doInit(Offer o) {

	    	o.setIssuerNumber(getIssuerNumber());
	    	o.setDistributorNumber(getDistributorNumber());
	    	o.setOfferNumber(getOfferNumber());
	    	o.setOfferType(getOfferType());
	    	o.setTimeZone(getTimeZone());
	    	o.setOfferStatus(getOfferStatus());
	    	o.setTimePeriod(getTimePeriod());
	
	    	if (getIssuerClearingAgentNumber() != null) {
	    		o.setIssuerClearingAgentNumber(getIssuerClearingAgentNumber());
	    	}
	    	if (getDistributionDetail() != null) {
	    		o.setDistributionDetail(getDistributionDetail());
	    	}
	    	if (getMarketingMaterial() != null) {
	    		o.setMarketingMaterial(getMarketingMaterial());
	    	}
	    	if (getReward() != null) {
	    		o.setReward(getReward());
	    	}
	    	if (getPurchaseRequirement() != null) {
	    		o.setPurchaseRequirement(getPurchaseRequirement());
	    	}
	    	if (getUsageCondition() != null) {
	    		o.setUsageCondition(getUsageCondition());
	    	}
	    	if (getFinancialSettlementDetail() != null) {
	    		o.setFinancialSettlementDetail(getFinancialSettlementDetail());
	    	}
	    	if (getAwarderDetails() != null) {
	    		o.setAwarderDetails(getAwarderDetails());
	    	}
	    	
	    	return o;
    }

}