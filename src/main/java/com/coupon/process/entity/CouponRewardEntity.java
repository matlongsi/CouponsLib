package com.coupon.process.entity;

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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.Reward;
import com.coupon.common.RewardLoyaltyPoint;
import com.coupon.common.RewardTradeItem;
import com.coupon.common.entity.Record;
import com.coupon.common.entity.RecordListener;
import com.coupon.common.entity.RecordHistoryEmbed;
import com.coupon.common.init.RewardInit;
import com.coupon.common.type.RewardType;


/**
 * Entity bean implementation for CouponReward
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="coupon_reward_tbl")
public class CouponRewardEntity extends Reward implements Record {

	private static final long serialVersionUID = 1053281740763501410L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="cr_tbl_id")
	private Long crId;
	@Override public Long getId() { return crId; }
	@Override public void setId(Long crId) { this.crId = crId; }

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="coupon_redemption_record_tbl_fk", updatable=false, nullable=false)
	private CouponRedemptionRecordEntity couponRedemptionRecord;
    public CouponRedemptionRecordEntity getCouponRedemptionRecord() { return couponRedemptionRecord; }
	public void setCouponRedemptionRecord(CouponRedemptionRecordEntity couponRedemptionRecord) { this.couponRedemptionRecord = couponRedemptionRecord; }

	@Column(name="reward_type_code")
    @Enumerated(EnumType.STRING)
	private RewardType rewardType;
	@Override public RewardType getRewardType() { return rewardType; }
	@Override public void setRewardType(RewardType rewardType) { this.rewardType = rewardType; }

	@Column(name="rewarded_monetary_amount", columnDefinition="DECIMAL(10, 2)")
	private Float rewardedMonetaryAmount;
	@Override public Float getRewardMonetaryAmount() { return rewardedMonetaryAmount; }
	@Override public void setRewardMonetaryAmount(Float rewardedMonetaryAmount) { this.rewardedMonetaryAmount = rewardedMonetaryAmount; }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="reward", cascade=CascadeType.ALL)
	@OrderBy(value="loyaltyProgramName ASC")
	@MapKey(name="loyaltyProgramName")
	private Map<String, CouponRewardLoyaltyPointEntity> rewardedLoyaltyPointsMap;
	public Map<String, CouponRewardLoyaltyPointEntity> getRewardedLoyaltyPointsMap() { return rewardedLoyaltyPointsMap; }
	public void setRewardedLoyaltyPointsMap(Map<String, CouponRewardLoyaltyPointEntity> rewardedLoyaltyPointsMap) { this.rewardedLoyaltyPointsMap = rewardedLoyaltyPointsMap; }

	@Override public List<CouponRewardLoyaltyPointEntity> getRewardLoyaltyPoints() {
		
		return new ArrayList<CouponRewardLoyaltyPointEntity>((getRewardedLoyaltyPointsMap() == null) ? null : getRewardedLoyaltyPointsMap().values());
	}

	@Override public <T extends RewardLoyaltyPoint> void setRewardLoyaltyPoints(List<T> rewardedLoyaltyPoints) {
	
		for (T rlp : rewardedLoyaltyPoints) {
			if (getRewardedLoyaltyPointsMap().containsKey(rlp.getLoyaltyProgramName())) {
				getRewardedLoyaltyPointsMap().get(rlp.getLoyaltyProgramName()).init(rlp);
			}
		}
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="reward", cascade=CascadeType.ALL)
	@OrderBy(value="tradeItemQuantity DESC")
	@MapKey(name="tradeItemNumber")
	private Map<GlobalTradeIdentificationNumber, CouponRewardTradeItemEntity> rewardedTradeItemsMap;
	public Map<GlobalTradeIdentificationNumber, CouponRewardTradeItemEntity> getRewardedTradeItemsMap() { return rewardedTradeItemsMap; }
	public void setRewardedTradeItemsMap(Map<GlobalTradeIdentificationNumber, CouponRewardTradeItemEntity> rewardedTradeItemsMap) { this.rewardedTradeItemsMap = rewardedTradeItemsMap; }

	@Override public List<CouponRewardTradeItemEntity> getRewardTradeItems() {
		
		return (rewardedTradeItemsMap == null) ? null : new ArrayList<CouponRewardTradeItemEntity>(rewardedTradeItemsMap.values());
	}

	@Override public <T extends RewardTradeItem> void setRewardTradeItems(List<T> rewardedTradeItems) {
		
		for (RewardTradeItem rti : rewardedTradeItems) {
			if (getRewardedTradeItemsMap().containsKey(rti.getTradeItemNumber())) {
				getRewardedTradeItemsMap().get(rti.getTradeItemNumber()).init(rti);
			}
		}
	}

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
    public CouponRewardEntity() {
    }

    @Override public CouponRewardEntity init(RewardInit ri) {
    	
    	ri.dispatchInit(this);
    	
    	return this;
    }

}