package edu.msudenver.cs3250.group6.msubanner;

import javax.persistence.*;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Table;

/**
 * Persistent User class.
 * @author Group 6
 */
@Entity 
@Table(name = "users")
public class User {

    /**
     * User's id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    /**
     * User's first name.
     */
    @Column
    private String firstName;

    /**
     * User's last name.
     */
    @Column
    private String lastName;

    // default constructor
    public User() {
        this.firstName = "First_Name";
        this.lastName = "First_Name";
    }

    /**
     * Contructor
     * @param firstName User's firat name
     * @param lastName User's last name
     */
    public User (String firstName, String lastName) {
		super();
		//this.id = id;
        if (firstName != "")
		    this.firstName = firstName;
        else
            this.firstName = "First_Name";

        if (lastName != "")
		    this.lastName = lastName;
        else
            this.lastName = "Last_Name";
	}

    /**
     * Returns the first name of the User.
     * @return first name
     */
    public String getFirstName() {

        return firstName;
    }

    /**
     * Returns the last name of the User.
     * @return last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Returns the id number of the User.
     * @return id
     */
    public int getId() {
        return id;
    }
    
	public void setId(int id) throws Exception {
        if (id != 0)
            this.id = id;
        else throw new Exception("Invalid Id");
	}

	public void setFirstName(String firstName) {

        if (firstName != "")
            this.firstName = firstName;
        else
            this.firstName = "First_Name";
	}

	public void setLastName(String lastName) {

        if (lastName != "")
            this.lastName = lastName;
        else
            this.lastName = "Last_Name";
	}
}
