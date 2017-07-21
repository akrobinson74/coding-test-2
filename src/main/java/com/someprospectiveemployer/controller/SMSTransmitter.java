package com.someprospectiveemployer.controller;

import com.someprospectiveemployer.model.SMSNumber;
import com.someprospectiveemployer.model.User;

import java.util.function.Function;

/**
 *
 */
public class SMSTransmitter extends ContactPointVisitor implements
    GenericContactPointVisitor<SMSNumber> {

    @Override
    public Function<String, Boolean> visit(
        SMSNumber smsNumber, User user) {
        return curryMsgArgs(
            String.format("Sending SMS to User [%d] at [%s] with text: ",
                user.getId(), smsNumber.getData()
            )
        );
    }
}