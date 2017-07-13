package com.crossengage.dto;

import java.util.function.Function;

/**
 *
 */
public class EmailAddress extends ContactPoint {
    private final String address;

    public EmailAddress(String address) {
        this.address = address;
    }

    @Override
    public Function<String, Boolean> accept(ContactPointVisitor contactPointVisitor, User user) {
        return contactPointVisitor.visit(this, user);
    }

    public String getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof EmailAddress)) return false;

        EmailAddress that = (EmailAddress) o;

        return address != null ? address.equals(that.address) :
            that.address == null;
    }

    @Override
    public int hashCode() {
        return address != null ? address.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "EmailAddress{" +
            "address='" + address + '\'' +
            '}';
    }

    @Override
    public String getData() {
        return getAddress();
    }
}
