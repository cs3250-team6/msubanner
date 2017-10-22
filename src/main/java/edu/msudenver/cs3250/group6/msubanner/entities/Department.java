package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Persistent Department class.
 */
@Entity
@Table(name = "department")
public class Department {

    /** Department Id. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long myId;

    /** Department name. */
    @Column
    private String myDepartmentName;

    /** Default constructor for user class. */
    public Department() {
        this.myDepartmentName = "Department Name";
    }

    /**
     * Constructor.
     *
     * @param departmentName the department name
     */
    public Department(final String departmentName) {
        if (myDepartmentName == null || myDepartmentName.equals("")) {
            myDepartmentName = "Department Name";
        } else {
            myDepartmentName = departmentName;
        }
    }

    /**
     * Returns the name of the Department.
     *
     * @return Department name
     */
    public String getDepartmentName() {
        return myDepartmentName;
    }

    /**
     * Returns the department id.
     *
     * @return Department id
     */
    public Long getId() {
        return myId;
    }

    /**
     * Sets the department name.
     *
     * @param name name to set department name to
     */
    public void setDepartmentName(final String name) {
        myDepartmentName = name;
    }

    /**
     * Sets the department's ID.
     *
     * @param id ID to assign to the department
     */
    public void setId(final long id) {
        myId = id;
    }

    // TODO: add setters and equals, hashcode, tostring for testing
}