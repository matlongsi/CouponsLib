package com.coupon.common.exception;

public enum ErrorStatusCode {
	
	CLIENT_BAD_REQUEST(400),
	RESOURCE_NOT_FOUND(404),
	METHOD_NOT_ALLOWED(405),
	CLIENT_ERROR_CONFLICT(409),
	CLIENT_ERROR_DATA_VALIDATION(430),
	INTERNAL_SERVER_ERROR(500);

	private int value;
	
	private ErrorStatusCode(int value) {
		this.value = value;
	}

	public int getValue() {
		return this.value;
	}
}
