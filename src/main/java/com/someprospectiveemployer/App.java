package com.someprospectiveemployer;

import com.someprospectiveemployer.controller.EmailTransmitter;
import com.someprospectiveemployer.controller.GenericContactPointVisitor;
import com.someprospectiveemployer.controller.SMSTransmitter;
import com.someprospectiveemployer.dao.UserRepository;

import java.io.File;
import java.io.IOException;
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
        LOGGER.setLevel(Level.WARNING);
    }

    public static void main(String[] args) throws IOException {

        UserRepository repository = new UserRepository(new File(args[0]));

        repository.getValidUsers().forEach(

            user -> {

                user.getGenericVisitablesSet().stream().filter(cp -> cp != null).forEach(

                    contactPoint -> {
                        /*
                        Using visitors to transmit correspondence allow for the
                        communication channels to grow as they must only
                        implement the same interface and a natural
                         */
                        for (GenericContactPointVisitor visitor : CONTACT_POINT_VISITORS) {

                            try {
                                Function<String, Boolean> visitableClosure =
                                    contactPoint.accept(visitor, user);
                                visitableClosure
                                    .apply("Welcome to the System!");
                            }
                            catch (Exception e) {
                                LOGGER.log(Level.WARNING,
                                    String.format("User [%d] doesn't support a ContactPoint of type [%s]: %s",
                                        user.getId(),
                                        visitor.getClass().getName(),
                                        e.getMessage())
                                );
                            }

                        }
                    }

                );

            }

        );

    }

    private static Collection<GenericContactPointVisitor> getContactPointVisitors() {
        return Arrays.asList(
            new EmailTransmitter(),
            new SMSTransmitter()
        );
    }
}
