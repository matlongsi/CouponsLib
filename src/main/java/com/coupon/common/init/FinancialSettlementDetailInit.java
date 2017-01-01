package com.coupon.common.init;

import com.coupon.common.FinancialSettlementDetail;
import com.coupon.common.bean.FinancialSettlementDetailBean;
import com.coupon.common.entity.FinancialSettlementDetailEntity;


/**
 * Interface to initialize (visitor pattern) AcquisitionPeriod
 */
public interface FinancialSettlementDetailInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	FinancialSettlementDetail init(FinancialSettlementDetailInit fsdi);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default FinancialSettlementDetail dispatchInit(FinancialSettlementDetailBean fsdb) {
		
		return doInit(fsdb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default FinancialSettlementDetail dispatchInit(FinancialSettlementDetailEntity fsde) {
		
		return doInit(fsde);
	}

	/**
	 * actual initialization activities
	 */
	FinancialSettlementDetail doInit(FinancialSettlementDetail fsd);

}