package com.coupon.common.init;

import com.coupon.common.RewardLoyaltyPoint;
import com.coupon.common.bean.RewardLoyaltyPointBean;
import com.coupon.common.entity.RewardLoyaltyPointEntity;
import com.coupon.process.entity.CouponRewardLoyaltyPointEntity;
import com.coupon.process.message.RewardLoyaltyPointMsg;


/**
 * Interface to initialize (visitor pattern) Reward
 */
public interface RewardLoyaltyPointInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	RewardLoyaltyPoint init(RewardLoyaltyPointInit rlpi);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default RewardLoyaltyPoint dispatchInit(RewardLoyaltyPointBean rlpb) {
		
		return doInit(rlpb);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default RewardLoyaltyPoint dispatchInit(RewardLoyaltyPointEntity rlpe) {

		return doInit(rlpe);
	}

	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default RewardLoyaltyPoint dispatchInit(CouponRewardLoyaltyPointEntity crlpe) {

		return doInit(crlpe);
	}

	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default RewardLoyaltyPoint dispatchInit(RewardLoyaltyPointMsg rlpm) {

		return doInit(rlpm);
	}

	/**
	 * actual initialization activities
	 */
	RewardLoyaltyPoint doInit(RewardLoyaltyPoint rlp);

}