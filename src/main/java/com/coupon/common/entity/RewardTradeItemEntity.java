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

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.RewardTradeItem;
import com.coupon.common.bean.RewardTradeItemBean;
import com.coupon.common.init.RewardTradeItemInit;

/**
 * Entity bean implementation for OfferRewardTradeItem
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_reward_trade_item_tbl")
public class RewardTradeItemEntity extends RewardTradeItem implements Record {

	private static final long serialVersionUID = 7350286801652182412L;

	@Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="orti_tbl_id")
	private Long rtiId;
    @Override public Long getId() { return rtiId; }
	@Override public void setId(Long rtiId) { this.rtiId = rtiId; }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="or_tbl_fk", updatable=false, nullable=false)
	private RewardEntity reward;
	public RewardEntity getReward() { return reward; }
	public void setReward(RewardEntity reward) { this.reward = reward; }

    @ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="trade_item_gtin_fk", referencedColumnName="gtin_tbl_id", updatable=false)
    private GlobalTradeIdentificationNumberEntity tradeItemNumber;
    @Override public GlobalTradeIdentificationNumberEntity getTradeItemNumber() { return tradeItemNumber; }
	@Override public void setTradeItemNumber(GlobalTradeIdentificationNumber tradeItemNumber) { this.tradeItemNumber = GlobalTradeIdentificationNumberEntity.class.cast(tradeItemNumber); }

	@Column(name="trade_item_quantity")
	private Short tradeItemQuantity;
	@Override public Short getTradeItemQuantity() { return tradeItemQuantity; }
	@Override public void setTradeItemQuantity(Short tradeItemQuantity) { this.tradeItemQuantity = tradeItemQuantity; }

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
    public RewardTradeItemEntity() {
    }

    @Override public RewardTradeItemEntity init(RewardTradeItemInit rtii) {

	    	rtii.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public RewardTradeItemBean dispatchInit(RewardTradeItemBean rtib) {

		super.dispatchInit(rtib);
		
	    	rtib.setId(getId());
	    	rtib.setParentId(getReward().getId());
	    	
	    	return rtib;
    }

}