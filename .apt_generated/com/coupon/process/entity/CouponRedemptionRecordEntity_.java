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
@StaticMetamodel(CouponRedemptionRecordEntity.class)
public abstract class CouponRedemptionRecordEntity_ {

	public static volatile SingularAttribute<CouponRedemptionRecordEntity, String> storeInternalId;
	public static volatile SingularAttribute<CouponRedemptionRecordEntity, GlobalServiceRelationNumberEntity> accountNumber;
	public static volatile SingularAttribute<CouponRedemptionRecordEntity, Date> redemptionDateTime;
	public static volatile SingularAttribute<CouponRedemptionRecordEntity, String> alternateAccountId;
	public static volatile SingularAttribute<CouponRedemptionRecordEntity, String> posTerminalId;
	public static volatile SingularAttribute<CouponRedemptionRecordEntity, GlobalLocationNumberEntity> storeGln;
	public static volatile SingularAttribute<CouponRedemptionRecordEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<CouponRedemptionRecordEntity, String> validationOverrideReference;
	public static volatile SingularAttribute<CouponRedemptionRecordEntity, CouponRewardEntity> couponReward;
	public static volatile SingularAttribute<CouponRedemptionRecordEntity, Long> crrId;
	public static volatile SingularAttribute<CouponRedemptionRecordEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<CouponRedemptionRecordEntity, QualifyingPurchaseEntity> qualifyingPurchase;
	public static volatile SingularAttribute<CouponRedemptionRecordEntity, GlobalCouponNumberEntity> couponInstance;

}

