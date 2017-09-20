package edu.msudenver.cs3250.group6.msubanner;

import javax.persistence.Entity;
// import javax.persistence.GeneratedValue;
// import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
// import javax.persistence.Table;

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
    @Id // @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    /**
     * User's first name.
     */
    private String firstName;

    /**
     * User's last name.
     */
    private String lastName;
    
    /**
     * 
     * @param id
     * @param firstName
     * @param lastName
     */
    
    // default constructor
    public User() {
    	
    }
    
	public User (String id, String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
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
    public String getId() {
        return id;
    }
    
	public void setId(String id) {
		this.id = id;
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
}
