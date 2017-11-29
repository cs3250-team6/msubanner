package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.ClassLevel;
import edu.msudenver.cs3250.group6.msubanner.entities.Department;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseControllerTest {

    @Autowired
    private CourseController controller;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testGetAllCourses() {
        ModelAndView ret = controller.getAllCourses();
        assertThat("courses".equals(ret));
    }

    /*@Test
    public void testCourseById() {
        ModelAndView mav = controller.getCourse("0");
        assertThat("showcourse".equals(mav));
    }*/

    @Test
    public void testAddCourse() {
        ModelAndView mav = controller.addCourse("Name", "Desc", 4,
                "Obj", ClassLevel.FRESHMAN, new Department());
        assertThat("showcourse".equals(mav));
    }


    @Test
    public void testUpdateCourse() {
        ModelAndView mav = controller.updateCourse("title", "desc", 4,
                "obj", ClassLevel.FRESHMAN, new Department(), "4250");
        assertThat(mav.getViewName().equals("showcourse"));
    }



    @Test
    public void testDeleteCourse() {
        ModelAndView mav = controller.deleteCourse("4250");
        assertThat("courses".equals(mav));
    }

    @Test
    public void testEditCourse() {
        ModelAndView mav = controller.editCourse("4250");
        assertThat("editcourseform".equals(mav));

    }

    @Test
    public void testAddCourseForm() {
        ModelAndView mav = controller.addCourseForm();
        assertThat("addcourseform".equals(mav));
    }
}