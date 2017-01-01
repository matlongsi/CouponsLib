package com.coupon.process.entity;

import com.coupon.common.entity.GlobalTradeIdentificationNumberEntity;
import com.coupon.common.entity.RecordHistoryEmbed;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ValidatePurchaseTradeItemEntity.class)
public abstract class ValidatePurchaseTradeItemEntity_ {

	public static volatile SingularAttribute<ValidatePurchaseTradeItemEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<ValidatePurchaseTradeItemEntity, ValidatePurchaseEntity> validatePurchase;
	public static volatile SingularAttribute<ValidatePurchaseTradeItemEntity, GlobalTradeIdentificationNumberEntity> tradeItemNumber;
	public static volatile SingularAttribute<ValidatePurchaseTradeItemEntity, Long> id;
	public static volatile SingularAttribute<ValidatePurchaseTradeItemEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<ValidatePurchaseTradeItemEntity, String> tradeItemGroup;
	public static volatile SingularAttribute<ValidatePurchaseTradeItemEntity, Short> tradeItemQuantity;

}

