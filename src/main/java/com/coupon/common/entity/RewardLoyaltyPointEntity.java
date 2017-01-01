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

import com.coupon.common.RewardLoyaltyPoint;
import com.coupon.common.bean.RewardLoyaltyPointBean;
import com.coupon.common.init.RewardLoyaltyPointInit;


/**
 * Entity bean implementation for OfferRewardLoyaltyPoint
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_reward_loyalty_points_tbl")
public class RewardLoyaltyPointEntity extends RewardLoyaltyPoint implements Record {

	private static final long serialVersionUID = -4223929509494743099L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="orlp_tbl_id")
	private Long rlpId;
	@Override public Long getId() { return rlpId; }
	@Override public void setId(Long rlpId) { this.rlpId = rlpId; }

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="or_tbl_fk", updatable=false, nullable=false)
	private RewardEntity reward;
	public RewardEntity getReward() { return reward; }
	public void setReward(RewardEntity reward) { this.reward = reward; }

    @Column(name="loyalty_program_name", columnDefinition="VARCHAR", length=MAX_LOYALTY_PROGRAM_NAME_LENGTH, updatable=false)
	private String loyaltyProgramName;
    @Override public String getLoyaltyProgramName() { return loyaltyProgramName; }
	@Override public void setLoyaltyProgramName(String loyaltyProgramName) { this.loyaltyProgramName = loyaltyProgramName; }

	@Column(name="loyalty_points_quantity")
	private Integer loyaltyPointsQuantity;
	@Override public Integer getLoyaltyPointsQuantity() { return loyaltyPointsQuantity; }
	@Override public void setLoyaltyPointsQuantity(Integer loyaltyPointsQuantity) { this.loyaltyPointsQuantity = loyaltyPointsQuantity; }

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
    public RewardLoyaltyPointEntity() {
    }

    @Override public RewardLoyaltyPointEntity init(RewardLoyaltyPointInit rlpi) {
    	
	    	rlpi.dispatchInit(this);
	    	
	    	return this;
    }

	@Override public RewardLoyaltyPointBean dispatchInit(RewardLoyaltyPointBean rlpb) {

		super.dispatchInit(rlpb);

	    	rlpb.setId(getId());
	    	rlpb.setParentId(getReward().getId());
	    	
	    	return rlpb;
    }

}