package com.coupon.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class AmountFloatValidator implements ConstraintValidator<Amount, Float> {

	private int decimalDigits;
	private int totalDigits;
	private boolean optional;
	
	@Override
    public void initialize(Amount constraintAnnotation) {
		this.decimalDigits = constraintAnnotation.decimalDigits();
		this.totalDigits = constraintAnnotation.totalDigits();
		this.optional = constraintAnnotation.optional();
    }

	@Override
    public boolean isValid(Float amount, ConstraintValidatorContext constraintContext) {

		if (optional && (amount == null)) {
			return true;
		}
		
		if (totalDigits <= decimalDigits) {
			return false;
		}
		
		String[] splitter = amount.toString().split("\\.");
		if (splitter[0].length() > (totalDigits - decimalDigits)) {   //before decimal count
			return false;
		}
		if (splitter[1].length() > decimalDigits) {   //after decimal count
			return false;
		}
		
		return true;
    }
    
}