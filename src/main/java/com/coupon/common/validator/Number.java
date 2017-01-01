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
@Constraint(validatedBy = { NumberLongValidator.class,
							NumberIntegerValidator.class,
							NumberByteValidator.class } )
@Documented
public @interface Number {

    String message() default "Number validation failed.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
    
    int digits();
    
    boolean optional() default false;
    
}
