package com.coupon.common.init;

import com.coupon.common.PurchaseTradeItem;
import com.coupon.common.bean.PurchaseTradeItemBean;
import com.coupon.common.entity.PurchaseTradeItemEntity;
import com.coupon.process.entity.QualifyingPurchaseTradeItemEntity;
import com.coupon.process.entity.ValidatePurchaseTradeItemEntity;
import com.coupon.process.message.QualifyingTradeItemMsg;


/**
 * Interface to initialize (visitor pattern) AcquisitionPeriod
 */
public interface PurchaseTradeItemInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	PurchaseTradeItem init(PurchaseTradeItemInit ptii);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default PurchaseTradeItem dispatchInit(PurchaseTradeItemBean ptib) {
		
		return doInit(ptib);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default PurchaseTradeItem dispatchInit(PurchaseTradeItemEntity ptie) {
		
		return doInit(ptie);
	}

	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default PurchaseTradeItem dispatchInit(ValidatePurchaseTradeItemEntity vptie) {
		
		return doInit(vptie);
	}

	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default PurchaseTradeItem dispatchInit(QualifyingPurchaseTradeItemEntity qptie) {
		
		return doInit(qptie);
	}

	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default PurchaseTradeItem dispatchInit(QualifyingTradeItemMsg qtim) {
		
		return doInit(qtim);
	}

	/**
	 * actual initialization activities
	 */
	PurchaseTradeItem doInit(PurchaseTradeItem pti);

}