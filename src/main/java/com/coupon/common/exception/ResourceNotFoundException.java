package com.coupon.common.exception;

import javax.ejb.ApplicationException;

@ApplicationException(rollback=true)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8634495176347162985L;
	
	public static final String DEFAULT_MESSAGE = "Resource not found.";
	public static final ErrorStatusCode DEFAULT_ERROR_CODE = ErrorStatusCode.RESOURCE_NOT_FOUND;
	public static final String DEFAULT_DOCUMENTATION = "coupon documentation";
	
	private ErrorStatusCode errorCode;
	private String documentation;
	
	public ResourceNotFoundException() {
		
		super(DEFAULT_MESSAGE);
		this.errorCode = DEFAULT_ERROR_CODE;
		this.documentation = DEFAULT_DOCUMENTATION;
	}

	public ResourceNotFoundException(String message) {
		
		super(message);
		this.errorCode = DEFAULT_ERROR_CODE;
		this.documentation = DEFAULT_DOCUMENTATION;
	}

	public ResourceNotFoundException(String message, ErrorStatusCode errorCode, String documentation) {
		
		super(message);
		this.errorCode = errorCode;
		this.documentation = documentation;
	}

	public ErrorStatusCode getErrorCode() { return errorCode; }
	public void setErrorCode(ErrorStatusCode errorCode) { this.errorCode = errorCode; }

	public String getDocumentation() { return documentation; }
	public void setDocumentation(String documentation) { this.documentation = documentation; }

}