package com.jan.enterprise.pos.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.jan.enterprise.pos.web.form.SignUpForm;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public void initialize(final PasswordMatches constraintAnnotation) {
        //
    }

    @Override
    public boolean isValid(final Object obj, final ConstraintValidatorContext context) {
        final SignUpForm user = (SignUpForm) obj;
        return user.getPassword().equals(user.getConfirmPassword());
    }

}
