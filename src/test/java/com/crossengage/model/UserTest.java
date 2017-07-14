package com.crossengage.model;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 */
public class UserTest {
    @Test
    public void testConstructor() {
        User u1 = new User(null, null, null, null);
        Assert.assertTrue("Supports all null args constructor call",
            u1 != null);
    }

    @Test
    public void testNullContactPoint() {
        User u1 = new User(1L, true, ContactMeans.all, new HashSet<>(Arrays.asList(ContactPointFactory.getContactForData(":-)"))));
        // unrecognized contactPoint gets filtered
        Assert.assertTrue("No valid input results in a null Set<GenericVisitable> field", u1.getGenericVisitablesSet() == null);
    }
}
