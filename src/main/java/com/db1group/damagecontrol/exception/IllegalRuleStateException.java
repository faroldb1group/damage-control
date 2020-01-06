package com.db1group.damagecontrol.exception;

public class IllegalRuleStateException extends RuleException {
    public IllegalRuleStateException(String message) {
        super(message);
    }

    public IllegalRuleStateException(String message, Object[] arguments) {
        super(message, arguments);
    }

    public IllegalRuleStateException(String message, HttpStatus httpStatus, Object[] arguments) {
        super(message, httpStatus, arguments);
    }

    public IllegalRuleStateException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalRuleStateException(String message, Throwable cause, Object[] arguments) {
        super(message, cause, arguments);
    }

    public IllegalRuleStateException(String message, Throwable cause, HttpStatus httpStatus, Object[] arguments) {
        super(message, cause, httpStatus, arguments);
    }
}
