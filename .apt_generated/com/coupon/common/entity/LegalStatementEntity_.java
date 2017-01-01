package com.coupon.common.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(LegalStatementEntity.class)
public abstract class LegalStatementEntity_ {

	public static volatile SingularAttribute<LegalStatementEntity, Long> lsId;
	public static volatile SingularAttribute<LegalStatementEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<LegalStatementEntity, MarketingMaterialEntity> marketingMaterial;
	public static volatile SingularAttribute<LegalStatementEntity, RecordHistoryEmbed> recordHistory;
	public static volatile SingularAttribute<LegalStatementEntity, String> legalStatement;

}

