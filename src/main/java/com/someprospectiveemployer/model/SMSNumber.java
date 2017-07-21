package com.someprospectiveemployer.model;

import com.someprospectiveemployer.controller.ContactPointVisitor;
import com.someprospectiveemployer.controller.GenericContactPointVisitor;
import com.someprospectiveemployer.controller.GenericVisitable;

import java.util.function.Function;

/**
 *
 */
public class SMSNumber implements GenericVisitable<SMSNumber> {
    private final String data;

    public SMSNumber(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public Function<String, Boolean> accept(
        GenericContactPointVisitor<SMSNumber> visitor, User user) {

        /*
        return a function that yields false if the ContactMeans is not
        supported for this user
        */
        if (!(user.getContactMeans().equals(ContactMeans.phone) &&
            !(user.getContactMeans().equals(ContactMeans.all)))) {
            return ContactPointVisitor.getNOOP();
        }

        return visitor.visit(this, user);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof SMSNumber)) return false;

        SMSNumber smsNumber = (SMSNumber) o;

        return data.equals(smsNumber.data);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public String toString() {
        return "SMSNumber{" +
            "data='" + data + '\'' +
            '}';
    }
}
