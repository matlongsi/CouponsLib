package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PublicationPeriodEntity.class)
public abstract class PublicationPeriodEntity_ {

	public static volatile SingularAttribute<PublicationPeriodEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<PublicationPeriodEntity, TimePeriodEmbed> timePeriod;
	public static volatile SingularAttribute<PublicationPeriodEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<PublicationPeriodEntity, DistributionDetailEntity> distributionDetail;
	public static volatile SingularAttribute<PublicationPeriodEntity, Long> ppId;

}

