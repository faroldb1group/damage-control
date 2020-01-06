package com.db1group.damagecontrol.exception;

import com.db1group.damagecontrol.exception.HttpStatus;
import com.db1group.damagecontrol.exception.RuleException;

import java.util.List;

public abstract class RuleListException extends RuntimeException {

    private final List<RuleException> exceptions;

    private final HttpStatus status;

    public RuleListException(String message, List<RuleException> exceptions, HttpStatus status) {
        super(message);
        this.exceptions = exceptions;
        this.status = status;
    }

    public RuleListException(List<RuleException> exceptions, HttpStatus status) {
        this.exceptions = exceptions;
        this.status = status;
    }

    public RuleListException(List<RuleException> exceptions) {
        this.exceptions = exceptions;
        this.status = HttpStatus.BAD_REQUEST;
    }

    public List<RuleException> getExceptions() {
        return exceptions;
    }

    public HttpStatus getStatus() {
        return status;
    }
}
