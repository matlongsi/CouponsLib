package com.coupon.process.entity;

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.entity.RecordHistoryEmbed;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(QualifyingPurchaseEntity.class)
public abstract class QualifyingPurchaseEntity_ {

	public static volatile SingularAttribute<QualifyingPurchaseEntity, Integer> optimisticLockVersion;
	public static volatile MapAttribute<QualifyingPurchaseEntity, GlobalTradeIdentificationNumber, QualifyingPurchaseTradeItemEntity> purchaseTradeItemsMap;
	public static volatile SingularAttribute<QualifyingPurchaseEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<QualifyingPurchaseEntity, CouponRedemptionRecordEntity> couponRedemptionRecord;
	public static volatile SingularAttribute<QualifyingPurchaseEntity, Float> purchaseMonetaryAmount;
	public static volatile SingularAttribute<QualifyingPurchaseEntity, Long> qpId;

}

