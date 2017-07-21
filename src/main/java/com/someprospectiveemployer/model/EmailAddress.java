package com.someprospectiveemployer.model;

import com.someprospectiveemployer.controller.ContactPointVisitor;
import com.someprospectiveemployer.controller.GenericContactPointVisitor;
import com.someprospectiveemployer.controller.GenericVisitable;

import java.util.function.Function;

/**
 *
 */
public class EmailAddress implements GenericVisitable<EmailAddress> {
    private final String data;

    public EmailAddress(String data) {
        this.data = data;
    }

    @Override
    public String getData() {
        return data;
    }

    @Override
    public Function<String, Boolean> accept(
        GenericContactPointVisitor<EmailAddress> visitor, User user) {

        if (!(user.getContactMeans().equals(ContactMeans.email) &&
            !(user.getContactMeans().equals(ContactMeans.all)))) {
            return ContactPointVisitor.getNOOP();
        }

        return visitor.visit(this, user);
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
