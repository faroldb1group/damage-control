package com.db1group.damagecontrol.handler;

import com.db1group.damagecontrol.exception.RuleException;
import com.db1group.damagecontrol.exception.RuleListException;

class RuleExceptionHandlerConsumerFactory {

    static RuleExceptionHandlerConsumer get(Exception exception) {
        if (exception instanceof RuleException) {
            return new RuleExceptionHandlerConsumerImpl();
        }

        if (exception instanceof RuleListException) {
            return new RuleListExceptionHandlerConsumerImpl();
        }

        return new RuleDefaultExceptionHandlerConsumer();
    }

}
