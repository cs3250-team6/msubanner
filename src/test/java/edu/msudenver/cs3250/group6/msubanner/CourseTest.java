package edu.msudenver.cs3250.group6.msubanner;

import org.junit.Test;

import static org.junit.Assert.*;

public class CourseTest {

    // setId should never be used, so this is fine
    @Test
    public void setIdSetIdTest() {
        Course course = new Course();
        course.setId(-1);
        assertEquals(-1, course.getId());
    }

    @Test
    public void setTitleGetTitleTest() {
        Course course = new Course();
        course.setTitle("Test title");
        assertEquals("Test title", course.getTitle());
    }

    @Test
    public void setDescriptionGetDescriptionTest() {
        Course course = new Course();
        course.setDescription("Test description");
        assertEquals("Test description", course.getDescription());
    }

    @Test
    public void equals() {
        Course course = new Course("Test title", "Test description");
        Course course2 = course;
        assertEquals(course, course2);
    }

    @Test
    public void defaultConstructorTest() {
        Course course = new Course();
        assertEquals("Empty title", course.getTitle());
        assertEquals("No description available", course.getDescription());
    }

    @Test
    public void emptyStringInConstructorTest() {
        Course course = new Course("", "");
        assertEquals("Empty title", course.getTitle());
        assertEquals("No description available", course.getDescription());
    }

    @Test
    public void constructorTest() {
        Course course = new Course("Test title", "Test description");
        assertEquals("Test title", course.getTitle());
        assertEquals("Test description", course.getDescription());
    }

    @Test
    public void toStringTest() {
        Course course = new Course("Test title", "Test description");
        assertEquals("Course{Id=0, Title= Test title, Description= "
                + "Test description}", course.toString());
    }

}