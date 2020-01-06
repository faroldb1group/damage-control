package com.db1group.damagecontrol.exception;

public class NotFoundException extends RuleException {

    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String message, Object[] arguments) {
        super(message, HttpStatus.NOT_FOUND, arguments);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause, HttpStatus.NOT_FOUND);
    }

    public NotFoundException(String message, Throwable cause, Object[] arguments) {
        super(message, cause, HttpStatus.NOT_FOUND, arguments);
    }
}
