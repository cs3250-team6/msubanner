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
    private long id;

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
        try {
            this.firstName = "First_Name";
            this.lastName = "Last_Name";
        }
        catch (Exception e){
            System.out.println("Something went wrong...");
        }
    }

    /**
     * Contructor
     * @param firstName User's first name
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
    public String getFirstName() throws Exception {

        if (firstName != "")
            return firstName;
        else
            throw new Exception("First name cannot be blank!");
    }

    /**
     * Returns the last name of the User.
     * @return last name
     */
    public String getLastName()throws Exception {
        if (lastName != "")
            return lastName;
        else
            throw new Exception("Last name cannot be blank!");
    }

    /**
     * Returns the id number of the User.
     * @return id
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the user's ID
     * @param id new ID number
     * @throws Exception
     */
	public void setId(long id) throws Exception {
        if (id != 0)
            this.id = id;
        else throw new Exception("Invalid Id");
	}

    /**
     * Sets the user's first name
     * @param firstName New first name
     */
	public void setFirstName(String firstName) {

        if (firstName != "")
            this.firstName = firstName;
        else
            this.firstName = "First_Name";
	}

    /**
     * Sets the user's last name
     * @param lastName New last name
     */
	public void setLastName(String lastName) {

        if (lastName != "")
            this.lastName = lastName;
        else
            this.lastName = "Last_Name";
	}
}
