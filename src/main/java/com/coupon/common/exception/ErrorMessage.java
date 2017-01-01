package com.coupon.common.exception;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessOrder;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)
public class ErrorMessage {

	private ErrorStatusCode errorCode;
	private List<String> errorMessages;
	private String documentation;

	public ErrorMessage() {
		
		this.errorMessages = new ArrayList<String>();
	}

	public ErrorMessage(ErrorStatusCode errorCode, String documentation) {
		
		super();
		this.errorMessages = new ArrayList<String>();
		this.errorCode = errorCode;
		this.documentation = documentation;
	}

	public ErrorStatusCode getErrorCode() { return errorCode; }
	public void setErrorCode(ErrorStatusCode errorCode) { this.errorCode = errorCode; }

	public List<String> getErrorMessages() { return errorMessages; }
	public void setErrorMessages(List<String> errorMessages) { this.errorMessages = errorMessages; }
	public void addErrorMessage(String errorMessage) { this.errorMessages.add(errorMessage); }

	public String getDocumentation() { return documentation; }
	public void setDocumentation(String documentation) { this.documentation = documentation; }

}