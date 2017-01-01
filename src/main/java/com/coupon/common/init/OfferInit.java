package com.coupon.common.init;

import com.coupon.common.Offer;
import com.coupon.common.bean.OfferBean;
import com.coupon.common.entity.OfferEntity;


/**
 * Interface to initialize (visitor pattern) Offer
 */
public interface OfferInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	Offer init(OfferInit oi);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default Offer dispatchInit(OfferBean ob) {
		
		return doInit(ob);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default Offer dispatchInit(OfferEntity oe) {
		
		return doInit(oe);
	}

	/**
	 * actual initialization activities
	 */
	Offer doInit(Offer o);

}