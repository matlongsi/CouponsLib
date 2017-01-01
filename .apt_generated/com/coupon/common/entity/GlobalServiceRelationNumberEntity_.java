package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(GlobalServiceRelationNumberEntity.class)
public abstract class GlobalServiceRelationNumberEntity_ {

	public static volatile SingularAttribute<GlobalServiceRelationNumberEntity, Long> companyPrefix;
	public static volatile SingularAttribute<GlobalServiceRelationNumberEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<GlobalServiceRelationNumberEntity, Long> serviceReference;
	public static volatile SingularAttribute<GlobalServiceRelationNumberEntity, Byte> checkDigit;
	public static volatile SingularAttribute<GlobalServiceRelationNumberEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<GlobalServiceRelationNumberEntity, Long> gsrnId;

}

