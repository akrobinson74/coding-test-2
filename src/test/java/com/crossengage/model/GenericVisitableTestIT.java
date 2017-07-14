package com.crossengage.model;

import com.crossengage.controller.EmailTransmitter;
import com.crossengage.controller.GenericContactPointVisitor;
import com.crossengage.controller.SMSTransmitter;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.function.Function;

/**
 *
 */
public class GenericVisitableTestIT {
    private static final GenericContactPointVisitor<EmailAddress> EMAIL_TRANSMITTER =
        new EmailTransmitter();
    private static final GenericContactPointVisitor<SMSNumber> SMS_TRANSMITTER =
        new SMSTransmitter();
    private static final ByteArrayOutputStream OUTPUT_STREAM =
        new ByteArrayOutputStream();
    private static final ByteArrayOutputStream OUTPUT_STREAM1 =
        new ByteArrayOutputStream();

    private User testUser;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Before
    public void setup() {
        System.setOut(new PrintStream(OUTPUT_STREAM));

        testUser = new User(1L, true, ContactMeans.email,
            new HashSet<>(Arrays.asList(new EmailAddress("a@b.com")))
        );
    }

    @Test
    public void testAccept() {
        EmailAddress emailAddress = new EmailAddress("a@b.com");
        SMSNumber smsNumber = new SMSNumber("+9999999999");

        Function<String, Boolean> visitClosure =
            emailAddress.accept(EMAIL_TRANSMITTER, testUser);
        Assert.assertNotNull("emailAddress.accept() returns a non-null value", visitClosure);

        Boolean result = visitClosure.apply("Hallo to you!");
        Assert.assertEquals(true, result);
        Assert.assertEquals("Sending Email to User [1] at [a@b.com] with text: Hallo to you!\n", OUTPUT_STREAM.toString());

        visitClosure = smsNumber.accept(SMS_TRANSMITTER, testUser);
        Assert.assertNotNull("smsAddress.accept() returns a non-null value", visitClosure);

        System.setOut(new PrintStream(OUTPUT_STREAM1));
        result = visitClosure.apply("Blah, Blah, Blah!");
        Assert.assertEquals(false, result);
        Assert.assertEquals("", OUTPUT_STREAM1.toString());
    }
}
