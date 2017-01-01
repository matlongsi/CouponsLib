package com.coupon.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.coupon.common.GlobalTradeIdentificationNumber;
import com.coupon.common.utils.ValidatorHelper;


public class GlobalTradeIdentificationNumberValidator implements ConstraintValidator<GlobalNumber, GlobalTradeIdentificationNumber> {

	@Override
	public void initialize(GlobalNumber constraintAnnotation) {
    }

	@Override
	public boolean isValid(GlobalTradeIdentificationNumber gtin, ConstraintValidatorContext constraintContext) {

		boolean isValid = true;

		Byte checkDigit = ValidatorHelper.computeCheckDigit(
				gtin.getCompanyPrefix(),
				gtin.getItemReference().longValue());
		if (checkDigit != gtin.getCheckDigit()) {
			isValid = false;
		}

		if (isValid == false) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate("GlobalTradeIdentificationNumber validation for check digit failed.").addConstraintViolation();
        }
		
    	return isValid;
    }

}
