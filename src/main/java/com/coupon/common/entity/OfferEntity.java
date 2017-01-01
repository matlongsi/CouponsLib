package com.coupon.common.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapKey;
import javax.persistence.MapKeyClass;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Version;

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
import com.coupon.common.bean.OfferBean;
import com.coupon.common.init.OfferInit;
import com.coupon.common.type.OfferStatusType;
import com.coupon.common.type.OfferType;


/**
 * Entity bean implementation for Coupon
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="coupon_tbl")
@NamedQuery(name="OfferEntity.findByCouponNumber",
			query="SELECT o FROM OfferEntity o "
					+ "WHERE o.offerNumber = :offerNumber ")
public class OfferEntity extends Offer implements Record {

	private static final long serialVersionUID = -7566641821161762555L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="coupon_tbl_id")
	private Long offerId;
    @Override public Long getId() { return offerId; }
	@Override public void setId(Long offerId) { this.offerId = offerId; }

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="offer_issuer_fk", referencedColumnName="gln_tbl_id", updatable=false)
	private GlobalLocationNumberEntity issuerNumber;
	@Override public GlobalLocationNumberEntity getIssuerNumber() { return issuerNumber; }
	@Override public void setIssuerNumber(GlobalLocationNumber issuerNumber) { this.issuerNumber = GlobalLocationNumberEntity.class.cast(issuerNumber); }

	@ManyToOne(optional=true, fetch=FetchType.LAZY)
	@JoinColumn(name="offer_issuer_clearing_agent_fk", referencedColumnName="gln_tbl_id")
	private GlobalLocationNumberEntity issuerClearingAgentNumber;
	@Override public GlobalLocationNumberEntity getIssuerClearingAgentNumber() { return issuerClearingAgentNumber; }
	@Override public void setIssuerClearingAgentNumber(GlobalLocationNumber issuerClearingAgentNumber) { this.issuerClearingAgentNumber = GlobalLocationNumberEntity.class.cast(issuerClearingAgentNumber); }

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="offer_distributor_fk", referencedColumnName="gln_tbl_id")
	private GlobalLocationNumberEntity distributorNumber;
	@Override public GlobalLocationNumberEntity getDistributorNumber() { return distributorNumber; }
	@Override public void setDistributorNumber(GlobalLocationNumber distributorNumber) { this.distributorNumber = GlobalLocationNumberEntity.class.cast(distributorNumber); }

	@OneToOne(optional=false, fetch=FetchType.LAZY, cascade=CascadeType.ALL)
	@JoinColumn(name="coupon_offer_fk", referencedColumnName="gcn_tbl_id")
	private GlobalCouponNumberEntity offerNumber;
	@Override public GlobalCouponNumberEntity getOfferNumber() { return offerNumber; }
	@Override public void setOfferNumber(GlobalCouponNumber offerNumber) { this.offerNumber = GlobalCouponNumberEntity.class.cast(offerNumber); }

	@Column(name="offer_type_code")
	@Enumerated(EnumType.STRING)
    private OfferType offerType;
	@Override public OfferType getOfferType() { return offerType; }
	@Override public void setOfferType(OfferType offerType) { this.offerType = offerType; }
	
	@Column(name="time_zone", columnDefinition="VARCHAR", length=MAX_TIMEZONE_NAME_LENGTH)
    private TimeZone timeZone;
	@Override public String getTimeZone() { return timeZone.getID(); }
	@Override public void setTimeZone(String timeZone) { this.timeZone = TimeZone.getTimeZone(timeZone); }

	@Column(name="status")
	@Enumerated(EnumType.STRING)
	private OfferStatusType offerStatus;
	@Override public OfferStatusType getOfferStatus() { return offerStatus; }
	@Override public void setOfferStatus(OfferStatusType offerStatus) { this.offerStatus = offerStatus; }

	@Embedded
	private TimePeriodEmbed timePeriod;
	@Override public TimePeriodEmbed getTimePeriod() { return timePeriod; }
	@Override public void setTimePeriod(TimePeriod timePeriod) {
		
		this.timePeriod = new TimePeriodEmbed().init(timePeriod);
	}
	
	@OneToOne(optional=true, fetch=FetchType.LAZY, mappedBy="offer", cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="coupon_tbl_id", referencedColumnName="cpn_tbl_fk")
	private DistributionDetailEntity distributionDetail;
	@Override public DistributionDetailEntity getDistributionDetail() { return distributionDetail; }
	@Override public void setDistributionDetail(DistributionDetail distributionDetail) { this.distributionDetail = DistributionDetailEntity.class.cast(distributionDetail); }

	@OneToOne(optional=true, fetch=FetchType.LAZY, mappedBy="offer", cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="coupon_tbl_id", referencedColumnName="cpn_tbl_fk")
	private MarketingMaterialEntity marketingMaterial;
	@Override public MarketingMaterialEntity getMarketingMaterial() { return marketingMaterial; }
	@Override public void setMarketingMaterial(MarketingMaterial marketingMaterial) { this.marketingMaterial = MarketingMaterialEntity.class.cast(marketingMaterial); }

	@OneToOne(optional=true, fetch=FetchType.LAZY, mappedBy="offer", cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="coupon_tbl_id", referencedColumnName="cpn_tbl_fk")
	private RewardEntity reward;
	@Override public RewardEntity getReward() { return reward; }
	@Override public void setReward(Reward reward) { this.reward = RewardEntity.class.cast(reward); }

	@OneToOne(optional=true, fetch=FetchType.LAZY, mappedBy="offer", cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="coupon_tbl_id", referencedColumnName="cpn_tbl_fk")
	private PurchaseRequirementEntity purchaseRequirement;
	@Override public PurchaseRequirementEntity getPurchaseRequirement() { return purchaseRequirement; }
	@Override public void setPurchaseRequirement(PurchaseRequirement purchaseRequirement) { this.purchaseRequirement = PurchaseRequirementEntity.class.cast(purchaseRequirement); }

	@OneToMany(fetch=FetchType.LAZY, mappedBy="offer", cascade=CascadeType.ALL)
	@OrderBy(value="adId ASC")
	@MapKey(name="awarderNumber")
	@MapKeyClass(GlobalLocationNumber.class)
	private Map<GlobalLocationNumber, AwarderDetailEntity> awarderDetailsMap;
	public Map<GlobalLocationNumber, AwarderDetailEntity> getAwarderDetailsMap() { return awarderDetailsMap; }
	public void setAwarderDetailsMap(Map<GlobalLocationNumber, AwarderDetailEntity> awarderDetailsMap) { this.awarderDetailsMap = awarderDetailsMap; }

	@Override public List<AwarderDetailEntity> getAwarderDetails() {

		return (getAwarderDetailsMap() == null) ?
				null : new ArrayList<AwarderDetailEntity>(getAwarderDetailsMap().values());
	}
	
	@Override public <T extends AwarderDetail> void setAwarderDetails(List<T> awarderDetails) {

		for (T ad : awarderDetails) {
			if (getAwarderDetailsMap().containsKey(ad.getAwarderNumber())) {
				getAwarderDetailsMap().get(ad.getAwarderNumber()).init(ad);
			}
		}
	}

	@OneToOne(optional=true, fetch=FetchType.LAZY, mappedBy="offer", cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="coupon_tbl_id", referencedColumnName="cpn_tbl_fk")
	private UsageConditionEntity usageCondition;
	@Override public UsageConditionEntity getUsageCondition() { return usageCondition; }
	@Override public void setUsageCondition(UsageCondition usageCondition) { this.usageCondition = UsageConditionEntity.class.cast(usageCondition); }

	@OneToOne(optional=true, fetch=FetchType.LAZY, mappedBy="offer", cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn(name="coupon_tbl_id", referencedColumnName="cpn_tbl_fk")
	private FinancialSettlementDetailEntity financialSettlementDetail;
	@Override public FinancialSettlementDetailEntity getFinancialSettlementDetail() { return financialSettlementDetail; }
	@Override public void setFinancialSettlementDetail(FinancialSettlementDetail financialSettlementDetail) { this.financialSettlementDetail = FinancialSettlementDetailEntity.class.cast(financialSettlementDetail); }

    @Version
    @Column(name="optimistic_lock_version", columnDefinition="INT UNSIGNED DEFAULT 0", nullable=false)
    private Integer optimisticLockVersion;
	@Override public Integer getOptimisticLockVersion() { return optimisticLockVersion; }
	@Override public void setOptimisticLockVersion(Integer optimisticLockVersion) { this.optimisticLockVersion = optimisticLockVersion; }

    @Embedded
	private RecordHistoryEmbed recordHistory;
    @Override public RecordHistoryEmbed getRecordHistory() { return recordHistory; }
    @Override public void setRecordHistory(RecordHistoryEmbed recordHistory) { this.recordHistory = recordHistory; }

    /**
     * Default constructor. 
     */
    public OfferEntity() {
    }

    @Override public OfferEntity init(OfferInit oi) {

	    	oi.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public OfferBean dispatchInit(OfferBean ob) {
		
		super.dispatchInit(ob);
		
		ob.setId(getId());
		
		return ob;
	}

}