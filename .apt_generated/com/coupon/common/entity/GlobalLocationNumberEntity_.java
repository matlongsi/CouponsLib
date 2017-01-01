package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobalLocationNumberEntity.class)
public abstract class GlobalLocationNumberEntity_ {

	public static volatile SingularAttribute<GlobalLocationNumberEntity, Long> companyPrefix;
	public static volatile SingularAttribute<GlobalLocationNumberEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<GlobalLocationNumberEntity, Long> glnId;
	public static volatile SingularAttribute<GlobalLocationNumberEntity, Integer> locationReference;
	public static volatile SingularAttribute<GlobalLocationNumberEntity, Byte> checkDigit;
	public static volatile SingularAttribute<GlobalLocationNumberEntity, RecordHistoryEmbed> recordHistory;

}

