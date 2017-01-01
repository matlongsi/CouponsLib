package com.coupon.common.init;

import com.coupon.common.MarketingMaterial;
import com.coupon.common.bean.MarketingMaterialBean;
import com.coupon.common.entity.MarketingMaterialEntity;


/**
 * Interface to initialize (visitor pattern) AcquisitionPeriod
 */
public interface MarketingMaterialInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	MarketingMaterial init(MarketingMaterialInit mmi);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default MarketingMaterial dispatchInit(MarketingMaterialBean mmb) {
		
		return doInit(mmb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default MarketingMaterial dispatchInit(MarketingMaterialEntity mme) {
		
		return doInit(mme);
	}

	/**
	 * actual initialization activities
	 */
	MarketingMaterial doInit(MarketingMaterial mm);

}