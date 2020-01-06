package com.db1group.damagecontrol.handler;

import com.db1group.damagecontrol.exception.HttpStatus;

import java.util.HashSet;
import java.util.Set;

class RuleDefaultExceptionHandlerConsumer extends RuleExceptionHandlerConsumer<Exception> {

    @Override
    protected RuleExceptionSummary consume(Exception exception) {
        final Set<String> messages = new HashSet<>();
        messages.add(exception.getMessage());
        return RuleExceptionSummary.of(HttpStatus.INTERNAL_SERVER_ERROR, getCause(exception), messages);
    }
}
