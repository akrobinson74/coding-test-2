package com.crossengage.controller;

import com.crossengage.model.User;

import java.util.function.Function;

/**
 *
 */
public class SMSTransmitter extends ContactPointVisitor {
    @Override
    public Function<String, Boolean> visit(AcceptsVisitors acceptsVisitors, User user) {
        return curryMsgArgs("Sending SMS to " + acceptsVisitors.getData()
            + " with text: ");
    }

    public Function<String, Boolean> curryMsgArgs(String preamble) {
        return (String arg) -> {
            System.out.println(preamble + arg);
            return true;
        };
    }
}