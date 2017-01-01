package com.coupon.common.init;

import com.coupon.common.AcquisitionPeriod;
import com.coupon.common.bean.AcquisitionPeriodBean;
import com.coupon.common.entity.AcquisitionPeriodEntity;


/**
 * Interface to initialize (visitor pattern) AcquisitionPeriod
 */
public interface AcquisitionPeriodInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	AcquisitionPeriod init(AcquisitionPeriodInit api);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default AcquisitionPeriod dispatchInit(AcquisitionPeriodBean apb) {
		
		return doInit(apb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default AcquisitionPeriod dispatchInit(AcquisitionPeriodEntity ape) {

		return doInit(ape);
	}

	/**
	 * actual initialization activities
	 */
	AcquisitionPeriod doInit(AcquisitionPeriod ap);

}