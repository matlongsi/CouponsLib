package com.coupon.process.entity;

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
import com.coupon.common.entity.Record;
import com.coupon.common.entity.RecordListener;
import com.coupon.common.entity.GlobalTradeIdentificationNumberEntity;
import com.coupon.common.entity.RecordHistoryEmbed;
import com.coupon.common.init.RewardTradeItemInit;


/**
 * Entity bean implementation for CouponRewardTradeItem
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="coupon_reward_trade_item_tbl")
public class CouponRewardTradeItemEntity extends RewardTradeItem implements Record {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="crti_tbl_id")
	private Long crtiId;
	@Override public Long getId() { return crtiId; }
	@Override public void setId(Long crtiId) { this.crtiId = crtiId; }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cr_tbl_fk", updatable=false, nullable=false)
	private CouponRewardEntity reward;
	public CouponRewardEntity getReward() { return reward; }
	public void setReward(CouponRewardEntity reward) { this.reward = reward; }

    @ManyToOne(optional=false, fetch=FetchType.LAZY)
	@JoinColumn(name="trade_item_gtin_fk", referencedColumnName="gtin_tbl_id")
    private GlobalTradeIdentificationNumberEntity tradeItemNumber;
    @Override public GlobalTradeIdentificationNumber getTradeItemNumber() { return tradeItemNumber; }
    @Override public void setTradeItemNumber(GlobalTradeIdentificationNumber tradeItemNumber) { this.tradeItemNumber = GlobalTradeIdentificationNumberEntity.class.cast(tradeItemNumber); }

	@Column(name="trade_item_quantity", columnDefinition="INT UNSIGNED", nullable=false)
	private Short tradeItemQuantity;
	@Override public Short getTradeItemQuantity() { return tradeItemQuantity; }
	@Override public void setTradeItemQuantity(Short tradeItemQuantity) { this.tradeItemQuantity = tradeItemQuantity; }

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
    public CouponRewardTradeItemEntity() {
    }

    @Override public CouponRewardTradeItemEntity init(RewardTradeItemInit rtii) {
    	
    	rtii.dispatchInit(this);
    	
    	return this;
    }

}