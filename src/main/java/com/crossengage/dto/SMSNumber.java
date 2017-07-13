package com.crossengage.dto;

import java.util.function.Function;

/**
 *
 */
public class SMSNumber extends ContactPoint {
    private final String number;

    public SMSNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
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

        return number != null ? number.equals(smsNumber.number) :
            smsNumber.number == null;
    }

    @Override
    public int hashCode() {
        return number != null ? number.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "SMSNumber{" +
            "number='" + number + '\'' +
            '}';
    }

    @Override
    public String getData() {
        return getNumber();
    }
}
