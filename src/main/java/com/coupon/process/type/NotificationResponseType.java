package com.coupon.process.type;

public enum NotificationResponseType {

	ACCEPT (10),
	REJECT (20),
	CHANGES_NEEDED (30);

	/**
	 * used for storing values in database
	 * should not be changed on editing steps
	 */
	private int value;

	NotificationResponseType(int value) {
		
		this.value = value;
	}
	
	public int getValue() { return value; }
	
}