package com.crossengage.dto;

import java.util.HashSet;

/**
 *
 */
public class ContactInformation {
    private HashSet<AcceptsVisitors> acceptsVisitors;
    private String email;
    private String phone;

    public ContactInformation(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof ContactInformation)) return false;

        ContactInformation that = (ContactInformation) o;

        if (! email.equals(that.email)) return false;
        return phone.equals(that.phone);
    }

    @Override
    public int hashCode() {
        int result = email.hashCode();
        result = 31 * result + phone.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "ContactInformation{" +
            "email='" + email + '\'' +
            ", phone='" + phone + '\'' +
            '}';
    }

    /**
     *
     */
    public static interface EmailContactPoint extends AcceptsVisitors {
    }
}
