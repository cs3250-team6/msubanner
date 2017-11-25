package edu.msudenver.cs3250.group6.msubanner.entities;

import edu.msudenver.cs3250.group6.msubanner.ClassLevel;
import edu.msudenver.cs3250.group6.msubanner.entities.Course;

import static org.junit.Assert.assertEquals;

import edu.msudenver.cs3250.group6.msubanner.entities.Department;
import org.junit.Test;

public class CourseTest {

    // setId should never be used, so this is fine
    @Test
    public void setIdSetIdTest() {
        Course course = new Course();
        course.setId("1");
        assertEquals("1", course.getId());
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
        Course course = new Course("Test title", "Test description", 4,
                "Test objectives", ClassLevel.FRESHMAN, new Department("test"));
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
        Course course = new Course("", "", 0, "",
                ClassLevel.FRESHMAN, new Department("test"));
        assertEquals("Empty title", course.getTitle());
        assertEquals("No description available", course.getDescription());
    }

    @Test
    public void constructorTest() {
        Course course = new Course("Test title", "Test description", 4,
                "Test objectives", ClassLevel.FRESHMAN, new Department("test"));
        assertEquals("Test title", course.getTitle());
        assertEquals("Test description", course.getDescription());
    }

    @Test
    public void toStringTest() {
        Course course = new Course("Test title", "Test description", 4,
                "Test objectives", ClassLevel.FRESHMAN, new Department("test"));
        assertEquals("Course{Id=null, Title= Test title, Description= " + "Test description}", course.toString());
    }

}
