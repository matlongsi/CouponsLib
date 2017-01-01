package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ShortDescriptionEntity.class)
public abstract class ShortDescriptionEntity_ {

	public static volatile SingularAttribute<ShortDescriptionEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<ShortDescriptionEntity, MarketingMaterialEntity> marketingMaterial;
	public static volatile SingularAttribute<ShortDescriptionEntity, Long> sdId;
	public static volatile SingularAttribute<ShortDescriptionEntity, String> shortDescription;
	public static volatile SingularAttribute<ShortDescriptionEntity, RecordHistoryEmbed> recordHistory;

}

