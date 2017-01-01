package com.coupon.setup;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateTest {

	public static void main(String[] args) {

		Configuration config = new Configuration().configure();
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	  			.applySettings(config.getProperties())
	  			.build();
		SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
      	Session session = sessionFactory.openSession();

      	Transaction txn = null;
        try{
			txn = session.beginTransaction();

/*			GlobalLocationNumber gln1 = new GlobalLocationNumberEntity();
			gln1.setCompanyPrefix(1111111);
			gln1.setLocationReference(0);
			gln1.setCheckDigit((byte)7);
			session.save(gln1);
			GlobalLocationNumberEntity glnE1 = new GlobalLocationNumberEntity().init(gln1);
			session.save(gln);
			GlobalLocationNumber gln2 = new GlobalLocationNumber();
			gln2.setCompanyPrefix(1111112);
			gln2.setLocationReference(0);
			gln2.setCheckDigit((byte)8);
			GlobalLocationNumberEntity glnE2 = new GlobalLocationNumberEntity().init(gln2);
			session.save(glnE2);
			GlobalTradeIdentificationNumber gtin1 = new GlobalTradeIdentificationNumber();
			gtin1.setCompanyPrefix(1111111);
			gtin1.setItemReference(12);
			gtin1.setCheckDigit((byte)0);
			GlobalTradeIdentificationNumberEntity gtinE1 = new GlobalTradeIdentificationNumberEntity();
			session.save(gtinE1);

			CouponEntity cpn = new CouponEntity();
			cpn.setOfferIssuerNumber(glnE1);
			cpn.setOfferDistributorNumber(glnE2);
			cpn.setOfferTypeCode(OfferType.MANUFACTURER_COUPON);
			cpn.setStatus(OfferStatusType.ACTIVE);
			cpn.setTimeZone(TimeZone.getTimeZone("US/Central"));
			GlobalCouponNumber gcn1 = new GlobalCouponNumber();
			gcn1.setCompanyPrefix(1111111);
			gcn1.setCouponReference(333);
			gcn1.setCheckDigit((byte)8);
			gcn1.setSerialComponent(000000000001);
			GlobalCouponNumberEntity gcnE1 = new GlobalCouponNumberEntity().init(gcn1);
			cpn.setCouponOfferNumber(gcnE1);
			TimePeriodEntity tp1 = new TimePeriodEntity();
			tp1.setStartDateTime(new Date(Timestamp.valueOf("2015-07-22 00:00:00").getTime()));
			tp1.setEndDateTime(new Date(Timestamp.valueOf("2015-12-22 23:59:59").getTime()));
			cpn.setTimePeriod(tp1);

			OfferDistributionDetailEntity odd = new OfferDistributionDetailEntity();
			odd.setMaximumOfferAcquisitions(10);			
			OfferPublicationPeriodEntity opp = new OfferPublicationPeriodEntity();
			TimePeriodEntity tp2 = new TimePeriodEntity();
			tp2.setStartDateTime(new Date(Timestamp.valueOf("2015-07-22 00:00:00").getTime()));
			tp2.setEndDateTime(new Date(Timestamp.valueOf("2015-12-22 23:59:59").getTime()));
			opp.setTimePeriod(tp2);
			odd.setPublicationPeriod(opp);
			OfferAcquisitionPeriodEntity oap = new OfferAcquisitionPeriodEntity();
			TimePeriodEntity tp3 = new TimePeriodEntity();
			tp3.setStartDateTime(new Date(Timestamp.valueOf("2015-07-22 00:00:00").getTime()));
			tp3.setEndDateTime(new Date(Timestamp.valueOf("2015-12-22 23:59:59").getTime()));
			oap.setTimePeriod(tp3);
			odd.addAcquisitionPeriod(oap);
			cpn.setDistributionDetail(odd);

			OfferMarketingMaterialEntity omm = new OfferMarketingMaterialEntity();
			omm.setBrandName("brand name");
			OfferShortDescriptionEntity osd1 = new OfferShortDescriptionEntity();
			osd1.setShortDescription("short desc 1");
			OfferShortDescriptionEntity osd2 = new OfferShortDescriptionEntity();
			osd2.setShortDescription("short desc 2");
			omm.addShortDescription(osd1);
			omm.addShortDescription(osd2);
			OfferLongDescriptionEntity old1 = new OfferLongDescriptionEntity();
			old1.setLongDescription("long desc 1");
			OfferLongDescriptionEntity old2 = new OfferLongDescriptionEntity();
			old2.setLongDescription("long desc 2");
			omm.addLongDescription(old1);
			omm.addLongDescription(old2);
			OfferLegalStatementEntity ols1 = new OfferLegalStatementEntity();
			ols1.setLegalStatement("legal statement 1");
			OfferLegalStatementEntity ols2 = new OfferLegalStatementEntity();
			ols2.setLegalStatement("legal statement 2");
			omm.addLegalStatement(ols1);
			omm.addLegalStatement(ols2);
			OfferProductCategoryEntity opc1 = new OfferProductCategoryEntity();
			opc1.setProductCategory("product category 1");
			OfferProductCategoryEntity opc2 = new OfferProductCategoryEntity();
			opc2.setProductCategory("product category 2");
			omm.addProductCategory(opc1);
			omm.addProductCategory(opc2);
			OfferArtworkEntity oa1 = new OfferArtworkEntity();
			oa1.setFileName("artwork file name 1");
			oa1.setFileFormatName("JPG");
			oa1.setFileUri("www.uri.com ... 1");
			oa1.setArtworkType(OfferArtworkType.PRODUCT_IMAGE);
			FileContentDescriptionEntity fcd1 = new FileContentDescriptionEntity();
			fcd1.setFileContentDescription("file content description 1");
			oa1.addFileContentDescription(fcd1);
			omm.addArtwork(oa1);
			OfferArtworkEntity oa2 = new OfferArtworkEntity();
			oa2.setFileName("artwork file name 2");
			oa2.setFileFormatName("GIFF");
			oa2.setFileUri("www.uri.com ... 2");
			oa2.setArtworkType(OfferArtworkType.PRODUCT_IMAGE);
			FileContentDescriptionEntity fcd2 = new FileContentDescriptionEntity();
			fcd2.setFileContentDescription("file content description 2");
			oa2.addFileContentDescription(fcd2);
			omm.addArtwork(oa2);
			cpn.setMarketingMaterial(omm);
			
			OfferUsageConditionEntity ouc = new OfferUsageConditionEntity();
			ouc.setMaximumCumulativeUses((short)10);
			ouc.setMaximumUsesPerTransaction((short)2);
			cpn.setUsageCondition(ouc);

			OfferFinancialSettlementDetailEntity ofsd = new OfferFinancialSettlementDetailEntity();
			ofsd.setOfferClearingInstructions("offer clrng instn ...");
			cpn.setFinancialSettlementDetail(ofsd);

			GlobalLocationNumber gln3 = new GlobalLocationNumber();
			gln3.setCompanyPrefix(1111113);
			gln3.setLocationReference(0);
			gln3.setCheckDigit((byte)9);
			GlobalLocationNumberEntity glnE3 = new GlobalLocationNumberEntity().init(gln3);
			session.save(glnE3);
			OfferAwarderDetailEntity oad = new OfferAwarderDetailEntity();
			oad.setOfferAwarderNumber(glnE3);
			TimePeriodEntity tp4 = new TimePeriodEntity();
			tp4.setStartDateTime(new Date(Timestamp.valueOf("2015-07-22 00:00:00").getTime()));
			tp4.setEndDateTime(new Date(Timestamp.valueOf("2015-12-22 23:59:59").getTime()));
			OfferRedemptionPeriodEntity orp1 = new OfferRedemptionPeriodEntity();
			orp1.setTimePeriod(tp4);
			TimePeriodEntity tp5 = new TimePeriodEntity();
			tp5.setStartDateTime(new Date(Timestamp.valueOf("2015-07-22 00:00:00").getTime()));
			tp5.setEndDateTime(new Date(Timestamp.valueOf("2015-12-22 23:59:59").getTime()));
			OfferRedemptionPeriodEntity orp2 = new OfferRedemptionPeriodEntity();
			orp2.setTimePeriod(tp5);
			oad.addRedemptionPeriod(orp1);
			oad.addRedemptionPeriod(orp2);
			GlobalLocationNumber gln4 = new GlobalLocationNumber();
			gln4.setCompanyPrefix(1111121);
			gln4.setLocationReference(1);
			gln4.setCheckDigit((byte)9);
			GlobalLocationNumberEntity glnE4 = new GlobalLocationNumberEntity().init(gln4);
			session.save(glnE4);
			OfferAwarderPointOfSaleEntity oapos1 = new OfferAwarderPointOfSaleEntity();
			oapos1.setStoreGln(glnE4);
			oapos1.setStoreInternalId("store internal id 1");
			GlobalLocationNumber gln5 = new GlobalLocationNumber();
			gln5.setCompanyPrefix(2111111);
			gln5.setLocationReference(5);
			gln5.setCheckDigit((byte)4);
			GlobalLocationNumberEntity glnE5 = new GlobalLocationNumberEntity().init(gln5);
			session.save(glnE5);
			OfferAwarderPointOfSaleEntity oapos2 = new OfferAwarderPointOfSaleEntity();
			oapos2.setStoreGln(glnE5);
			oapos2.setStoreInternalId("store internal id 2");
			oad.addPointOfSale(oapos1);
			oad.addPointOfSale(oapos2);
			cpn.addOfferAwarderDetail(oad);
			
			OfferRewardEntity or = new OfferRewardEntity();
//			or.setRewardType(RewardType.MONETARY_REWARD);
			or.setRewardType(RewardType.LOYALTY_POINTS_REWARD);
//			or.setRewardType(RewardType.TRADE_ITEM_REWARD);
			or.setRewardMonetaryAmount((float)10.92);
			OfferRewardLoyaltyPointEntity orlp1 = new OfferRewardLoyaltyPointEntity();
			orlp1.setLoyaltyProgramName("loyalty program name 1");
			orlp1.setRewardedLoyaltyPointsQuantity(10000);
			OfferRewardLoyaltyPointEntity orlp2 = new OfferRewardLoyaltyPointEntity();
			orlp2.setLoyaltyProgramName("loyalty program name 2");
			orlp2.setRewardedLoyaltyPointsQuantity(20000);
			or.addRewardLoyaltyPoints(orlp1);
			or.addRewardLoyaltyPoints(orlp2);
			GlobalTradeIdentificationNumber gtin2 = new GlobalTradeIdentificationNumber();
			gtin2.setCompanyPrefix(2111111);
			gtin2.setItemReference(12);
			gtin2.setCheckDigit((byte)2);
			GlobalTradeIdentificationNumberEntity gtinE2 = new GlobalTradeIdentificationNumberEntity().init(gtin2);
			session.save(gtinE2);
			GlobalTradeIdentificationNumber gtin3 = new GlobalTradeIdentificationNumber();
			gtin3.setCompanyPrefix(3111111);
			gtin3.setItemReference(12);
			gtin3.setCheckDigit((byte)3);
			GlobalTradeIdentificationNumberEntity gtinE3 = new GlobalTradeIdentificationNumberEntity().init(gtin3);
			session.save(gtinE3);
			OfferRewardTradeItemEntity orti1 = new OfferRewardTradeItemEntity();
			orti1.setTradeItemQuantity(10);
			orti1.setTradeItemGtin(gtinE2);
			OfferRewardTradeItemEntity orti2 = new OfferRewardTradeItemEntity();
			orti2.setTradeItemQuantity(10);
			orti2.setTradeItemGtin(gtinE3);
			or.addRewardTradeItem(orti1);
			or.addRewardTradeItem(orti2);
			cpn.setOfferReward(or);
			
			PurchaseRequirementEntity pr = new PurchaseRequirementEntity();
//			pr.setPurchaseRequirementType(PurchaseRequirementType.SPECIFIED_PURCHASE_AMOUNT);
			pr.setPurchaseRequirementType(PurchaseRequirementType.ONE_ITEM_PER_GROUP);
			pr.setPurchaseRequirementMonetaryAmount((float)50.05);
			PurchaseRequirementTradeItemEntity prti1 = new PurchaseRequirementTradeItemEntity();
			prti1.setTradeItemGroup("trade item group 1");
			prti1.setTradeItemQuantity((short)10);
			prti1.setTradeItemNumber(gtinE2);
			PurchaseRequirementTradeItemEntity prti2 = new PurchaseRequirementTradeItemEntity();
			prti2.setTradeItemGroup("trade item group 2");
			prti2.setTradeItemQuantity((short)10);
			prti2.setTradeItemNumber(gtinE3);
			pr.addPurchaseRequirementTradeItem(prti1);
			pr.addPurchaseRequirementTradeItem(prti2);
			cpn.setPurchaseRequirement(pr);
			session.save(cpn);
			
			GlobalServiceRelationNumberZ gsrn = new GlobalServiceRelationNumberZ();
			gsrn.setCompanyPrefix(1111111);
			gsrn.setServiceReference(44);
			gsrn.setCheckDigit((byte)6);
			GlobalServiceRelationNumberEntity gsrnE = new GlobalServiceRelationNumberEntity().init(gsrn);
			session.save(gsrnE);
*/
			txn.commit();
        }
        catch (HibernateException e) {
           if (txn != null) txn.rollback();
           e.printStackTrace(); 
        }
        finally {
           session.close(); 
        }
        
		System.out.println("HibernateTest completed.");
	}

}
