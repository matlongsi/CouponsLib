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

import com.coupon.common.UsageCondition;
import com.coupon.common.bean.UsageConditionBean;
import com.coupon.common.init.UsageConditionInit;


/**
 * Entity bean implementation for OfferUsageCondition
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_usage_condition_tbl")
public class UsageConditionEntity extends UsageCondition implements Record {

	private static final long serialVersionUID = -4930511001891074819L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ouc_tbl_id")
	private Long ucId;
	@Override public Long getId() { return ucId; }
	@Override public void setId(Long ucId) { this.ucId = ucId; }

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cpn_tbl_fk", updatable=false, nullable=false)
	private OfferEntity offer;
    public OfferEntity getOffer() { return offer; }
	public void setOffer(OfferEntity offer) { this.offer = offer; }

	@Column(name="maximum_cumulative_use")
    private Short maximumCumulativeUse;
    @Override public Short getMaximumCumulativeUse() { return maximumCumulativeUse; }
	@Override public void setMaximumCumulativeUse(Short maximumCumulativeUse) { this.maximumCumulativeUse = maximumCumulativeUse; }

	@Column(name="maximum_use_per_transaction")
	private Short maximumUsePerTransaction;
    @Override public Short getMaximumUsePerTransaction() { return maximumUsePerTransaction; }
	@Override public void setMaximumUsePerTransaction(Short maximumUsePerTransaction) { this.maximumUsePerTransaction = maximumUsePerTransaction; }

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
    public UsageConditionEntity() {
    }

    @Override public UsageConditionEntity init(UsageConditionInit uci) {

	    	uci.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public UsageConditionBean dispatchInit(UsageConditionBean ucb) {

		super.dispatchInit(ucb);
		
		ucb.setId(getId());
	    	ucb.setParentId(getOffer().getId());
	    	
	    	return ucb;
    }

}