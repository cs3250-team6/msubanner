package edu.msudenver.cs3250.group6.msubanner;

import javax.persistence.*;

/**
 * Persistent Department class.
 */
@Entity
@Table(name= "deparment")
public class Department {
    public static void main(){

    }

    /** Department Id */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long myId;

    /** Department name*/
    @Column
    private String myDepartmentName;

    /** */
    /** Default constructor for user class. */
    public Department(){
        this.myDepartmentName = "Department Name";
    }

    /**
     * Constructor.
     * @param departmentName the department name
     */
    public Department(String departmentName){
        if (myDepartmentName == null || myDepartmentName.equals("")) {
            myDepartmentName = "Department Name";
        } else {
            myDepartmentName = departmentName;
        }
    }
    /**
     * Returns the name of the Department.
     * @return Department name
     * @throws Exception if the first name field is blank
     */
    public String getDepartmentName(){
        return myDepartmentName;
    }

    /**
     * Returns the department id
     * @returns Department id
     * @throws Exception if the department id field is blank
     */
    public Long getId(){
        return myId;
    }
}
