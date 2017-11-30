package edu.msudenver.cs3250.group6.msubanner.controllers;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.junit.Assert.*;

public class HomeControllerTest {
    public HomeController controller = new HomeController();

    @Test
    public void testIndex() {
        ModelAndView mav = controller.index();
        assertEquals("index", mav.getViewName());
    }

    @Test
    public void testAddDepartmentForm() {
        ModelAndView mav = controller.addDepartmentForm();
        assertEquals("adddepartmentform", mav.getViewName());
    }

}