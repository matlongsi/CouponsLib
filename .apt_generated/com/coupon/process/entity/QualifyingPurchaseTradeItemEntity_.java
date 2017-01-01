package com.coupon.process.entity;

import com.coupon.common.entity.GlobalTradeIdentificationNumberEntity;
import com.coupon.common.entity.RecordHistoryEmbed;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QualifyingPurchaseTradeItemEntity.class)
public abstract class QualifyingPurchaseTradeItemEntity_ {

	public static volatile SingularAttribute<QualifyingPurchaseTradeItemEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<QualifyingPurchaseTradeItemEntity, GlobalTradeIdentificationNumberEntity> tradeItemNumber;
	public static volatile SingularAttribute<QualifyingPurchaseTradeItemEntity, Long> qptiId;
	public static volatile SingularAttribute<QualifyingPurchaseTradeItemEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<QualifyingPurchaseTradeItemEntity, QualifyingPurchaseEntity> qualifyingPurchase;
	public static volatile SingularAttribute<QualifyingPurchaseTradeItemEntity, String> tradeItemGroup;
	public static volatile SingularAttribute<QualifyingPurchaseTradeItemEntity, Short> tradeItemQuantity;

}

