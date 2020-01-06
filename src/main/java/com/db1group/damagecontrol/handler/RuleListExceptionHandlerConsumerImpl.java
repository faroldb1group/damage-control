package com.db1group.damagecontrol.handler;

import com.db1group.damagecontrol.exception.RuleException;
import com.db1group.damagecontrol.exception.RuleListException;
import com.db1group.damagecontrol.handler.RuleExceptionHandlerConsumer;
import com.db1group.damagecontrol.handler.RuleExceptionSummary;

import java.util.Set;
import java.util.stream.Collectors;

class RuleListExceptionHandlerConsumerImpl extends RuleExceptionHandlerConsumer<RuleListException> {

    @Override
    protected RuleExceptionSummary consume(RuleListException exception) {
        Set<String> messages = exception.getExceptions().stream().map(RuleException::getMessage).collect(Collectors.toSet());
        return RuleExceptionSummary.of(exception.getStatus(), getCause(exception), messages);
    }
}
