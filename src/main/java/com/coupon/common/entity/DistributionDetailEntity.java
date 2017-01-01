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
import javax.persistence.MapKey;
import javax.persistence.MapKeyClass;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import com.coupon.common.AcquisitionPeriod;
import com.coupon.common.DistributionDetail;
import com.coupon.common.PublicationPeriod;
import com.coupon.common.TimePeriod;
import com.coupon.common.bean.DistributionDetailBean;
import com.coupon.common.init.DistributionDetailInit;


/**
 * Entity bean implementation for OfferDistributionDetail
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_distribution_detail_tbl")
@NamedQuery(name="DistributionDetailEntity.findByCouponNumber",
			query="SELECT o FROM DistributionDetailEntity o "
					+ "WHERE o.offer.offerNumber = :offerNumber ")
public class DistributionDetailEntity extends DistributionDetail implements Record {

	private static final long serialVersionUID = 8747665604278242990L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="odd_tbl_id")
	private Long ddId;
    @Override public Long getId() { return ddId; }
    @Override public void setId(Long ddId) { this.ddId = ddId; }

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cpn_tbl_fk", updatable=false, nullable=false)
	private OfferEntity offer;
	public OfferEntity getOffer() { return offer; }
	public void setOffer(OfferEntity offer) { this.offer = offer; }

	@OneToOne(fetch=FetchType.LAZY, mappedBy="distributionDetail", cascade=CascadeType.ALL)
	private PublicationPeriodEntity publicationPeriod;
	@Override public PublicationPeriodEntity getPublicationPeriod() { return publicationPeriod; }
	public void setPublicationPeriod(PublicationPeriodEntity publicationPeriod) { this.publicationPeriod = publicationPeriod; }
	@Override public void setPublicationPeriod(PublicationPeriod publicationPeriod) { this.publicationPeriod.init(publicationPeriod); }

	@OneToMany(fetch=FetchType.LAZY, mappedBy="distributionDetail", cascade=CascadeType.ALL)
	@OrderBy(value="timePeriod.startDateTime ASC")
	@MapKey(name="timePeriod")
	@MapKeyClass(TimePeriod.class)
	private Map<TimePeriod, AcquisitionPeriodEntity> acquisitionPeriodsMap;
	public Map<TimePeriod, AcquisitionPeriodEntity> getAcquisitionPeriodsMap() { return acquisitionPeriodsMap; }
	public void setAcquisitionPeriodsMap(Map<TimePeriod, AcquisitionPeriodEntity> acquisitionPeriodsMap) { this.acquisitionPeriodsMap = acquisitionPeriodsMap; }

    @Override public List<AcquisitionPeriodEntity> getAcquisitionPeriods() {

    		return (getAcquisitionPeriodsMap() == null) ?
    				null : new ArrayList<AcquisitionPeriodEntity>(getAcquisitionPeriodsMap().values());
    }

    @Override public <T extends AcquisitionPeriod> void setAcquisitionPeriods(List<T> acquisitionPeriods) {

		for (T ap : acquisitionPeriods) {
			if (getAcquisitionPeriodsMap().containsKey(ap.getTimePeriod())) {
				getAcquisitionPeriodsMap().get(ap.getTimePeriod()).init(ap);
			}
		}
	}

	@Column(name="maximum_offer_acquisition", columnDefinition="INT UNSIGNED DEFAULT NULL")
    private Long maximumOfferAcquisition;
	@Override public Long getMaximumOfferAcquisition() { return maximumOfferAcquisition; }
	@Override public void setMaximumOfferAcquisition(Long maximumOfferAcquisition) { this.maximumOfferAcquisition = maximumOfferAcquisition; }

	@Column(name="total_acquisition_count", columnDefinition="INT UNSIGNED DEFAULT NULL")
    private Long totalAcquisitionCount;
	@Override public Long getTotalAcquisitionCount() { return totalAcquisitionCount; }
	@Override public void setTotalAcquisitionCount(Long totalAcquisitionCount) { this.totalAcquisitionCount = totalAcquisitionCount; }

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
    public DistributionDetailEntity() {
    }

	@Override public DistributionDetailEntity init(DistributionDetailInit ddi) {

		ddi.dispatchInit(this);

		return this;
	}
	
	@Override public DistributionDetailBean dispatchInit(DistributionDetailBean ddb) {

		super.dispatchInit(ddb);

		ddb.setId(getId());
		ddb.setParentId(getOffer().getId());
		
		return ddb;
    }

}