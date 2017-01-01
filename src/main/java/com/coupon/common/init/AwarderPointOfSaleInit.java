package com.coupon.common.init;

import com.coupon.common.AwarderPointOfSale;
import com.coupon.common.bean.AwarderPointOfSaleBean;
import com.coupon.common.entity.AwarderPointOfSaleEntity;


/**
 * Interface to initialize (visitor pattern) AwarderPointOfSale
 */
public interface AwarderPointOfSaleInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	AwarderPointOfSale init(AwarderPointOfSaleInit aposi);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default AwarderPointOfSale dispatchInit(AwarderPointOfSaleBean aposb) {
		
		return doInit(aposb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default AwarderPointOfSale dispatchInit(AwarderPointOfSaleEntity apose) {
		
		return doInit(apose);
	}

	/**
	 * actual initialization activities
	 */
	AwarderPointOfSale doInit(AwarderPointOfSale apos);

}