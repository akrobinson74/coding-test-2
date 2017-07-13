package com.crossengage.model;

import com.crossengage.controller.ContactPoint;
import com.crossengage.controller.ContactPointVisitor;

import java.util.function.Function;

/**
 *
 */
public class EmailAddress extends ContactPoint {
    private final String data;

    public EmailAddress(String data) {
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
        if (! (o instanceof EmailAddress)) return false;

        EmailAddress that = (EmailAddress) o;

        return data.equals(that.data);
    }

    @Override
    public int hashCode() {
        return data.hashCode();
    }

    @Override
    public String toString() {
        return "EmailAddress{" +
            "data='" + data + '\'' +
            '}';
    }
}
