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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;
import javax.persistence.MapKeyClass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;
import javax.persistence.Version;

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.Reward;
import com.coupon.common.RewardLoyaltyPoint;
import com.coupon.common.RewardTradeItem;
import com.coupon.common.bean.RewardBean;
import com.coupon.common.init.RewardInit;
import com.coupon.common.type.RewardType;

/**
 * Entity bean implementation for OfferReward
 */
@Entity
@EntityListeners({RecordListener.class})
@Access(AccessType.FIELD)
@Table(name="offer_reward_tbl")
public class RewardEntity extends Reward implements Record {

	private static final long serialVersionUID = 1053281740763501410L;

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="or_tbl_id")
	private Long rId;
    @Override public Long getId() { return rId; }
	@Override public void setId(Long rId) { this.rId = rId; }

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="cpn_tbl_fk", updatable=false, nullable=false)
	private OfferEntity offer;
    public OfferEntity getOffer() { return offer; }
	public void setOffer(OfferEntity offer) { this.offer = offer; }

	@Column(name="reward_type_code")
    @Enumerated(EnumType.STRING)
	private RewardType rewardType;
	@Override public RewardType getRewardType() { return rewardType; }
	@Override public void setRewardType(RewardType rewardType) { this.rewardType = rewardType; }

	@Column(name="reward_monetary_amount", columnDefinition="DECIMAL(10, 2)")
	private Float rewardMonetaryAmount;
    @Override public Float getRewardMonetaryAmount() { return rewardMonetaryAmount; }
	@Override public void setRewardMonetaryAmount(Float rewardMonetaryAmount) { this.rewardMonetaryAmount = rewardMonetaryAmount; }

    @OneToMany(fetch=FetchType.LAZY, mappedBy="reward", cascade=CascadeType.ALL)
	@OrderBy(value="loyaltyPointsQuantity DESC, loyaltyProgramName ASC")
	@MapKey(name="loyaltyProgramName")
	private Map<String, RewardLoyaltyPointEntity> rewardLoyaltyPointsMap;
	public Map<String, RewardLoyaltyPointEntity> getRewardLoyaltyPointsMap() { return rewardLoyaltyPointsMap; }
	public void setRewardLoyaltyPointsMap(Map<String, RewardLoyaltyPointEntity> rewardLoyaltyPointsMap) { this.rewardLoyaltyPointsMap = rewardLoyaltyPointsMap; }

	@Override public List<RewardLoyaltyPointEntity> getRewardLoyaltyPoints() {
		
		return (getRewardLoyaltyPointsMap() == null) ?
				null : new ArrayList<RewardLoyaltyPointEntity>(getRewardLoyaltyPointsMap().values());
	}

	@Override public <T extends RewardLoyaltyPoint> void setRewardLoyaltyPoints(List<T> rewardLoyaltyPoints) {
	
		for (T rlp : rewardLoyaltyPoints) {
			if (getRewardLoyaltyPointsMap().containsKey(rlp.getLoyaltyProgramName())) {
				getRewardLoyaltyPointsMap().get(rlp.getLoyaltyProgramName()).init(rlp);
			}
		}
	}

	@OneToMany(fetch=FetchType.LAZY, mappedBy="reward", cascade=CascadeType.ALL)
	@OrderBy(value="tradeItemQuantity DESC, tradeItemNumber ASC")
	@MapKey(name="tradeItemNumber")
	@MapKeyClass(GlobalTradeIdentificationNumber.class)
	private Map<GlobalTradeIdentificationNumber, RewardTradeItemEntity> rewardTradeItemsMap;
	public Map<GlobalTradeIdentificationNumber, RewardTradeItemEntity> getRewardTradeItemsMap() { return rewardTradeItemsMap; }
	public void setRewardTradeItemsMap(Map<GlobalTradeIdentificationNumber, RewardTradeItemEntity> rewardTradeItemsMap) { this.rewardTradeItemsMap = rewardTradeItemsMap; }
	
	@Override public List<RewardTradeItemEntity> getRewardTradeItems() {
		
		return (getRewardTradeItemsMap() == null) ?
				null : new ArrayList<RewardTradeItemEntity>(getRewardTradeItemsMap().values());
	}

	@Override public <T extends RewardTradeItem> void setRewardTradeItems(List<T> rewardTradeItems) {
		
		for (T rti : rewardTradeItems) {
			if (getRewardTradeItemsMap().containsKey(rti.getTradeItemNumber())) {
				getRewardTradeItemsMap().get(rti.getTradeItemNumber()).init(rti);
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
    public RewardEntity() {
    }

    @Override public RewardEntity init(RewardInit ri) {
    	
	    	ri.dispatchInit(this);
	    	
	    	return this;
    }

    @Override public RewardBean dispatchInit(RewardBean rb) {
    	
		super.dispatchInit(rb);

	    	rb.setId(getId());
	    	rb.setParentId(getOffer().getId());
		
	    	return rb;
	}

}