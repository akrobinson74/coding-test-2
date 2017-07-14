package com.crossengage.model;

import com.crossengage.controller.GenericVisitable;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 */
public class ContactPointFactory {
    private static final Logger LOGGER =
        Logger.getLogger("ContactPointFactory");


    public static GenericVisitable getContactForData(String data) {
        GenericVisitable genericVisitable = null;

        if (data.matches("^[^@]+@[^@]+\\.[^@]+$"))
            genericVisitable = new EmailAddress(data);
        else if (data.matches("^\\+\\d+$"))
            genericVisitable = new SMSNumber(data);
        else
            LOGGER.log(Level.WARNING,
                "Unknown or invalid contact data: " + data);

        return genericVisitable;
    }
}
