package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RewardTradeItemEntity.class)
public abstract class RewardTradeItemEntity_ {

	public static volatile SingularAttribute<RewardTradeItemEntity, RewardEntity> reward;
	public static volatile SingularAttribute<RewardTradeItemEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<RewardTradeItemEntity, GlobalTradeIdentificationNumberEntity> tradeItemNumber;
	public static volatile SingularAttribute<RewardTradeItemEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<RewardTradeItemEntity, Long> rtiId;
	public static volatile SingularAttribute<RewardTradeItemEntity, Short> tradeItemQuantity;

}

