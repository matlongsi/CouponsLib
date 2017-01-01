package com.coupon.common.init;

import com.coupon.common.Reward;
import com.coupon.common.bean.RewardBean;
import com.coupon.common.entity.RewardEntity;
import com.coupon.process.entity.CouponRewardEntity;


/**
 * Interface to initialize (visitor pattern) Reward
 */
public interface RewardInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	Reward init(RewardInit ri);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default Reward dispatchInit(RewardBean rb) {
		
		return doInit(rb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default Reward dispatchInit(RewardEntity re) {

		return doInit(re);
	}

	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default Reward dispatchInit(CouponRewardEntity cre) {

		return doInit(cre);
	}

	/**
	 * actual initialization activities
	 */
	Reward doInit(Reward r);

}