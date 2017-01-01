package com.coupon.common.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
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
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import com.coupon.common.AwarderDetail;
import com.coupon.common.AwarderPointOfSale;
import com.coupon.common.GlobalLocationNumber;
import com.coupon.common.RedemptionPeriod;
import com.coupon.common.TimePeriod;
import com.coupon.common.bean.AwarderDetailBean;
import com.coupon.common.init.AwarderDetailInit;


/**
 * Entity bean implementation for OfferAwarderDetail
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name = "offer_awarder_detail_tbl",
	uniqueConstraints=@UniqueConstraint(name="UNIQUE_OFFER_AWARDER", columnNames={"cpn_tbl_fk", "offer_awarder_fk"}))
@NamedQuery(name="AwarderDetailEntity.findByCouponAndAwarderNumber",
			query="SELECT a FROM AwarderDetailEntity a "
					+ "WHERE a.offer.offerNumber = :offerNumber "
					+ "AND a.awarderNumber = :awarderNumber ")
public class AwarderDetailEntity extends AwarderDetail implements Record {

	private static final long serialVersionUID = -340030364111832728L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oad_tbl_id")
	private Long adId;
	@Override public Long getId() { return adId; }
	@Override public void setId(Long adId) { this.adId = adId; }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cpn_tbl_fk", updatable=false, nullable=false)
	private OfferEntity offer;
    public OfferEntity getOffer() { return offer; }
	public void setOffer(OfferEntity offer) { this.offer = offer; }

	@ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name = "offer_awarder_fk", referencedColumnName = "gln_tbl_id")
	private GlobalLocationNumberEntity awarderNumber;
	@Override public GlobalLocationNumberEntity getAwarderNumber() { return awarderNumber; }
	@Override public void setAwarderNumber(GlobalLocationNumber awarderNumber) { this.awarderNumber = GlobalLocationNumberEntity.class.cast(awarderNumber); }

	@ManyToOne(optional=true, fetch=FetchType.LAZY)
	@JoinColumn(name="offer_awarder_clearing_agent_fk", referencedColumnName="gln_tbl_id")
	private GlobalLocationNumberEntity awarderClearingAgentNumber;
	@Override public GlobalLocationNumberEntity getAwarderClearingAgentNumber() { return awarderClearingAgentNumber; }
	@Override public void setAwarderClearingAgentNumber(GlobalLocationNumber awarderClearingAgentNumber) { this.awarderClearingAgentNumber = GlobalLocationNumberEntity.class.cast(awarderClearingAgentNumber); }

	@OneToMany(fetch=FetchType.LAZY, mappedBy="awarderDetail", cascade=CascadeType.ALL)
	@OrderBy(value="timePeriod.startDateTime ASC")
	@MapKey(name="timePeriod")
	@MapKeyClass(TimePeriod.class)
	private Map<TimePeriod, RedemptionPeriodEntity> redemptionPeriodsMap;
	public Map<TimePeriod, RedemptionPeriodEntity> getRedemptionPeriodsMap() { return redemptionPeriodsMap; }
	public void setRedemptionPeriodsMap(Map<TimePeriod, RedemptionPeriodEntity> redemptionPeriodsMap) { this.redemptionPeriodsMap = redemptionPeriodsMap; }

	@Override public List<RedemptionPeriodEntity> getRedemptionPeriods() {
		
		return (getRedemptionPeriodsMap() == null) ?
				null : new ArrayList<RedemptionPeriodEntity>(getRedemptionPeriodsMap().values());
	}

	@Override public <T extends RedemptionPeriod> void setRedemptionPeriods(List<T> redemptionPeriods) {

		for (T rp : redemptionPeriods) {
			if (getRedemptionPeriodsMap().containsKey(rp.getTimePeriod())) {
				getRedemptionPeriodsMap().get(rp.getTimePeriod()).init(rp);
			}
		}
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="awarderDetail", cascade=CascadeType.ALL)
	@OrderBy(value="storeInternalId ASC")
	@MapKey(name="storeNumber")
	@MapKeyClass(GlobalLocationNumber.class)
	private Map<GlobalLocationNumber, AwarderPointOfSaleEntity> pointOfSalesMap;
	public Map<GlobalLocationNumber, AwarderPointOfSaleEntity> getPointOfSalesMap() { return pointOfSalesMap; }
	public void setPointOfSalesMap(Map<GlobalLocationNumber, AwarderPointOfSaleEntity> pointOfSalesMap) { this.pointOfSalesMap = pointOfSalesMap; }
	
	@Override public List<AwarderPointOfSaleEntity> getPointOfSales() {
		
		return new ArrayList<AwarderPointOfSaleEntity>(getPointOfSalesMap().values());
	}

	@Override public <T extends AwarderPointOfSale> void setPointOfSales(List<T> pointOfSales) {

		for (T apos : pointOfSales) {
			if (getPointOfSalesMap().containsKey(apos.getStoreNumber())) {
				getPointOfSalesMap().get(apos.getStoreNumber()).init(apos);
			}
		}
	}

	@Version
    @Column(name = "optimistic_lock_version", columnDefinition = "INT UNSIGNED DEFAULT 0", nullable = false)
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
    public AwarderDetailEntity() {
    }

    @Override public AwarderDetailEntity init(AwarderDetailInit adi) {
    	
	    	adi.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public AwarderDetailBean dispatchInit(AwarderDetailBean adb) {
    	
		super.dispatchInit(adb);
			
	    	adb.setId(getId());
	    	adb.setParentId(getOffer().getId());
	
	    	return adb;
    }

}