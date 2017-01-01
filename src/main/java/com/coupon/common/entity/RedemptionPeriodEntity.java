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

import com.coupon.common.RedemptionPeriod;
import com.coupon.common.TimePeriod;
import com.coupon.common.bean.RedemptionPeriodBean;
import com.coupon.common.init.RedemptionPeriodInit;

/**
 * Entity bean implementation for OfferRedemptionPeriod
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_redemption_period_tbl")
public class RedemptionPeriodEntity extends RedemptionPeriod implements Record {

	private static final long serialVersionUID = 8459770601025227251L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="orp_tbl_id")
	private Long rpId;
	@Override public Long getId() { return rpId; }
	@Override public void setId(Long rpId) { this.rpId = rpId; }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="oad_tbl_fk", updatable=false, nullable=false)
	private AwarderDetailEntity awarderDetail;
	public AwarderDetailEntity getAwarderDetail() { return awarderDetail; }
	public void setAwarderDetail(AwarderDetailEntity awarderDetail) { this.awarderDetail = awarderDetail; }

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
    public RedemptionPeriodEntity() {
    }

	@Override public RedemptionPeriodEntity init(RedemptionPeriodInit rpi) {
    	
		rpi.dispatchInit(this);
		
		return this;
    }

	@Override public RedemptionPeriodBean dispatchInit(RedemptionPeriodBean rpb) {
    	
		super.dispatchInit(rpb);

	    	rpb.setId(getId());
	    	rpb.setParentId(getAwarderDetail().getId());
	    	
	    	return rpb;
    }

}