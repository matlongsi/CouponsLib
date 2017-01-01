package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AcquisitionPeriodEntity.class)
public abstract class AcquisitionPeriodEntity_ {

	public static volatile SingularAttribute<AcquisitionPeriodEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<AcquisitionPeriodEntity, Long> apId;
	public static volatile SingularAttribute<AcquisitionPeriodEntity, TimePeriodEmbed> timePeriod;
	public static volatile SingularAttribute<AcquisitionPeriodEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<AcquisitionPeriodEntity, DistributionDetailEntity> distributionDetail;

}

