package com.coupon.common.init;

import com.coupon.common.RewardTradeItem;
import com.coupon.common.bean.RewardTradeItemBean;
import com.coupon.common.entity.RewardTradeItemEntity;
import com.coupon.process.entity.CouponRewardTradeItemEntity;
import com.coupon.process.message.RewardTradeItemMsg;


/**
 * Interface to initialize (visitor pattern) RewardTradeItem
 */
public interface RewardTradeItemInit {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	RewardTradeItem init(RewardTradeItemInit rtii);

	/**
	 * equivalent of "visit" in visitor pattern
	 */	
	default RewardTradeItem dispatchInit(RewardTradeItemBean rtib) {
		
		return doInit(rtib);
	}
	
	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default RewardTradeItem dispatchInit(RewardTradeItemEntity rtie) {

		return doInit(rtie);
	}

	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default RewardTradeItem dispatchInit(CouponRewardTradeItemEntity crtie) {

		return doInit(crtie);
	}

	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default RewardTradeItem dispatchInit(RewardTradeItemMsg rtim) {

		return doInit(rtim);
	}

	/**
	 * actual initialization activities
	 */
	RewardTradeItem doInit(RewardTradeItem rti);

}