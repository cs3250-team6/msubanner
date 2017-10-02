package edu.msudenver.cs3250.group6.msubanner;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.concurrent.Callable;

/**
 * Persistent User class.
 */
@Entity
@Table(name = "users")
public class User {

    /** User's id number. */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long myId;

    /** User's first name. */
    @Column
    private String myFirstName;

    /** User's last name. */
    @Column
    private String myLastName;

    /** Class Level for student */
    @Column
    ClassLevel userLevel;

    /** Constant multiplier for hash method. */
    private static final int HASH_MULTIPLIER = 31;

    /** Constant base for hash method. */
    private static final int HASH_BASE = 17;

    /** Default constructor for user class. */
    public User() {
        this.myFirstName = "First_Name";
        this.myLastName = "Last_Name";
        userLevel = ClassLevel.FRESHMAN;
    }

    /**
     * Constructor.
     * @param firstName the user's firat name
     * @param lastName the user's last name
     */
    public User(final String firstName, final String lastName) {
        if (firstName == null || firstName.equals("")) {
            myFirstName = "First_Name";
        } else {
            myFirstName = firstName;
        }
        if (lastName == null || lastName.equals("")) {
            myLastName = "Last_Name";
        } else {
            myLastName = lastName;
        }
        userLevel = ClassLevel.FRESHMAN;
    }

    /**
     * Returns the first name of the User.
     * @return first name
     * @throws Exception if the first name field is blank
     */
    public String getFirstName() {
        return myFirstName;
    }

    /**
     * Returns the last name of the User.
     * @return last name
     * @throws Exception if the last name field is blank
     */
    public String getLastName() {
        return myLastName;
    }

    /**
     * Returns the id number of the User.
     * @return id
     */
    public long getId() {
        return myId;
    }

    /**
     * Sets the user's id.
     * @param id the id number
     */
    public void setId(final long id) {
        if (id > 0) {
            myId = id;
        }
    }

    /**
     * Sets the user's first name.
     * @param firstName the first name
     * @throws IllegalArgumentException if the first name value is null or empty
     */
    public void setFirstName(final String firstName)
            throws IllegalArgumentException {
        if (firstName == null || firstName.equals("")) {
            throw new IllegalArgumentException(
                    "First name must not be empty or null.");
        }
        myFirstName = firstName;
    }

    /**
     * Sets the user's last name.
     * @param lastName the last name
     * @throws IllegalArgumentException if the last name value is null or empty
     */
    public void setLastName(final String lastName)
            throws IllegalArgumentException {
        if (lastName == null || lastName.equals("")) {
            throw new IllegalArgumentException(
                    "Last name must not be empty or null.");
        }
        myLastName = lastName;
    }

    /**
     * Required explanation on how to implement this for classes that extend
     * User.
     */
    @Override
    public boolean equals(final Object other) {
        if (other == null || !(other instanceof User)) {
            return false;
        }
        if (other == this) {
            return true;
        }
        final User otherUser = (User) other;
        return this.getId() == otherUser.getId()
                && this.getFirstName().equals(otherUser.getFirstName())
                && this.getLastName().equals(otherUser.getLastName());
    }

    /**
     * Required explanation on how to implement this for classes that extend
     * User.
     */
    @Override
    public int hashCode() {
        int result = HASH_BASE;
        result = (int) (HASH_MULTIPLIER * result + myId);
        result = HASH_MULTIPLIER * result + myFirstName.hashCode();
        result = HASH_MULTIPLIER * result + myLastName.hashCode();
        return result;
    }

    /**
     * Required explanation on how to implement this for classes that extend
     * User.
     */
    @Override
    public String toString() {
        return "User: " + myFirstName + " " + myLastName + " " + myId;
    }

}
