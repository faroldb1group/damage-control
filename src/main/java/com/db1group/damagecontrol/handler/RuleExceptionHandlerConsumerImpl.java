package com.db1group.damagecontrol.handler;

import com.db1group.damagecontrol.exception.RuleException;

import java.util.HashSet;
import java.util.Set;

class RuleExceptionHandlerConsumerImpl extends RuleExceptionHandlerConsumer<RuleException> {

    @Override
    protected RuleExceptionSummary consume(RuleException exception) {
        Set<String> messages = new HashSet<>();
        messages.add(exception.getMessage());
        return RuleExceptionSummary.of(exception.getHttpStatus(), getCause(exception), messages);
    }
}
