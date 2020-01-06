package com.db1group.damagecontrol.exception;

import com.db1group.damagecontrol.exception.RuleException.Arguments;
import com.db1group.damagecontrol.exception.HttpStatus;
import com.db1group.damagecontrol.exception.NotFoundException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class NotFoundExceptionTest {

    @Test
    void new_message() {
        NotFoundException exception = new NotFoundException("messages.not.found");
        assertEquals("Message not found", exception.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
        assertNull(exception.getArguments());
    }

    @Test
    void new_message_arguments() {
        NotFoundException exception = new NotFoundException("messages.not.found.arguments", Arguments.of("one", "two"));
        assertEquals("Message ot found with arguments - one and two", exception.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
    }

    @Test
    void new_message_throwable() {
        RuntimeException cause = new RuntimeException("cause");
        NotFoundException exception = new NotFoundException("messages.not.found", cause);
        assertEquals("Message not found", exception.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
        assertNull(exception.getArguments());
        assertEquals(cause, exception.getCause());
    }

    @Test
    void new_message_throwable_arguments() {
        RuntimeException cause = new RuntimeException("cause");
        NotFoundException exception = new NotFoundException("messages.not.found.arguments", cause, Arguments.of("one", "two"));
        assertEquals("Message ot found with arguments - one and two", exception.getMessage());
        assertEquals(HttpStatus.NOT_FOUND, exception.getHttpStatus());
        assertEquals(cause, exception.getCause());
    }

}