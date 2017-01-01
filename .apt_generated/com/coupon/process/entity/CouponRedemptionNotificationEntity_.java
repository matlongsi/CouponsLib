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
@StaticMetamodel(CouponRedemptionNotificationEntity.class)
public abstract class CouponRedemptionNotificationEntity_ {

	public static volatile SingularAttribute<CouponRedemptionNotificationEntity, GlobalLocationNumberEntity> storeGln;
	public static volatile SingularAttribute<CouponRedemptionNotificationEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<CouponRedemptionNotificationEntity, HeaderEmbed> flowHeader;
	public static volatile SingularAttribute<CouponRedemptionNotificationEntity, String> storeInternalId;
	public static volatile SingularAttribute<CouponRedemptionNotificationEntity, Long> customerAccountAlternateId;
	public static volatile SingularAttribute<CouponRedemptionNotificationEntity, Long> canId;
	public static volatile SingularAttribute<CouponRedemptionNotificationEntity, GlobalServiceRelationNumberEntity> customerAccountNumber;
	public static volatile SingularAttribute<CouponRedemptionNotificationEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<CouponRedemptionNotificationEntity, Date> redemptionDateTime;
	public static volatile SingularAttribute<CouponRedemptionNotificationEntity, GlobalCouponNumberEntity> couponInstance;
	public static volatile SingularAttribute<CouponRedemptionNotificationEntity, String> posTerminalId;

}

