package edu.msudenver.cs3250.group6.msubanner;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class UserControllerTest {
    @Test
    public void createUser(){
        User user1 = new User("123","Jesus","Torres");
        UserController controller = new UserController();
        controller.addUser(user1);
        assertThat(controller.getUser("123"), is(user1));
    }
}