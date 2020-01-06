package com.db1group.damagecontrol.handler;

import java.util.Objects;

abstract class RuleExceptionHandlerConsumer<T extends Exception> {

    protected abstract RuleExceptionSummary consume(T exception);

    protected String getCause(Exception e) {
        if (Objects.nonNull(e.getCause())) {
            return e.getCause().getClass().getName();
        }
        return e.getClass().getName();
    }
}
