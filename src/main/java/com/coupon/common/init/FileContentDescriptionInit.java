package com.coupon.common.init;

import com.coupon.common.FileContentDescription;
import com.coupon.common.bean.FileContentDescriptionBean;
import com.coupon.common.entity.FileContentDescriptionEntity;


/**
 * Interface to initialize (visitor pattern) AcquisitionPeriod
 */
public interface FileContentDescriptionInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	FileContentDescription init(FileContentDescriptionInit fcdi);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default FileContentDescription dispatchInit(FileContentDescriptionBean fcdb) {
		
		return doInit(fcdb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default FileContentDescription dispatchInit(FileContentDescriptionEntity fcde) {
		
		return doInit(fcde);
	}

	/**
	 * actual initialization activities
	 */
	FileContentDescription doInit(FileContentDescription fcd);

}