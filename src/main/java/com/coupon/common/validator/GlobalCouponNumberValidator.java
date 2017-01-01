package com.coupon.common.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.coupon.common.GlobalCouponNumber;
import com.coupon.common.utils.ValidatorHelper;


public class GlobalCouponNumberValidator implements ConstraintValidator<GlobalNumber, GlobalCouponNumber> {

	private boolean serializable;

	@Override
	public void initialize(GlobalNumber constraintAnnotation) {
		serializable = constraintAnnotation.serializable();
    }

	@Override
	public boolean isValid(GlobalCouponNumber gcn, ConstraintValidatorContext constraintContext) {

		boolean isValid = true;

		Byte checkDigit = ValidatorHelper.computeCheckDigit(
				gcn.getCompanyPrefix(),
				gcn.getCouponReference().longValue());
		if (checkDigit != gcn.getCheckDigit()) {

			isValid = false;
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate("GlobalCouponNumber validation for check digit failed.")
            					.addConstraintViolation();
		}

		if ((this.serializable == false) && (gcn.getSerialComponent() != GlobalCouponNumber.OFFER_SERIAL_COMPONENT)) {

			isValid = false;
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate("Serial component not supported for provided GlobalCouponNumber.")
            					.addConstraintViolation();
		}

		return isValid;
    }

}