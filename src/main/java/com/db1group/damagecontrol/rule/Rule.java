package com.db1group.damagecontrol.rule;


import com.db1group.damagecontrol.exception.ConstraintViolationListException;
import com.db1group.damagecontrol.exception.IllegalRuleArgumentException;
import com.db1group.damagecontrol.exception.IllegalRuleStateException;
import com.db1group.damagecontrol.exception.RuleException;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;

public class Rule {

    private static final Validator validator = ValidatorFactory.get();

    private Rule() {
    }

    public static void check(boolean expression, Supplier<RuleException> exceptionSupplier) {
        if (!expression) {
            throw exceptionSupplier.get();
        }
    }

    public static void check(boolean expression, String message) {
        check(expression, () -> new IllegalRuleArgumentException(message));
    }


    public static void check(boolean expression, String message, Object... args) {
        check(expression, () -> new IllegalRuleArgumentException(message, args));
    }

    public static <E> void check(E entity) {
        Set<ConstraintViolation<E>> violations = validator.validate(entity);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationListException(violations);
        }
    }

    public static void state(boolean expression, String message) {
        check(expression, () -> new IllegalRuleStateException(message));
    }

    public static void state(boolean expression, String message, Object... args) {
        check(expression, () -> new IllegalRuleStateException(message, args));
    }

    public static void isBlank(String value, String message) {
        isBlank(value, message, null);
    }

    public static void isBlank(String value, String message, Object... args) {
        check(!hasText(value), () -> new IllegalRuleArgumentException(message, args));
    }

    public static void isNotBlank(String value, String message) {
        isNotBlank(value, message, null);
    }

    public static void isNotBlank(String value, String message, Object... args) {
        check(hasText(value), () -> new IllegalRuleArgumentException(message, args));
    }

    public static void isNull(Object value, String message) {
        isNull(value, message, null);
    }

    public static void isNull(Object value, String message, Object... args) {
        check(Objects.isNull(value), () -> new IllegalRuleArgumentException(message, args));
    }

    public static void isNotNull(Object value, String message) {
        isNotNull(value, message, null);
    }

    public static void isNotNull(Object value, String message, Object... args) {
        check(Objects.nonNull(value), () -> new IllegalRuleArgumentException(message, args));
    }

    public static void isRequiredField(Object value, String name) {
        isRequired(value, name + " is required.");
    }

    public static void isRequired(Object value, String message) {
        isRequired(value, message, null);
    }

    public static void isRequired(Object value, String message, Object... args) {
        isNotNull(value, message, args);
        if (value instanceof String) {
            isNotBlank(value.toString(), message, args);
        }
    }

    public static void execute(boolean expression, Executable executable) {
        if (expression) {
            executable.execute();
        }
    }

    private static boolean hasText(String value) {
        return Objects.nonNull(value) && !value.trim().isEmpty();
    }

    public interface Executable {

        void execute();
    }
}