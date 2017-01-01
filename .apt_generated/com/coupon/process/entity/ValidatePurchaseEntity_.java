package com.coupon.process.entity;

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.entity.RecordHistoryEmbed;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ValidatePurchaseEntity.class)
public abstract class ValidatePurchaseEntity_ {

	public static volatile SingularAttribute<ValidatePurchaseEntity, Integer> optimisticLockVersion;
	public static volatile MapAttribute<ValidatePurchaseEntity, GlobalTradeIdentificationNumber, ValidatePurchaseTradeItemEntity> purchaseTradeItemsMap;
	public static volatile SingularAttribute<ValidatePurchaseEntity, Long> vpId;
	public static volatile SingularAttribute<ValidatePurchaseEntity, ValidateRedemptionRecordEntity> validateRedemptionRecord;
	public static volatile SingularAttribute<ValidatePurchaseEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<ValidatePurchaseEntity, Float> purchaseMonetaryAmount;

}

