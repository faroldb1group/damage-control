package com.db1group.damagecontrol.rule;

import javax.validation.Validation;
import javax.validation.Validator;

final class ValidatorFactory {

    private static final Validator validator;

    private ValidatorFactory() {
    }

    static {
        javax.validation.ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
        validatorFactory.close();
    }

    public static Validator get() {
        return validator;
    }

}
