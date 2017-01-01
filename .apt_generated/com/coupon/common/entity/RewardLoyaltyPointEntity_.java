package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RewardLoyaltyPointEntity.class)
public abstract class RewardLoyaltyPointEntity_ {

	public static volatile SingularAttribute<RewardLoyaltyPointEntity, RewardEntity> reward;
	public static volatile SingularAttribute<RewardLoyaltyPointEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<RewardLoyaltyPointEntity, Integer> loyaltyPointsQuantity;
	public static volatile SingularAttribute<RewardLoyaltyPointEntity, String> loyaltyProgramName;
	public static volatile SingularAttribute<RewardLoyaltyPointEntity, Long> rlpId;
	public static volatile SingularAttribute<RewardLoyaltyPointEntity, RecordHistoryEmbed> recordHistory;

}

