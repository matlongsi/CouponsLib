package com.coupon.common.init;

import com.coupon.common.ShortDescription;
import com.coupon.common.bean.ShortDescriptionBean;
import com.coupon.common.entity.ShortDescriptionEntity;


/**
 * Interface to initialize (visitor pattern) AcquisitionPeriod
 */
public interface ShortDescriptionInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	ShortDescription init(ShortDescriptionInit sdi);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default ShortDescription dispatchInit(ShortDescriptionBean sdb) {
		
		return doInit(sdb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default ShortDescription dispatchInit(ShortDescriptionEntity sde) {
		
		return doInit(sde);
	}

	/**
	 * actual initialization activities
	 */
	ShortDescription doInit(ShortDescription sd);

}