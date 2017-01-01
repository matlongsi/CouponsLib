package com.coupon.common.init;

import com.coupon.common.Artwork;
import com.coupon.common.bean.ArtworkBean;
import com.coupon.common.entity.ArtworkEntity;


/**
 * Interface to initialize (visitor pattern) AcquisitionPeriod
 */
public interface ArtworkInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	Artwork init(ArtworkInit ai);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default Artwork dispatchInit(ArtworkBean ab) {
		
		return doInit(ab);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default Artwork dispatchInit(ArtworkEntity ae) {
		
		return doInit(ae);
	}

	/**
	 * actual initialization activities
	 */
	Artwork doInit(Artwork a);

}