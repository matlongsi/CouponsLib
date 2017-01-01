package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(FinancialSettlementDetailEntity.class)
public abstract class FinancialSettlementDetailEntity_ {

	public static volatile SingularAttribute<FinancialSettlementDetailEntity, OfferEntity> offer;
	public static volatile SingularAttribute<FinancialSettlementDetailEntity, Long> fsdId;
	public static volatile SingularAttribute<FinancialSettlementDetailEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<FinancialSettlementDetailEntity, String> offerClearingInstructions;
	public static volatile SingularAttribute<FinancialSettlementDetailEntity, RecordHistoryEmbed> recordHistory;

}

