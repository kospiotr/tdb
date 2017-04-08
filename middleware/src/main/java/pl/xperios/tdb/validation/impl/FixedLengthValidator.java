/*
 * created by: Piotr Kosmowski
 * Template pack-custom:middleware/src/main/java/validation/impl/FixedLengthValidator.p.vm.java
 */
package pl.xperios.tdb.validation.impl;

import static org.apache.commons.lang.StringUtils.isEmpty;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import pl.xperios.tdb.validation.FixedLength;

public class FixedLengthValidator implements ConstraintValidator<FixedLength, String> {

    private FixedLength constraint;

    @Override
    public void initialize(FixedLength constraint) {
        this.constraint = constraint;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (isEmpty(value)) {
            return constraint.nullable();
        }
        return value.length() == constraint.length();
    }
}
