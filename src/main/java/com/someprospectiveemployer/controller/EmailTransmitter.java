package com.someprospectiveemployer.controller;

import com.someprospectiveemployer.model.EmailAddress;
import com.someprospectiveemployer.model.User;

import java.util.function.Function;

/**
 *
 */
public class EmailTransmitter extends ContactPointVisitor implements
    GenericContactPointVisitor<EmailAddress> {

    @Override
    public Function<String, Boolean> visit(EmailAddress emailAddress, User user) {
        return curryMsgArgs(
            String.format("Sending Email to User [%d] at [%s] with text: ",
                user.getId(), emailAddress.getData()
            )
        );
    }
}
