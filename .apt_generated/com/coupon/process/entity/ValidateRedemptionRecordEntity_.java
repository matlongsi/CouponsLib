package com.coupon.process.entity;

import com.coupon.common.entity.GlobalCouponNumberEntity;
import com.coupon.common.entity.GlobalLocationNumberEntity;
import com.coupon.common.entity.GlobalServiceRelationNumberEntity;
import com.coupon.common.entity.RecordHistoryEmbed;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ValidateRedemptionRecordEntity.class)
public abstract class ValidateRedemptionRecordEntity_ {

	public static volatile SingularAttribute<ValidateRedemptionRecordEntity, Boolean> redeemable;
	public static volatile SingularAttribute<ValidateRedemptionRecordEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<ValidateRedemptionRecordEntity, ValidatePurchaseEntity> validatePurchase;
	public static volatile SingularAttribute<ValidateRedemptionRecordEntity, Date> validateDateTime;
	public static volatile SingularAttribute<ValidateRedemptionRecordEntity, GlobalLocationNumberEntity> awarderNumber;
	public static volatile SingularAttribute<ValidateRedemptionRecordEntity, Long> id;
	public static volatile SingularAttribute<ValidateRedemptionRecordEntity, GlobalServiceRelationNumberEntity> accountNumber;
	public static volatile SingularAttribute<ValidateRedemptionRecordEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<ValidateRedemptionRecordEntity, String> alternateAccountId;
	public static volatile SingularAttribute<ValidateRedemptionRecordEntity, GlobalCouponNumberEntity> couponInstance;

}

