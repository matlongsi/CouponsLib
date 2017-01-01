package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LongDescriptionEntity.class)
public abstract class LongDescriptionEntity_ {

	public static volatile SingularAttribute<LongDescriptionEntity, String> longDescription;
	public static volatile SingularAttribute<LongDescriptionEntity, Long> ldId;
	public static volatile SingularAttribute<LongDescriptionEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<LongDescriptionEntity, MarketingMaterialEntity> marketingMaterial;
	public static volatile SingularAttribute<LongDescriptionEntity, RecordHistoryEmbed> recordHistory;

}

