package com.crossengage.dto;

import com.crossengage.ContactPointFactory;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 *
 */
public class User {
    private final Long id;
    private final Boolean active;
    private final ContactMeans contactMeans;
    private final Set<AcceptsVisitors> acceptsVisitors;

    public User(
        final Long id,
        final Boolean active,
        final ContactMeans contactMeans,
        final HashSet<AcceptsVisitors> acceptsVisitors) {

        this.id = id;
        this.active = active;
        this.contactMeans = contactMeans;
        this.acceptsVisitors = acceptsVisitors.stream().filter(cp -> cp != null)
            .collect(Collectors.toSet());
    }

    public Long getId() {
        return id;
    }

    public Boolean getActive() {
        return active;
    }

    public ContactMeans getContactMeans() {
        return contactMeans;
    }

    public Set<AcceptsVisitors> getAcceptsVisitors() {
        return acceptsVisitors;
    }

    public boolean isValid() {
        if (active && acceptsVisitors != null && acceptsVisitors.size() >= 1)
            return true;
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (! (o instanceof User)) return false;

        User user = (User) o;

        if (! id.equals(user.id)) return false;
        if (! active.equals(user.active)) return false;
        if (contactMeans != user.contactMeans) return false;

        return acceptsVisitors != null ?
            acceptsVisitors.equals(user.acceptsVisitors) :
            user.acceptsVisitors == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + active.hashCode();
        result = 31 * result + contactMeans.hashCode();
        result = 31 * result + (acceptsVisitors != null ? acceptsVisitors.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", active=" + active +
            ", contactMeans=" + contactMeans +
            ", acceptsVisitors=" + acceptsVisitors +
            '}';
    }

    public static User getUserForStrings(String[] fields) {
        return new User(
            Long.valueOf(fields[0]),
            Boolean.valueOf(fields[1]),
            ContactMeans.valueOf(fields[2]),
            new HashSet<AcceptsVisitors>(
                Arrays.asList(
                    ContactPointFactory.getContactForData(fields[3]),
                    ContactPointFactory.getContactForData(fields[4])
                )
            )
        );
    }
}
