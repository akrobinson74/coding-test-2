package com.someprospectiveemployer.model;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 */
public class ContactPointFactoryTest {
    @Test
    public void testEmailContactPoints() {
        Assert.assertNotNull("Valid email 1", ContactPointFactory.getContactForData("a@b.com"));
        Assert.assertNotNull("Valid email 2", ContactPointFactory.getContactForData("a@b.co.uk"));
        Assert.assertNotNull("Valid email 3", ContactPointFactory.getContactForData("h.potter@b.co.uk"));


        Assert.assertNull("Invalid email 1", ContactPointFactory.getContactForData("h.potter.b.co.uk"));
        Assert.assertNull("Invalid email 2", ContactPointFactory.getContactForData("h@h.potter@.b.co.uk"));
        Assert.assertNull("Invalid email 2", ContactPointFactory.getContactForData(" "));
    }


    @Test
    public void testSMSContactPoints() {
        Assert.assertNotNull("Valid phone 1", ContactPointFactory.getContactForData("+4917641571993"));
        Assert.assertNotNull("Valid phone 2", ContactPointFactory.getContactForData("+4499999999999"));
        Assert.assertNotNull("Valid phone 3", ContactPointFactory.getContactForData("+4499999999998"));


        Assert.assertNull("Invalid phone 1", ContactPointFactory.getContactForData("123456"));
        Assert.assertNull("Invalid phone 2", ContactPointFactory.getContactForData("+12345ABCD"));
        Assert.assertNull("Invalid phone 2", ContactPointFactory.getContactForData("ABCIsEasyAs123"));
    }
}
