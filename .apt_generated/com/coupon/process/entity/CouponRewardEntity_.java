package com.coupon.process.entity;

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.entity.RecordHistoryEmbed;
import com.coupon.common.type.RewardType;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CouponRewardEntity.class)
public abstract class CouponRewardEntity_ {

	public static volatile SingularAttribute<CouponRewardEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<CouponRewardEntity, Long> crId;
	public static volatile SingularAttribute<CouponRewardEntity, RewardType> rewardType;
	public static volatile SingularAttribute<CouponRewardEntity, Float> rewardedMonetaryAmount;
	public static volatile SingularAttribute<CouponRewardEntity, RecordHistoryEmbed> recordHistory;
	public static volatile MapAttribute<CouponRewardEntity, String, CouponRewardLoyaltyPointEntity> rewardedLoyaltyPointsMap;
	public static volatile SingularAttribute<CouponRewardEntity, CouponRedemptionRecordEntity> couponRedemptionRecord;
	public static volatile MapAttribute<CouponRewardEntity, GlobalTradeIdentificationNumber, CouponRewardTradeItemEntity> rewardedTradeItemsMap;

}

