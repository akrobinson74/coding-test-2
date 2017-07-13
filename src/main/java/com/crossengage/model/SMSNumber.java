package com.crossengage.model;

import com.crossengage.controller.ContactPoint;
import com.crossengage.controller.ContactPointVisitor;

import java.util.function.Function;

/**
 *
 */
public class SMSNumber extends ContactPoint {
    private final String data;

    public SMSNumber(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public Function<String, Boolean> accept(ContactPointVisitor contactPointVisitor, User user) {
        return contactPointVisitor.visit(this, user);
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
