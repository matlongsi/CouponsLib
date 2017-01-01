package com.coupon.common.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target( { TYPE, FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { GlobalLocationNumberValidator.class,
							GlobalCouponNumberValidator.class,
							GlobalServiceRelationNumberValidator.class,
							GlobalTradeIdentificationNumberValidator.class })
@Documented
public @interface GlobalNumber {

    String message() default "Global number validation for check digit failed.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    boolean serializable() default true;

}
