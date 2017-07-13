package com.crossengage;

import com.crossengage.dao.UserRepository;
import com.crossengage.dto.ContactPointVisitor;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER = Logger.getLogger("App");
    private static final Collection<ContactPointVisitor>
        CONTACT_POINT_VISITORS = getContactPointVisitors();

    public static void main(String[] args) throws IOException {

        UserRepository repository = new UserRepository(new File(args[0]));

        for (ContactPointVisitor visitor : CONTACT_POINT_VISITORS) {
            repository.getAllValidUsers().forEach(
                user -> {
                    LOGGER.log(Level.WARNING,
                        String.format("User id: %d",
                            user == null ? -1 : user.getId()
                        )
                    );

                    user.getAcceptsVisitors().stream().filter(cp -> cp != null).forEach(
                        contactPoint -> {
                            LOGGER.log(Level.WARNING,
                                String.format("User id: %d, contactPoint: %s",
                                    user.getId(),
                                    contactPoint == null ? "null" :
                                        contactPoint.toString()
                                )
                            );

                            contactPoint.accept(visitor, user)
                                .apply("Welcome to the System!");
                        }
                    );
                }
            );
        }
    }

    private static Collection<ContactPointVisitor> getContactPointVisitors() {
        return Arrays.asList(
            new EmailTransmitter(),
            new SMSTransmitter()
        );
    }
}
