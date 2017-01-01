package com.coupon.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.coupon.common.GlobalLocationNumber;
import com.coupon.common.utils.ValidatorHelper;


public class GlobalLocationNumberValidator implements ConstraintValidator<GlobalNumber, GlobalLocationNumber> {

	@Override
	public void initialize(GlobalNumber constraintAnnotation) {
    }

	@Override
	public boolean isValid(GlobalLocationNumber gln, ConstraintValidatorContext constraintContext) {

		boolean isValid = true;

		Byte checkDigit = ValidatorHelper.computeCheckDigit(
				gln.getCompanyPrefix(),
				gln.getLocationReference().longValue());
		if (checkDigit != gln.getCheckDigit()) {
			isValid = false;
		}

		if (isValid == false) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate("GlobalLocationNumber validation for check digit failed.").addConstraintViolation();
        }

		return isValid;
    }

}
