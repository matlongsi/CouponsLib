package com.coupon.common.entity;

import com.coupon.common.GlobalLocationNumber;
import com.coupon.common.type.OfferStatusType;
import com.coupon.common.type.OfferType;
import java.util.TimeZone;
import javax.annotation.Generated;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(OfferEntity.class)
public abstract class OfferEntity_ {

	public static volatile SingularAttribute<OfferEntity, RewardEntity> reward;
	public static volatile SingularAttribute<OfferEntity, GlobalLocationNumberEntity> issuerClearingAgentNumber;
	public static volatile SingularAttribute<OfferEntity, MarketingMaterialEntity> marketingMaterial;
	public static volatile SingularAttribute<OfferEntity, TimeZone> timeZone;
	public static volatile SingularAttribute<OfferEntity, GlobalLocationNumberEntity> distributorNumber;
	public static volatile MapAttribute<OfferEntity, GlobalLocationNumber, AwarderDetailEntity> awarderDetailsMap;
	public static volatile SingularAttribute<OfferEntity, FinancialSettlementDetailEntity> financialSettlementDetail;
	public static volatile SingularAttribute<OfferEntity, DistributionDetailEntity> distributionDetail;
	public static volatile SingularAttribute<OfferEntity, GlobalCouponNumberEntity> offerNumber;
	public static volatile SingularAttribute<OfferEntity, OfferStatusType> offerStatus;
	public static volatile SingularAttribute<OfferEntity, OfferType> offerType;
	public static volatile SingularAttribute<OfferEntity, Integer> optimisticLockVersion;
	public static volatile SingularAttribute<OfferEntity, PurchaseRequirementEntity> purchaseRequirement;
	public static volatile SingularAttribute<OfferEntity, TimePeriodEmbed> timePeriod;
	public static volatile SingularAttribute<OfferEntity, Long> offerId;
	public static volatile SingularAttribute<OfferEntity, GlobalLocationNumberEntity> issuerNumber;
	public static volatile SingularAttribute<OfferEntity, UsageConditionEntity> usageCondition;
	public static volatile SingularAttribute<OfferEntity, RecordHistoryEmbed> recordHistory;

}

