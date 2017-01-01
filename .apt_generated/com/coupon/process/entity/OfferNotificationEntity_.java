package com.coupon.process.entity;

import com.coupon.common.entity.OfferEntity;
import com.coupon.common.entity.RecordHistoryEmbed;
import com.coupon.process.type.NotificationResponseType;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OfferNotificationEntity.class)
public abstract class OfferNotificationEntity_ {

	public static volatile SingularAttribute<OfferNotificationEntity, OfferEntity> offer;
	public static volatile SingularAttribute<OfferNotificationEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<OfferNotificationEntity, Date> responseDateTime;
	public static volatile SingularAttribute<OfferNotificationEntity, HeaderEmbed> header;
	public static volatile SingularAttribute<OfferNotificationEntity, Date> acknowledgementDateTime;
	public static volatile SingularAttribute<OfferNotificationEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<OfferNotificationEntity, Long> onId;
	public static volatile SingularAttribute<OfferNotificationEntity, NotificationResponseType> responseCode;

}

