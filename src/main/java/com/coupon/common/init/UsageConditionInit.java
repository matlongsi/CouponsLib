package com.coupon.common.init;

import com.coupon.common.UsageCondition;
import com.coupon.common.bean.UsageConditionBean;
import com.coupon.common.entity.UsageConditionEntity;


/**
 * Interface to initialize (visitor pattern) AcquisitionPeriod
 */
public interface UsageConditionInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	UsageCondition init(UsageConditionInit uci);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default UsageCondition dispatchInit(UsageConditionBean ucb) {
		
		return doInit(ucb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default UsageCondition dispatchInit(UsageConditionEntity uce) {
		
		return doInit(uce);
	}

	/**
	 * actual initialization activities
	 */
	UsageCondition doInit(UsageCondition uc);

}