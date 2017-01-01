package com.coupon.common.init;

import com.coupon.common.RedemptionPeriod;
import com.coupon.common.bean.RedemptionPeriodBean;
import com.coupon.common.entity.RedemptionPeriodEntity;


/**
 * Interface to initialize (visitor pattern) RedemptionPeriod
 */
public interface RedemptionPeriodInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	RedemptionPeriod init(RedemptionPeriodInit rpi);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default RedemptionPeriod dispatchInit(RedemptionPeriodBean rpb) {
		
		return doInit(rpb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default RedemptionPeriod dispatchInit(RedemptionPeriodEntity rpe) {

		return doInit(rpe);
	}

	/**
	 * actual initialization activities
	 */
	RedemptionPeriod doInit(RedemptionPeriod rp);

}