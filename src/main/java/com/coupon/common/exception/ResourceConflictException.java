package com.coupon.common.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class ResourceConflictException extends RuntimeException {

	private static final long serialVersionUID = -3948311206220656060L;

	public static final String DEFAULT_MESSAGE = "Resource conflict";
	public static final ErrorStatusCode DEFAULT_ERROR_CODE = ErrorStatusCode.CLIENT_ERROR_CONFLICT;
	public static final String DEFAULT_DOCUMENTATION = "coupon documentation";
	
	private ErrorStatusCode errorCode;
	private String documentation;
	
	public ResourceConflictException() {
		
		super(DEFAULT_MESSAGE);
		this.errorCode = DEFAULT_ERROR_CODE;
		this.documentation = DEFAULT_DOCUMENTATION;
	}

	public ResourceConflictException(String message) {
		
		super(message);
		this.errorCode = DEFAULT_ERROR_CODE;
		this.documentation = DEFAULT_DOCUMENTATION;
	}

	public ResourceConflictException(String message, ErrorStatusCode errorCode, String documentation) {
		
		super(message);
		this.errorCode = errorCode;
		this.documentation = documentation;
	}

	public ErrorStatusCode getErrorCode() { return errorCode; }
	public void setErrorCode(ErrorStatusCode errorCode) { this.errorCode = errorCode; }

	public String getDocumentation() { return documentation; }
	public void setDocumentation(String documentation) { this.documentation = documentation; }

}