package com.coupon.common.init;

import com.coupon.common.LongDescription;
import com.coupon.common.bean.LongDescriptionBean;
import com.coupon.common.entity.LongDescriptionEntity;


/**
 * Interface to initialize (visitor pattern) AcquisitionPeriod
 */
public interface LongDescriptionInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	LongDescription init(LongDescriptionInit ldi);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default LongDescription dispatchInit(LongDescriptionBean ldb) {
		
		return doInit(ldb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default LongDescription dispatchInit(LongDescriptionEntity lde) {
		
		return doInit(lde);
	}

	/**
	 * actual initialization activities
	 */
	LongDescription doInit(LongDescription ld);

}