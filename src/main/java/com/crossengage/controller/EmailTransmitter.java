package com.crossengage.controller;

import com.crossengage.model.EmailAddress;
import com.crossengage.model.User;

import java.util.function.Function;

/**
 *
 */
public class EmailTransmitter extends ContactPointVisitor implements
    GenericContactPointVisitor<EmailAddress> {
//    @Override
//    public boolean supports(ContactMeans contactMeans) {
//        return contactMeans.equals(ContactMeans.email) ? true : false;
//    }
//
//    @Override
//    public Function<String, Boolean> visit(ContactPoint contactPoint, User user) {
//        return curryMsgArgs(
//            String.format("Sending Email to User [%d] at [%s] with text: ",
//                user.getId(), contactPoint.getData()
//            )
//        );
//    }

    @Override
    public Function<String, Boolean> visit(EmailAddress emailAddress, User user) {
        return curryMsgArgs(
            String.format("Sending Email to User [%d] at [%s] with text: ",
                user.getId(), emailAddress.getData()
            )
        );
    }
}
