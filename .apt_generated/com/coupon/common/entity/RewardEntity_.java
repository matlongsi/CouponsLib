package com.coupon.common.entity;

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.type.RewardType;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RewardEntity.class)
public abstract class RewardEntity_ {

	public static volatile SingularAttribute<RewardEntity, OfferEntity> offer;
	public static volatile SingularAttribute<RewardEntity, Integer> optimisticLockVersion;
	public static volatile MapAttribute<RewardEntity, String, RewardLoyaltyPointEntity> rewardLoyaltyPointsMap;
	public static volatile SingularAttribute<RewardEntity, Float> rewardMonetaryAmount;
	public static volatile SingularAttribute<RewardEntity, RewardType> rewardType;
	public static volatile MapAttribute<RewardEntity, GlobalTradeIdentificationNumber, RewardTradeItemEntity> rewardTradeItemsMap;
	public static volatile SingularAttribute<RewardEntity, Long> rId;
	public static volatile SingularAttribute<RewardEntity, RecordHistoryEmbed> recordHistory;

}

