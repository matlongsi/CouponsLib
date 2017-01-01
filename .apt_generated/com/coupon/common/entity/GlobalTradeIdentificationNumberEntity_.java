package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobalTradeIdentificationNumberEntity.class)
public abstract class GlobalTradeIdentificationNumberEntity_ {

	public static volatile SingularAttribute<GlobalTradeIdentificationNumberEntity, Long> companyPrefix;
	public static volatile SingularAttribute<GlobalTradeIdentificationNumberEntity, Integer> itemReference;
	public static volatile SingularAttribute<GlobalTradeIdentificationNumberEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<GlobalTradeIdentificationNumberEntity, Long> gtinId;
	public static volatile SingularAttribute<GlobalTradeIdentificationNumberEntity, Byte> checkDigit;
	public static volatile SingularAttribute<GlobalTradeIdentificationNumberEntity, RecordHistoryEmbed> recordHistory;

}

