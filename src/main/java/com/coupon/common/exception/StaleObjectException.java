package com.coupon.common.exception;

import javax.ejb.ApplicationException;


@ApplicationException(rollback=true)
public class StaleObjectException extends RuntimeException {

	private static final long serialVersionUID = 5835002356546603763L;
	
	private ErrorStatusCode errorCode;
	private String documentation;
	
	public StaleObjectException() {
		super("Stale object state");
		this.errorCode = ErrorStatusCode.CLIENT_BAD_REQUEST;
		this.documentation = "coupon documentation";
	}

	public StaleObjectException(String message, ErrorStatusCode errorCode, String documentation) {
		super(message);
		this.errorCode = errorCode;
		this.documentation = documentation;
	}

	public ErrorStatusCode getErrorCode() { return errorCode; }

	public String getDocumentation() { return documentation; }

}