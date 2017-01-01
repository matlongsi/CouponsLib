package com.coupon.common.validator;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = { AmountFloatValidator.class } )
@Documented
public @interface Amount {

    String message() default "Amount validation failed.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    int decimalDigits();
    
    int totalDigits();
    
    boolean optional() default false;

}