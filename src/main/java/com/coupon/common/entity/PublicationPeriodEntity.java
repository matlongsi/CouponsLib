package com.coupon.common.entity;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.coupon.common.PublicationPeriod;
import com.coupon.common.TimePeriod;
import com.coupon.common.bean.PublicationPeriodBean;
import com.coupon.common.init.PublicationPeriodInit;


/**
 * Entity bean implementation for OfferPublicationPeriod
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name = "offer_publication_period_tbl")
public class PublicationPeriodEntity extends PublicationPeriod implements Record {

	private static final long serialVersionUID = -4585327025408841772L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="opp_tbl_id")
	private Long ppId;
	@Override public Long getId() { return ppId; }
    @Override public void setId(Long ppId) { this.ppId = ppId; }

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="odd_tbl_fk", updatable=false, nullable=false)
	private DistributionDetailEntity distributionDetail;
	public DistributionDetailEntity getDistributionDetail() { return distributionDetail; }
	public void setDistributionDetail(DistributionDetailEntity distributionDetail) { this.distributionDetail = distributionDetail; }

    @Embedded
	private TimePeriodEmbed timePeriod;
    @Override public TimePeriodEmbed getTimePeriod() { return timePeriod; }
    public void setTimePeriod(TimePeriodEmbed timePeriod) { this.timePeriod = timePeriod; }
    @Override public void setTimePeriod(TimePeriod timePeriod) { this.timePeriod.init(timePeriod); }

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
    public PublicationPeriodEntity() {
    }

    @Override public PublicationPeriodEntity init(PublicationPeriodInit ppi) {

	    	ppi.dispatchInit(this);
	    	
	    	return this;
    }

    @Override public PublicationPeriodBean dispatchInit(PublicationPeriodBean ppb) {
		
    	super.dispatchInit(ppb);

    		ppb.setId(getId());
		ppb.setParentId(getDistributionDetail().getId());

		return ppb;
	}

}