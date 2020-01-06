package com.db1group.damagecontrol.handler;

import com.db1group.damagecontrol.exception.HttpStatus;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

public class RuleExceptionSummary implements Serializable {

    private static final long serialVersionUID = -7468871925372737499L;

    private HttpStatus status;

    private Set<String> messages = new HashSet<>();

    private String cause;

    private final Instant timestamp = Instant.now();

    private RuleExceptionSummary() {
    }

    public static RuleExceptionSummary of(HttpStatus status, String cause, Set<String> messages) {
        RuleExceptionSummary summary = new RuleExceptionSummary();
        summary.status = status;
        summary.cause = cause;
        summary.messages = messages;
        return summary;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public Set<String> getMessages() {
        return messages;
    }

    public String getCause() {
        return cause;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

}
