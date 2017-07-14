package com.crossengage.dao;

import com.crossengage.model.User;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class UserRepository {

    private File data;

    public UserRepository(File data) {
        this.data = data;
    }

    public List<String> getAllEmails() throws IOException {
        return Files.lines(data.toPath())
                .skip(1)
                .map(line ->
                    line.substring(line.indexOf(',', 8)+1,
                        line.lastIndexOf(',')))
                .collect(Collectors.toList());
    }

    public Stream<User> getValidUsers() throws IOException {
        return Files.lines(data.toPath())
            .skip(1)
            .map(line -> line.split(","))
            .map(fields -> User.getUserForStrings(fields))
            // filter out inactive User objects
            .filter(user -> user != null && user.isValid())
            .collect(Collectors.toList())
            .stream();
    }
}
