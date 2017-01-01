package com.coupon.common.utils;


/**
 * Interface to initialize (visitor pattern) AcquisitionPeriod
 */
public interface Initializor<T> {

	/**
	 * equivalent of "accept" in visitor pattern
	 */
	T init(Initializor<T> i);

	/**
	 * equivalent of "visit" in visitor pattern
	 */
	default T dispatchInit(T e) {

		return doInit(e);
	}

	/**
	 * actual initialization activities
	 */
	T doInit(T a);

}