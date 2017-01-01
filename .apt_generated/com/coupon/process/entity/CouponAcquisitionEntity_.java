package com.coupon.process.entity;

import com.coupon.common.entity.GlobalCouponNumberEntity;
import com.coupon.common.entity.GlobalServiceRelationNumberEntity;
import com.coupon.common.entity.RecordHistoryEmbed;
import com.coupon.process.type.AcquisitionResponseType;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CouponAcquisitionEntity.class)
public abstract class CouponAcquisitionEntity_ {

	public static volatile SingularAttribute<CouponAcquisitionEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<CouponAcquisitionEntity, Date> acquisitionDateTime;
	public static volatile SingularAttribute<CouponAcquisitionEntity, Long> canId;
	public static volatile SingularAttribute<CouponAcquisitionEntity, GlobalServiceRelationNumberEntity> accountNumber;
	public static volatile SingularAttribute<CouponAcquisitionEntity, Date> acknowledgementDateTime;
	public static volatile SingularAttribute<CouponAcquisitionEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<CouponAcquisitionEntity, String> alternateAccountId;
	public static volatile SingularAttribute<CouponAcquisitionEntity, GlobalCouponNumberEntity> couponInstance;
	public static volatile SingularAttribute<CouponAcquisitionEntity, AcquisitionResponseType> responseCode;

}

