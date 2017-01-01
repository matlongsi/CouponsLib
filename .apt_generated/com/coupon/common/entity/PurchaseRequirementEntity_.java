package com.coupon.common.entity;

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.type.PurchaseRequirementType;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PurchaseRequirementEntity.class)
public abstract class PurchaseRequirementEntity_ {

	public static volatile SingularAttribute<PurchaseRequirementEntity, OfferEntity> offer;
	public static volatile SingularAttribute<PurchaseRequirementEntity, Integer> optimisticLockVersion;
	public static volatile MapAttribute<PurchaseRequirementEntity, GlobalTradeIdentificationNumber, PurchaseTradeItemEntity> purchaseTradeItemsMap;
	public static volatile SingularAttribute<PurchaseRequirementEntity, Long> prId;
	public static volatile SingularAttribute<PurchaseRequirementEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<PurchaseRequirementEntity, Float> purchaseMonetaryAmount;
	public static volatile SingularAttribute<PurchaseRequirementEntity, PurchaseRequirementType> purchaseRequirementType;

}

