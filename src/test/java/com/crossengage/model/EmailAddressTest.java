package com.crossengage.model;

import com.crossengage.controller.EmailTransmitter;
import com.crossengage.controller.GenericContactPointVisitor;
import com.crossengage.controller.SMSTransmitter;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

/**
 *
 */
public class EmailAddressTest {
    private static final GenericContactPointVisitor<EmailAddress> goodVisitor =
        new EmailTransmitter();
    private static final GenericContactPointVisitor<SMSNumber> badVisitor =
        new SMSTransmitter();
    private User testUser;

    @Before
    public void setup() {
        testUser = new User(1L, true, ContactMeans.email,
            new HashSet<>(Arrays.asList(new EmailAddress("a@b.com")))
        );
    }

    @Test
    public void testAccept() {
        EmailAddress emailAddress = new EmailAddress("a@b.com");
        emailAddress.accept(goodVisitor, testUser);
    }
}
