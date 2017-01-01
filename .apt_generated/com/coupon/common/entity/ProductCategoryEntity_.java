package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ProductCategoryEntity.class)
public abstract class ProductCategoryEntity_ {

	public static volatile SingularAttribute<ProductCategoryEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<ProductCategoryEntity, MarketingMaterialEntity> marketingMaterial;
	public static volatile SingularAttribute<ProductCategoryEntity, Long> pcId;
	public static volatile SingularAttribute<ProductCategoryEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<ProductCategoryEntity, String> categoryName;

}

