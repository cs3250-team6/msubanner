package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.ClassLevel;
import edu.msudenver.cs3250.group6.msubanner.entities.Department;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CourseControllerTest {

    CourseController controller = new CourseController();

    @Test
    public void contextLoads() {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testGetAllCourses() {
        ModelAndView mav = controller.getAllCourses();
        assertThat("allcourses".equals(mav.toString()));
    }

    @Test
    public void testCourseById() {
        ModelAndView mav = controller.getCourse("4250");
        assertThat("showcourse".equals(mav.getViewName()));
    }

    @Test
    public void testAddCourse() {
        ModelAndView mav = controller.addCourse("title", "description", 4,
                "obj", ClassLevel.FRESHMAN, new Department());
        assertThat("showcourse".equals(mav));
    }


    @Test
    public void testUpdateCourse() {
        ModelAndView mav = controller.updateCourse("title", "description", 4,
                "obj", ClassLevel.FRESHMAN, new Department(), "4250");
        controller.updateCourse("Title", "Description", 2,
                "Obj", ClassLevel.FRESHMAN, new Department(), "4250");
        assertThat(mav.getViewName().equals("showcourse"));
    }



    @Test
    public void testDeleteCourse() {
        ModelAndView mav = controller.deleteCourse("0");
        assertThat("courses".equals(mav));
    }

    @Test
    public void testEditCourse() {
        ModelAndView mav = controller.editCourse("0");
        assertThat("editcourseform".equals(mav));

    }

    @Test
    public void testAddCourseForm() {
        ModelAndView mav = controller.addCourseForm();
        assertThat("addcourseform".equals(mav));
    }

}