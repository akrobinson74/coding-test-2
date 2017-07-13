package com.crossengage;

import com.crossengage.dto.AcceptsVisitors;
import com.crossengage.dto.EmailAddress;
import com.crossengage.dto.SMSNumber;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class ContactPointFactory {
    private static final Logger LOGGER =
        Logger.getLogger("ContactPointFactory");


    public static AcceptsVisitors getContactForData(String data) {
        AcceptsVisitors acceptsVisitors = null;

        if (data.matches("^.+@.+\\..+$"))
            acceptsVisitors = new EmailAddress(data);
        else if (data.matches("^\\+\\d+$"))
            acceptsVisitors = new SMSNumber(data);
        else
            LOGGER.log(Level.WARNING,
                "Unknown or invalid contact data: " + data);

        return acceptsVisitors;
    }
}
