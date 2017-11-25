package edu.msudenver.cs3250.group6.msubanner.entities;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class DepartmentTest {
    @Test
    public void getDepartmentNameTestDefault() throws Exception {
        Department department = new Department();
        assertEquals("Department Name", department.getDepartmentName() );
    }

    @Test
    public void setIdTest() throws Exception {
        Department department = new Department();
        department.setId("1");
        assertEquals("1", department.getId() );
    }

    @Test
    public void setDepartmentNameTest() throws Exception {
        Department department = new Department();
        department.setDepartmentName("Cars");
        assertEquals("Cars", department.getDepartmentName() );
    }

    @Test
    public void equalsTestTrue() throws Exception {
        Department department = new Department();
        department.setId("1");
        department.setDepartmentName("Cats");

        Department department2 = new Department();
        department2.setId("1");
        department2.setDepartmentName("Cats");

        Assert.assertTrue(department.equals(department2) && department2.equals(department));
    }

    @Test
    public void equalsTestFalseById() throws Exception {
        Department department = new Department();
        department.setId("1");
        department.setDepartmentName("Cats");

        Department department2 = new Department();
        department2.setId("2");
        department2.setDepartmentName("Cats");

        assertEquals(false, department.equals(department2));
    }


    @Test
    public void equalsTestFalseByName() throws Exception {
        Department department = new Department();
        department.setId("1");
        department.setDepartmentName("Cats");

        Department department2 = new Department();
        department2.setId("1");
        department2.setDepartmentName("Cars");

        assertEquals(false, department.equals(department2));
    }

    @Test
    public void hashCodeTest() throws Exception {
        Department department = new Department();
        department.setId("1");
        department.setDepartmentName("Cats");

        Department department2 = new Department();
        department2.setId("1");
        department2.setDepartmentName("Cats");

        Assert.assertTrue(department.hashCode() == department2.hashCode());
    }

    @Test
    public void toStringTest() throws Exception {
        Department department = new Department();
        department.setId("1");
        department.setDepartmentName("Cats");

        assertEquals("Department{id='1', myDepartmentName='Cats'}", department.toString());
    }
}
