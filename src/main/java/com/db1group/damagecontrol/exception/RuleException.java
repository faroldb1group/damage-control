package com.db1group.damagecontrol.exception;

import com.db1group.fairy.MessageResource;

import java.util.Objects;

import static java.util.Objects.nonNull;

public abstract class RuleException extends RuntimeException {

    private static final MessageResource MESSAGE_RESOURCE = MessageResource.of();

    private final HttpStatus httpStatus;

    private final Object[] arguments;

    public RuleException(String message) {
        this(message, HttpStatus.BAD_REQUEST);
    }

    public RuleException(String message, HttpStatus httpStatus) {
        super(getMessage(message, null));
        this.httpStatus = httpStatus;
        this.arguments = null;
    }

    public RuleException(String message, Object[] arguments) {
        this(message, HttpStatus.BAD_REQUEST, arguments);
    }

    public RuleException(String message, HttpStatus httpStatus, Object[] arguments) {
        super(getMessage(message, arguments));
        this.httpStatus = httpStatus;
        this.arguments = arguments;
    }

    public RuleException(String message, Throwable cause) {
        this(message, cause, HttpStatus.BAD_REQUEST);
    }

    public RuleException(String message, Throwable cause, HttpStatus httpStatus) {
        super(getMessage(message, null), cause);
        this.httpStatus = httpStatus;
        this.arguments = null;
    }

    public RuleException(String message, Throwable cause, Object[] arguments) {
        this(message, cause, HttpStatus.BAD_REQUEST, arguments);
    }

    public RuleException(String message, Throwable cause, HttpStatus httpStatus, Object[] arguments) {
        super(getMessage(message, arguments), cause);
        this.httpStatus = httpStatus;
        this.arguments = arguments;
    }

    private static String getMessage(String message, Object[] arguments) {
        return nonNull(arguments) ? MESSAGE_RESOURCE.getMessage(message, arguments) : MESSAGE_RESOURCE.getMessage(message);
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Object[] getArguments() {
        return arguments;
    }

    public static class Arguments {

        public static Object[] of(Object o1) {
            return new Object[]{o1};
        }

        public static Object[] of(Object o1, Object o2) {
            return new Object[]{o1, o2};
        }

        public static Object[] of(Object o1, Object o2, Object o3) {
            return new Object[]{o1, o2, o3};
        }

        public static Object[] of(Object o1, Object o2, Object o3, Object o4) {
            return new Object[]{o1, o2, o3, o4};
        }

        public static Object[] of(Object o1, Object o2, Object o3, Object o4, Object o5) {
            return new Object[]{o1, o2, o3, o4, o5};
        }

        public static Object[] of(Object o1, Object o2, Object o3, Object o4, Object o5, Object o6) {
            return new Object[]{o1, o2, o3, o4, o5, o6};
        }

        public static Object[] of(Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7) {
            return new Object[]{o1, o2, o3, o4, o5, o6, o7};
        }

        public static Object[] of(Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8) {
            return new Object[]{o1, o2, o3, o4, o5, o6, o7, o8};
        }

        public static Object[] of(Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9) {
            return new Object[]{o1, o2, o3, o4, o5, o6, o7, o8, o9};
        }

        public static Object[] of(Object o1, Object o2, Object o3, Object o4, Object o5, Object o6, Object o7, Object o8, Object o9, Object o10) {
            return new Object[]{o1, o2, o3, o4, o5, o6, o7, o8, o9, o10};
        }

        public static Object[] of(Object... values) {
            Objects.requireNonNull(values);
            return values;
        }
    }
}
