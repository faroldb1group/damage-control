package com.db1group.damagecontrol.handler;


public class RuleExceptionHandler {
    public RuleExceptionSummary apply(Exception exception) {
        return RuleExceptionHandlerConsumerFactory.get(exception).consume(exception);
    }
}
