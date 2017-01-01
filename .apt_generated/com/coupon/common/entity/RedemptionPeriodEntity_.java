package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RedemptionPeriodEntity.class)
public abstract class RedemptionPeriodEntity_ {

	public static volatile SingularAttribute<RedemptionPeriodEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<RedemptionPeriodEntity, AwarderDetailEntity> awarderDetail;
	public static volatile SingularAttribute<RedemptionPeriodEntity, TimePeriodEmbed> timePeriod;
	public static volatile SingularAttribute<RedemptionPeriodEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<RedemptionPeriodEntity, Long> rpId;

}

