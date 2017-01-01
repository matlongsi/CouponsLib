package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobalCouponNumberEntity.class)
public abstract class GlobalCouponNumberEntity_ {

	public static volatile SingularAttribute<GlobalCouponNumberEntity, Long> companyPrefix;
	public static volatile SingularAttribute<GlobalCouponNumberEntity, Integer> couponReference;
	public static volatile SingularAttribute<GlobalCouponNumberEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<GlobalCouponNumberEntity, Long> serialComponent;
	public static volatile SingularAttribute<GlobalCouponNumberEntity, Long> gcnId;
	public static volatile SingularAttribute<GlobalCouponNumberEntity, Byte> checkDigit;
	public static volatile SingularAttribute<GlobalCouponNumberEntity, RecordHistoryEmbed> recordHistory;

}

