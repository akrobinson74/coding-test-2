package com.crossengage.controller;

import com.crossengage.model.SMSNumber;
import com.crossengage.model.User;

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