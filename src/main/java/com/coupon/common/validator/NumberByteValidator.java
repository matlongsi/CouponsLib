package com.coupon.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


public class NumberByteValidator implements ConstraintValidator<Number, Byte> {

	private int digits;
	private boolean optional;
	
	@Override
    public void initialize(Number constraintAnnotation) {
		this.digits = constraintAnnotation.digits();
		this.optional = constraintAnnotation.optional();
    }

	@Override
    public boolean isValid(Byte number, ConstraintValidatorContext constraintContext) {

		if (optional && (number == null)) {
			return true;
		}
		
		boolean isValid = true;
		if (number < 0) {
			
			isValid = false;
		}
		else if (number > 0) {
			
			int numberDigits = (byte)(Math.log10(number) + 1);
			if (numberDigits > this.digits) {
				isValid = false;
			}
		}
		
		return isValid;
    }
    
}
