package com.coupon.common.entity;

import com.coupon.common.TimePeriod;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(DistributionDetailEntity.class)
public abstract class DistributionDetailEntity_ {

	public static volatile SingularAttribute<DistributionDetailEntity, OfferEntity> offer;
	public static volatile SingularAttribute<DistributionDetailEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<DistributionDetailEntity, Long> ddId;
	public static volatile SingularAttribute<DistributionDetailEntity, Long> totalAcquisitionCount;
	public static volatile MapAttribute<DistributionDetailEntity, TimePeriod, AcquisitionPeriodEntity> acquisitionPeriodsMap;
	public static volatile SingularAttribute<DistributionDetailEntity, Integer> maximumOfferAcquisitions;
	public static volatile SingularAttribute<DistributionDetailEntity, PublicationPeriodEntity> publicationPeriod;
	public static volatile SingularAttribute<DistributionDetailEntity, RecordHistoryEmbed> recordHistory;

}

