package com.coupon.common.init;

import com.coupon.common.DistributionDetail;
import com.coupon.common.bean.DistributionDetailBean;
import com.coupon.common.entity.DistributionDetailEntity;


/**
 * Interface to initialize (visitor pattern) DistributionDetail
 */
public interface DistributionDetailInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	DistributionDetail init(DistributionDetailInit ddi);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default DistributionDetail dispatchInit(DistributionDetailBean ddb) {
		
		return doInit(ddb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default DistributionDetail dispatchInit(DistributionDetailEntity dde) {
		
		return doInit(dde);
	}

	/**
	 * actual initialization activities
	 */
	DistributionDetail doInit(DistributionDetail fsd);

}