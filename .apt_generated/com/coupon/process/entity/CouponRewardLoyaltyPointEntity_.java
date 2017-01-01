package com.coupon.process.entity;

import com.coupon.common.entity.RecordHistoryEmbed;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CouponRewardLoyaltyPointEntity.class)
public abstract class CouponRewardLoyaltyPointEntity_ {

	public static volatile SingularAttribute<CouponRewardLoyaltyPointEntity, CouponRewardEntity> reward;
	public static volatile SingularAttribute<CouponRewardLoyaltyPointEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<CouponRewardLoyaltyPointEntity, Integer> rewardedLoyaltyPointsQuantity;
	public static volatile SingularAttribute<CouponRewardLoyaltyPointEntity, Long> crlpId;
	public static volatile SingularAttribute<CouponRewardLoyaltyPointEntity, String> loyaltyProgramName;
	public static volatile SingularAttribute<CouponRewardLoyaltyPointEntity, RecordHistoryEmbed> recordHistory;

}

