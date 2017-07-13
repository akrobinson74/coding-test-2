package com.crossengage.dto;

import com.crossengage.SMSVisitsContactPoints;

import java.util.function.Function;

/**
 *
 */
public interface SMSContactPoint extends AcceptsVisitors {
    Function<String, Boolean> accept(
        SMSVisitsContactPoints smsContactPointVisitor, User user
    );
}
