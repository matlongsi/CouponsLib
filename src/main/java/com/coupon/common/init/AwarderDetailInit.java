package com.coupon.common.init;

import com.coupon.common.AwarderDetail;
import com.coupon.common.bean.AwarderDetailBean;
import com.coupon.common.entity.AwarderDetailEntity;


/**
 * Interface to initialize (visitor pattern) AcquisitionPeriod
 */
public interface AwarderDetailInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	AwarderDetail init(AwarderDetailInit adi);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default AwarderDetail dispatchInit(AwarderDetailBean adb) {
		
		return doInit(adb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default AwarderDetail dispatchInit(AwarderDetailEntity ade) {
		
		return doInit(ade);
	}

	/**
	 * actual initialization activities
	 */
	AwarderDetail doInit(AwarderDetail ad);

}