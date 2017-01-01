package com.coupon.process.type;

public enum ValidationResponseType {

	/**
	 * Response code with HTTP status code 200
	 */
	VALID (100, "Coupon is valid."),
	
	/**
	 * Response code with HTTP status code 400
	 */
	DOES_NOT_EXIST (111, "Coupon does not exist."),
	INACTIVE (112, "Coupon is inactive."),
	EXPIRED (113, "Coupon has expired."),
	MAX_CUSTOMER_REDEMPTIONS_REACHED (114, "Coupon has reached maximum number of redemptions for customer."),
	MAX_TOTAL_REDEMPTIONS_REACHED (115, "Coupon has reached maximum total number of redemptions."),
	AWARDER_NOT_ALLOWED (116, "Requested awarder is not allowed to redeem coupon."),
	INVALID_REDEMPTION_PERIOD (117, "Redemption does not fall within an allowed period."),
	CUSTOMER_NOT_ALLOWED (118, "Requested customer is not allowed to redeem coupon."),
	QUALIFYING_TRADE_ITEM_MISSING (119, "One or more trade items required for purchase missing."),
	TRADE_ITEM_PER_GROUP_NOT_QUALIFIED (120, "One or more trade items per group required for purchase missing."),
	PURCHASE_AMOUNT_BELOW_REQUIRED (121, "Monetary value of purchase transaction below minimum.");

	private int code;
	private String message;

	ValidationResponseType(int code, String message) {
		
		this.code = code;
		this.message = message;
	}
	
	public int getCode() { return code; }
	
	public String getMessage() { return message; }
	
}