package com.db1group.damagecontrol.exception;

public class IllegalRuleArgumentException extends RuleException {
    public IllegalRuleArgumentException(String message) {
        super(message);
    }

    public IllegalRuleArgumentException(String message, Object[] arguments) {
        super(message, arguments);
    }

    public IllegalRuleArgumentException(String message, HttpStatus httpStatus, Object[] arguments) {
        super(message, httpStatus, arguments);
    }

    public IllegalRuleArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalRuleArgumentException(String message, Throwable cause, Object[] arguments) {
        super(message, cause, arguments);
    }

    public IllegalRuleArgumentException(String message, Throwable cause, HttpStatus httpStatus, Object[] arguments) {
        super(message, cause, httpStatus, arguments);
    }
}
