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

import com.coupon.common.RewardLoyaltyPoint;
import com.coupon.common.entity.Record;
import com.coupon.common.entity.RecordListener;
import com.coupon.common.entity.RecordHistoryEmbed;
import com.coupon.common.init.RewardLoyaltyPointInit;


/**
 * Entity bean implementation for CouponRewardLoyaltyPoint
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="coupon_reward_loyalty_points_tbl")
public class CouponRewardLoyaltyPointEntity extends RewardLoyaltyPoint implements Record {

	private static final long serialVersionUID = -4223929509494743099L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="crlp_tbl_id")
	private Long crlpId;
	@Override public Long getId() { return crlpId; }
	@Override public void setId(Long crlpId) { this.crlpId = crlpId; }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cr_tbl_fk", updatable=false, nullable=false)
	private CouponRewardEntity reward;
	public CouponRewardEntity getReward() { return reward; }
	public void setReward(CouponRewardEntity reward) { this.reward = reward; }

    @Column(name="loyalty_program_name", columnDefinition="VARCHAR", length=RewardLoyaltyPoint.MAX_LOYALTY_PROGRAM_NAME_LENGTH)
	private String loyaltyProgramName;
    @Override public String getLoyaltyProgramName() { return loyaltyProgramName; }
    @Override public void setLoyaltyProgramName(String loyaltyProgramName) { this.loyaltyProgramName = loyaltyProgramName; }

	@Column(name="rewarded_loyalty_points_quantity", columnDefinition="INT UNSIGNED", nullable=false)
	private Integer rewardedLoyaltyPointsQuantity;
	@Override public Integer getLoyaltyPointsQuantity() { return rewardedLoyaltyPointsQuantity; }
	@Override public void setLoyaltyPointsQuantity(Integer rewardedLoyaltyPointsQuantity) { this.rewardedLoyaltyPointsQuantity = rewardedLoyaltyPointsQuantity; }

    @Version
    @Column(name="optimistic_lock_version", columnDefinition="INT UNSIGNED DEFAULT 0", nullable=false)
    private int optimisticLockVersion;
    @Override public Integer getOptimisticLockVersion() { return optimisticLockVersion; }
    @Override public void setOptimisticLockVersion(Integer optimisticLockVersion) { this.optimisticLockVersion = optimisticLockVersion; }

	@Embedded
    private RecordHistoryEmbed recordHistory;
	@Override public RecordHistoryEmbed getRecordHistory() { return recordHistory; }
	@Override public void setRecordHistory(RecordHistoryEmbed recordHistory) { this.recordHistory = recordHistory; }

    /**
     * Default constructor. 
     */
    public CouponRewardLoyaltyPointEntity() {
    }

    @Override public CouponRewardLoyaltyPointEntity init(RewardLoyaltyPointInit rlpi) {
    	
    	rlpi.dispatchInit(this);
    	
    	return this;
    }

}