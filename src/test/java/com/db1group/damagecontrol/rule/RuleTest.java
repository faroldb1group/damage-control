package com.db1group.damagecontrol.rule;

import com.db1group.damagecontrol.exception.ConstraintViolationListException;
import com.db1group.damagecontrol.rule.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import javax.validation.constraints.NotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RuleTest {

    @Test
    void check_shouldValidateConstraints() {
        Executable executable = () -> Rule.check(new TestDTO());
        ConstraintViolationListException constraintViolationListException = assertThrows(ConstraintViolationListException.class, executable);
        assertEquals("Values is Required", constraintViolationListException.getExceptions().get(0).getMessage());
    }

    private static class TestDTO {

        @NotNull(message = "messages.value.required")
        String value;
    }
}