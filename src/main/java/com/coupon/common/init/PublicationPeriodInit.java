package com.coupon.common.init;

import com.coupon.common.PublicationPeriod;
import com.coupon.common.bean.PublicationPeriodBean;
import com.coupon.common.entity.PublicationPeriodEntity;


/**
 * Interface to initialize (visitor pattern) PublicationPeriod
 */
public interface PublicationPeriodInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
    PublicationPeriod init(PublicationPeriodInit ppi);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default PublicationPeriod dispatchInit(PublicationPeriodBean ppb) {
		
		return doInit(ppb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default PublicationPeriod dispatchInit(PublicationPeriodEntity ppe) {
		
		return doInit(ppe);
	}

	/**
	 * actual initialization activities
	 */
	PublicationPeriod doInit(PublicationPeriod pp);

}