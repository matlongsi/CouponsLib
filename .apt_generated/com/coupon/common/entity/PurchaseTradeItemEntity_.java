package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PurchaseTradeItemEntity.class)
public abstract class PurchaseTradeItemEntity_ {

	public static volatile SingularAttribute<PurchaseTradeItemEntity, Long> ptiId;
	public static volatile SingularAttribute<PurchaseTradeItemEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<PurchaseTradeItemEntity, GlobalTradeIdentificationNumberEntity> tradeItemNumber;
	public static volatile SingularAttribute<PurchaseTradeItemEntity, PurchaseRequirementEntity> purchaseRequirement;
	public static volatile SingularAttribute<PurchaseTradeItemEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<PurchaseTradeItemEntity, String> tradeItemGroup;
	public static volatile SingularAttribute<PurchaseTradeItemEntity, Short> tradeItemQuantity;

}

