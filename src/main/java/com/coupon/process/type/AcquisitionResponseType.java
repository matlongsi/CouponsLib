package com.coupon.process.type;

public enum AcquisitionResponseType {

	REDEEMABLE (10),
	NOT_REDEEMABLE (100);

	/**
	 * used for storing values in database
	 * should not be changed on editing steps
	 */
	private int value;

	AcquisitionResponseType(int value) {
		
		this.value = value;
	}
	
	public int getValue() { return value; }
	
}