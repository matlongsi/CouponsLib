package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(UsageConditionEntity.class)
public abstract class UsageConditionEntity_ {

	public static volatile SingularAttribute<UsageConditionEntity, OfferEntity> offer;
	public static volatile SingularAttribute<UsageConditionEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<UsageConditionEntity, Short> maximumCumulativeUses;
	public static volatile SingularAttribute<UsageConditionEntity, Short> maximumUsesPerTransaction;
	public static volatile SingularAttribute<UsageConditionEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<UsageConditionEntity, Long> ucId;

}

