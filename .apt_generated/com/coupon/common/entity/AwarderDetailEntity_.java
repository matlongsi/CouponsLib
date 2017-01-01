package com.coupon.common.entity;

import com.coupon.common.GlobalLocationNumber;
import com.coupon.common.TimePeriod;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AwarderDetailEntity.class)
public abstract class AwarderDetailEntity_ {

	public static volatile SingularAttribute<AwarderDetailEntity, OfferEntity> offer;
	public static volatile MapAttribute<AwarderDetailEntity, TimePeriod, RedemptionPeriodEntity> redemptionPeriodsMap;
	public static volatile SingularAttribute<AwarderDetailEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<AwarderDetailEntity, Long> adId;
	public static volatile SingularAttribute<AwarderDetailEntity, GlobalLocationNumberEntity> awarderNumber;
	public static volatile SingularAttribute<AwarderDetailEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<AwarderDetailEntity, GlobalLocationNumberEntity> awarderClearingAgentNumber;
	public static volatile MapAttribute<AwarderDetailEntity, GlobalLocationNumber, AwarderPointOfSaleEntity> pointOfSalesMap;

}

