package edu.msudenver.cs3250.group6.msubanner;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CreateUserControllerTest {
    @Test
    public void createUser() throws Exception {
        User user1 = new User("Jesus","Torres");
        user1.setId(123L);
        UserController controller = new UserController();
        controller.addUser(user1);
        assertThat(user1, is(controller.getUser(123L)));
    }
}