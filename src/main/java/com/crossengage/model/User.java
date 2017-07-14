package com.crossengage.model;

import com.crossengage.controller.GenericVisitable;

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
    private final Set<GenericVisitable> genericVisitableSet;

    public User(
        final Long id,
        final Boolean active,
        final ContactMeans contactMeans,
        final Set<GenericVisitable> genericVisitableSet) {

        this.id = id;
        this.active = active;
        this.contactMeans = contactMeans;
        this.genericVisitableSet = genericVisitableSet != null ?
            genericVisitableSet.stream().filter(cp -> cp != null)
            .collect(Collectors.toSet()) : genericVisitableSet;
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

    public Set<GenericVisitable> getGenericVisitablesSet() {
        return genericVisitableSet;
    }

    public boolean isValid() {
        if (active && genericVisitableSet != null && genericVisitableSet.size() >= 1)
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

        return genericVisitableSet != null ?
            genericVisitableSet.equals(user.genericVisitableSet) :
            user.genericVisitableSet == null;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + active.hashCode();
        result = 31 * result + contactMeans.hashCode();
        result = 31 * result + (genericVisitableSet != null ? genericVisitableSet.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", active=" + active +
            ", contactMeans=" + contactMeans +
            ", genericVisitableSet=" + genericVisitableSet +
            '}';
    }

    public static User getUserForStrings(String[] fields) {
        return new User(
            Long.valueOf(fields[0]),
            Boolean.valueOf(fields[1]),
            ContactMeans.valueOf(fields[2]),
            new HashSet<GenericVisitable>(
                Arrays.asList(
                    ContactPointFactory.getContactForData(fields[3]),
                    ContactPointFactory.getContactForData(fields[4])
                )
            )
        );
    }
}
