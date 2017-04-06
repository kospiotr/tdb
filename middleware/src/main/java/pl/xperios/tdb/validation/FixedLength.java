/*
 * created by: Piotr Kosmowski
 * Template pack-custom:src/main/java/validation/FixedLength.p.vm.java
 */
package pl.xperios.tdb.validation;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import pl.xperios.tdb.validation.impl.FixedLengthValidator;

@Target({ METHOD, FIELD, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = FixedLengthValidator.class)
@Documented
public @interface FixedLength {
    int length() default 0;

    boolean nullable() default true;

    String message() default "{pl.xperios.tdb.validation.FixedLength.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
