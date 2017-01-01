package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AwarderPointOfSaleEntity.class)
public abstract class AwarderPointOfSaleEntity_ {

	public static volatile SingularAttribute<AwarderPointOfSaleEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<AwarderPointOfSaleEntity, GlobalLocationNumberEntity> storeNumber;
	public static volatile SingularAttribute<AwarderPointOfSaleEntity, Long> oaposId;
	public static volatile SingularAttribute<AwarderPointOfSaleEntity, AwarderDetailEntity> awarderDetail;
	public static volatile SingularAttribute<AwarderPointOfSaleEntity, String> storeInternalId;
	public static volatile SingularAttribute<AwarderPointOfSaleEntity, RecordHistoryEmbed> recordHistory;

}

