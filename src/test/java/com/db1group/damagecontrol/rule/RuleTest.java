package com.db1group.damagecontrol.rule;

import com.db1group.damagecontrol.exception.ConstraintViolationListException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import javax.validation.constraints.NotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class RuleTest {

    @Test
    void check_shouldValidateConstraints() {
        Executable executable = () -> Rule.check(new TestDTO());
        ConstraintViolationListException constraintViolationListException = assertThrows(ConstraintViolationListException.class, executable);
        assertEquals("Values is Required", constraintViolationListException.getExceptions().get(0).getMessage());
    }

    @Test
    void execute_shouldExecute_whenExpressionTrue() {
        TestDTO mock = mock(TestDTO.class);
        Rule.execute(true, () -> mock.getValue());
        verify(mock).getValue();
    }

    @Test
    void execute_shouldNotExecute_whenExpressionFalse() {
        TestDTO mock = mock(TestDTO.class);
        Rule.execute(false, () -> mock.getValue());
        verify(mock, never()).getValue();
    }

    private static class TestDTO {

        @NotNull(message = "messages.value.required")
        String value;

        public String getValue() {
            return value;
        }
    }
}