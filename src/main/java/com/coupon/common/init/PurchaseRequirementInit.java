package com.coupon.common.init;

import com.coupon.common.PurchaseRequirement;
import com.coupon.common.bean.PurchaseRequirementBean;
import com.coupon.common.entity.PurchaseRequirementEntity;


/**
 * Interface to initialize (visitor pattern) AcquisitionPeriod
 */
public interface PurchaseRequirementInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	PurchaseRequirement init(PurchaseRequirementInit pri);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default PurchaseRequirement dispatchInit(PurchaseRequirementBean prb) {
		
		return doInit(prb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default PurchaseRequirement dispatchInit(PurchaseRequirementEntity pre) {
		
		return doInit(pre);
	}

	/**
	 * actual initialization activities
	 */
	PurchaseRequirement doInit(PurchaseRequirement pr);

}