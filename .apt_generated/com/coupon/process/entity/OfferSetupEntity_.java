package com.coupon.process.entity;

import com.coupon.common.entity.OfferEntity;
import com.coupon.common.entity.RecordHistoryEmbed;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OfferSetupEntity.class)
public abstract class OfferSetupEntity_ {

	public static volatile SingularAttribute<OfferSetupEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<OfferSetupEntity, OfferEntity> coupon;
	public static volatile SingularAttribute<OfferSetupEntity, HeaderEmbed> header;
	public static volatile SingularAttribute<OfferSetupEntity, Long> osId;
	public static volatile SingularAttribute<OfferSetupEntity, Date> acknowledgementDateTime;
	public static volatile SingularAttribute<OfferSetupEntity, RecordHistoryEmbed> recordHistory;

}

