package com.crossengage;

import com.crossengage.controller.EmailTransmitter;
import com.crossengage.controller.GenericContactPointVisitor;
import com.crossengage.controller.SMSTransmitter;
import com.crossengage.dao.UserRepository;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Function;
import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    private static final Logger LOGGER;
    private static final Collection<GenericContactPointVisitor>
        CONTACT_POINT_VISITORS = getContactPointVisitors();

    static {
        LOGGER = Logger.getLogger("App");
        LOGGER.setLevel(Level.SEVERE);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("START: " + LocalDateTime.now());

        UserRepository repository = new UserRepository(new File(args[0]));

        repository.getAllValidUsers().forEach(

            user -> {

                user.getAcceptsVisitors().stream().filter(cp -> cp != null).forEach(

                    contactPoint -> {
                        /*
                        Using visitors to transmit correspondence allow for the
                        communication channels to grow as they must only
                        implement the same interface and a natural
                         */
                        for (GenericContactPointVisitor visitor : CONTACT_POINT_VISITORS) {

                            Function<String, Boolean> visitableClosure =
                                contactPoint.accept(visitor, user);

                            if (visitableClosure != null ||
                                !(visitableClosure.apply("Welcome to the System!"))) {
                                LOGGER.log(Level.WARNING,
                                    String.format("User [%d] doesn't support a ContactPoint of type [%s]",
                                        user.getId(),
                                        visitor.getClass().getName())
                                );
                            }
                        }
                    }

                );

            }

        );

        System.out.println("END:   " + LocalDateTime.now());

    }

    private static Collection<GenericContactPointVisitor> getContactPointVisitors() {
        return Arrays.asList(
            new EmailTransmitter(),
            new SMSTransmitter()
        );
    }
}
