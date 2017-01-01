package com.coupon.common.init;

import com.coupon.common.LegalStatement;
import com.coupon.common.bean.LegalStatementBean;
import com.coupon.common.entity.LegalStatementEntity;


/**
 * Interface to initialize (visitor pattern) AcquisitionPeriod
 */
public interface LegalStatementInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	LegalStatement init(LegalStatementInit lsi);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default LegalStatement dispatchInit(LegalStatementBean lsb) {
		
		return doInit(lsb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default LegalStatement dispatchInit(LegalStatementEntity lse) {
		
		return doInit(lse);
	}

	/**
	 * actual initialization activities
	 */
	LegalStatement doInit(LegalStatement ls);

}