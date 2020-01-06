package com.db1group.damagecontrol.exception;

import javax.validation.ConstraintViolation;

public class ConstraintViolationException extends RuleException {
    public ConstraintViolationException(ConstraintViolation violation) {
        super(violation.getMessage());
    }
}
