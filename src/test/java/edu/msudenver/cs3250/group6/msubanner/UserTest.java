package edu.msudenver.cs3250.group6.msubanner;

import org.junit.Test;
import static org.junit.Assert.*;

public class UserTest {
    @Test
    public void getId() throws Exception{
        User user = new User();
        long id = user.getId();
        assertNotNull(id);
    }

    @Test
    public void setFirstName() throws Exception{
        User user = new User();
        user.setFirstName("test name");
        assertEquals("test name", user.getFirstName());
    }

    @Test
    public void setLastName() throws Exception{
        User user = new User();
        user.setLastName("test name");
        assertEquals("test name", user.getLastName());
    }
    @Test
    public void setId() throws Exception {
        User user = new User();
        user.setId(99999);
        assertEquals(99999, user.getId());
    }
    @Test
    public void getFirstName() throws Exception{
        User user = new User("test name", "");
        assertEquals("test name", user.getFirstName());
    }

    @Test
    public void getLastName() throws Exception{
        User user = new User("","test name");
        assertEquals("test name", user.getLastName());
    }

    @Test
    public void testUser() throws Exception{
        User user = new User();
        assertEquals("Last_Name", user.getLastName());
        assertEquals("First_Name", user.getFirstName());
    }
}