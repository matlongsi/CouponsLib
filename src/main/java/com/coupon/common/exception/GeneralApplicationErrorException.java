package com.coupon.common.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class GeneralApplicationErrorException extends RuntimeException {

	private static final long serialVersionUID = -4577163530482074475L;
	
	public static final String DEFAULT_MESSAGE = "General application error.";
	public static final ErrorStatusCode DEFAULT_ERROR_CODE = ErrorStatusCode.INTERNAL_SERVER_ERROR;
	public static final String DEFAULT_DOCUMENTATION = "coupon documentation";

	private ErrorStatusCode errorCode;
	private String documentation;
	
	public GeneralApplicationErrorException() {

		super(DEFAULT_MESSAGE);
		this.errorCode = DEFAULT_ERROR_CODE;
		this.documentation = DEFAULT_DOCUMENTATION;
	}

	public GeneralApplicationErrorException(String message) {

		super(message);
		this.errorCode = DEFAULT_ERROR_CODE;
		this.documentation = DEFAULT_DOCUMENTATION;
	}

	public GeneralApplicationErrorException(String message, ErrorStatusCode errorCode, String documentation) {

		super(message);
		this.errorCode = errorCode;
		this.documentation = documentation;
	}

	public ErrorStatusCode getErrorCode() { return errorCode; }
	public void setErrorCode(ErrorStatusCode errorCode) { this.errorCode = errorCode; }

	public String getDocumentation() { return documentation; }
	public void setDocumentation(String documentation) { this.documentation = documentation; }

}