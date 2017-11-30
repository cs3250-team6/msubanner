package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;

public class RoomControllerTest {

    public RoomController controller = new RoomController();

    @Test
    public void testGetAllRooms() {
        ModelAndView mav = controller.getAllRooms();
        assertEquals("rooms", mav.getViewName());
        //assertEquals(Global.SCHOOL_NAME, mav.getModel().toString());
    }

}