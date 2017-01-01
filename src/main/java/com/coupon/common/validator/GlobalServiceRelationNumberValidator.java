package com.coupon.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.coupon.common.GlobalServiceRelationNumber;
import com.coupon.common.utils.ValidatorHelper;


public class GlobalServiceRelationNumberValidator implements ConstraintValidator<GlobalNumber, GlobalServiceRelationNumber> {

	@Override
	public void initialize(GlobalNumber constraintAnnotation) {
    }

	@Override
	public boolean isValid(GlobalServiceRelationNumber gsrn, ConstraintValidatorContext constraintContext) {

		boolean isValid = true;

		byte checkDigit = ValidatorHelper.computeCheckDigit(gsrn.getCompanyPrefix(), gsrn.getServiceReference());
		if (checkDigit != gsrn.getCheckDigit()) {
			isValid = false;
		}

		if (isValid == false) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate("GlobalServiceRelationNumber validation for check digit failed.").addConstraintViolation();
        }
		
    	return isValid;
    }

}
