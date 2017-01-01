package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MarketingMaterialEntity.class)
public abstract class MarketingMaterialEntity_ {

	public static volatile SingularAttribute<MarketingMaterialEntity, OfferEntity> offer;
	public static volatile MapAttribute<MarketingMaterialEntity, Long, ArtworkEntity> artworksMap;
	public static volatile SingularAttribute<MarketingMaterialEntity, String> brandName;
	public static volatile SingularAttribute<MarketingMaterialEntity, Integer> optimisticLockVersion;
	public static volatile MapAttribute<MarketingMaterialEntity, Long, ProductCategoryEntity> productCategoriesMap;
	public static volatile MapAttribute<MarketingMaterialEntity, Long, ShortDescriptionEntity> shortDescriptionsMap;
	public static volatile SingularAttribute<MarketingMaterialEntity, Long> mmId;
	public static volatile MapAttribute<MarketingMaterialEntity, Long, LongDescriptionEntity> longDescriptionsMap;
	public static volatile SingularAttribute<MarketingMaterialEntity, RecordHistoryEmbed> recordHistory;
	public static volatile MapAttribute<MarketingMaterialEntity, Long, LegalStatementEntity> legalStatementsMap;

}

