package edu.msudenver.cs3250.group6.msubanner;

import org.junit.Test;

import static org.junit.Assert.*;

public class SectionTest {

    @Test
    public void sectionTest() throws Exception {
        Section section = new Section();

    }

    @Test
    public void sectionWithArgsTest() throws Exception {
        Course course = new Course();
        User prof = new User("Dr.", "Meseeks");
        Section section = new Section(course, prof);
        assertNotNull(course);
        assertNotNull(prof);
    }

    @Test
    public void getId() throws Exception {
        Section section = new Section();
        assertNotNull(section.getId());
    }

    @Test
    public void setId() throws Exception {
        Section section = new Section();
        section.setId(99);
        assertEquals(99, section.getId());
    }

    @Test
    public void getProfessor() throws Exception {
        Course course = new Course();
        User prof = new User();
        Section section = new Section(course, prof);
        assertEquals(prof, section.getProfessor());
    }

    @Test
    public void setProfessor() throws Exception {
        Course course = new Course();
        User prof = new User();
        Section section = new Section();
        section.setProfessor(prof);
        assertEquals(prof, section.getProfessor());
    }

    @Test
    public void setCourseTest() throws Exception {
        Course course = new Course();
        User prof = new User();
        Section section = new Section();
        section.setCourse(course);
        assertEquals(course, section.getCourse());
    }

    @Test
    public void getCourseTest() throws Exception {
        Course course = new Course();
        User prof = new User();
        Section section = new Section(course, prof);
        assertEquals(course, section.getCourse());
    }

    @Test
    public void hashTest() throws Exception {
        Section section = new Section();
        assertEquals(0, section.hashCode());
    }

    @Test
    public void toStringTest() throws Exception {
        Course course = new Course();
        User prof = new User("Mr.", "Meseeks");
        Section section = new Section(course, prof);
        String out = "Section{" + "id=" + section.getId() + ", Course=" + /*course.toString() +*/ ", professor:" + prof.toString() + '}';
        assertEquals(out, section.toString());
    }
}