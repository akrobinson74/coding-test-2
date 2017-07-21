package com.someprospectiveemployer.dao;

import com.someprospectiveemployer.model.User;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class UserRepositoryTest {

    @Test
    public void test() throws IOException {
        UserRepository repository = new UserRepository(new File(this.getClass().getResource("/test_user_data.txt").getFile()));
        List<String> emails = repository.getAllEmails();

        assertEquals(5, emails.size());
        System.out.println(emails);
    }

    @Test
    public void testLoad5UserRecords() throws IOException {
        UserRepository repository = new UserRepository(new File(this.getClass().getResource("/test_user_data1.txt").getFile()));
        List<User> userList =
            repository.getValidUsers().limit(5).collect(Collectors.toList());
        assertEquals(5, userList.size());
    }
}
