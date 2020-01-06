package com.db1group.damagecontrol.exception;

import javax.validation.ConstraintViolation;
import java.util.Set;
import java.util.stream.Collectors;

public class ConstraintViolationListException extends RuleListException {

    public <E> ConstraintViolationListException(Set<ConstraintViolation<E>> violations) {
        super(violations.stream().map(ConstraintViolationException::new).collect(Collectors.toList()));
    }
}
