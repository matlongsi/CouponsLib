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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;

import com.coupon.common.AcquisitionPeriod;
import com.coupon.common.TimePeriod;
import com.coupon.common.bean.AcquisitionPeriodBean;
import com.coupon.common.entity.TimePeriodEmbed;
import com.coupon.common.init.AcquisitionPeriodInit;


/**
 * Entity bean implementation for OfferAcquisitionPeriod
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_acquisition_period_tbl")
public class AcquisitionPeriodEntity extends AcquisitionPeriod implements Record {

	private static final long serialVersionUID = 5239385314676955426L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="oap_tbl_id")
	private Long apId;
	@Override public Long getId() { return apId; }
	@Override public void setId(Long apId) { this.apId = apId; }
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="odd_tbl_fk", updatable=false, nullable=false)
	private DistributionDetailEntity distributionDetail;
    public DistributionDetailEntity getDistributionDetail() { return distributionDetail; }
	public void setDistributionDetail(DistributionDetailEntity distributionDetail) { this.distributionDetail = distributionDetail; }

    @Embedded
	private TimePeriodEmbed timePeriod;
    @Override public TimePeriodEmbed getTimePeriod() { return timePeriod; }
    public void setTimePeriod(TimePeriodEmbed timePeriod) { this.timePeriod = timePeriod; }
    @Override public void setTimePeriod(TimePeriod timePeriod) { this.timePeriod.init(timePeriod); }

	@Embedded
	private RecordHistoryEmbed recordHistory;
	@Override public RecordHistoryEmbed getRecordHistory() { return recordHistory; }
	@Override public void setRecordHistory(RecordHistoryEmbed recordHistory) { this.recordHistory = recordHistory; }

	@Version
    @Column(name="optimistic_lock_version", columnDefinition="INT UNSIGNED DEFAULT 0", nullable=false)
    private Integer optimisticLockVersion;
	@Override public Integer getOptimisticLockVersion() { return optimisticLockVersion; }
	@Override public void setOptimisticLockVersion(Integer optimisticLockVersion) { this.optimisticLockVersion = optimisticLockVersion; }
	
    /**
     * Default constructor. 
     */
    public AcquisitionPeriodEntity() {
    }
    
    @Override public AcquisitionPeriodEntity init(AcquisitionPeriodInit api) {

		api.dispatchInit(this);
		
		return this;
    }

    @Override public AcquisitionPeriodBean dispatchInit(AcquisitionPeriodBean apb) {

    		super.dispatchInit(apb);

    		apb.setId(getId());
		apb.setParentId(getDistributionDetail().getId());

		return apb;
	}
	
}