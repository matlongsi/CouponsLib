package com.coupon.process.type;

public enum SourcingStepType {

	ISSUER_SETUP (1, 10),
	DISTRIBUTOR_SETUP_RECEIPT (2, 20),
	ISSUER_NOTIFICATION (3, 30),
	AWARDER_NOTIFICATION_RECEIPT (4, 40),
	AWARDER_RESPONSE (5, 50);

	/**
	 * used for business logic
	 * can be changed on editing steps
	 */
	private int step;

	/**
	 * used for storing values in database
	 * should not be changed on editing steps
	 */
	private int value;

	SourcingStepType(int step, int value) {
		
		this.step = step;
		this.value = value;
	}
	
	public int getStep() { return step; }
	
	public int getValue() { return value; }
	
}