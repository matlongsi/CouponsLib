package com.coupon.process.entity;

import com.coupon.common.entity.GlobalTradeIdentificationNumberEntity;
import com.coupon.common.entity.RecordHistoryEmbed;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CouponRewardTradeItemEntity.class)
public abstract class CouponRewardTradeItemEntity_ {

	public static volatile SingularAttribute<CouponRewardTradeItemEntity, CouponRewardEntity> reward;
	public static volatile SingularAttribute<CouponRewardTradeItemEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<CouponRewardTradeItemEntity, Long> crtiId;
	public static volatile SingularAttribute<CouponRewardTradeItemEntity, GlobalTradeIdentificationNumberEntity> tradeItemNumber;
	public static volatile SingularAttribute<CouponRewardTradeItemEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<CouponRewardTradeItemEntity, Short> tradeItemQuantity;

}

