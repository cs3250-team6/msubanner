package edu.msudenver.cs3250.group6.msubanner;

import com.sun.javaws.exceptions.InvalidArgumentException;

import javax.persistence.*;

/**
 * Persistent Course class.
 */
@Entity
@Table(name = "courses")
public class Course {

    /**
     * Course id number
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long myId;

    //todo: Add field for department

    /**
     * Title of the course
     */
    @Column
    private String myTitle;

    /**
     * Description of the course.
     */
    private String myDescription;

    /**
     * Default constructor, initializes fields with default values
     * Directions for use: Do NOT
     */
    public Course() {
        this.myTitle = "Empty title";
        this.myDescription = "No description available";
    }

    /**
     * Constructor
     * @param title Course Title
     * @param description Course description
     */
    public Course(String title, String description) {
        if (title.equals("") || title.equals(" "))
            this.myTitle = "Empty title";
        else this.myTitle = title;

        if (description.equals("") || description.equals(" "))
            this.myDescription = "No description available";
        else this.myDescription = description;
    }

    /**
     * Sets the id of the course.
     * @param id New id for the course
     */
    public void setId(long id) {
        this.myId = id;
    }

    /**
     * Returns the id number of the course.
     * @return id number of the course
     */
    public long getId() {
        return myId;
    }

    /**
     * Sets the title of the course.
     * @param title New title of the course
     * @throws IllegalArgumentException if new title is blank
     */
    public void setTitle(String title) throws IllegalArgumentException {
        if (title.equals("") || title.equals(" "))
            throw new IllegalArgumentException("Ttile cannot be blank!");
        this.myTitle = title;
    }

    /**
     * Returns the title of the course.
     * @return Title of the course
     */
    public String getTitle() {
        return myTitle;
    }

    /**
     * Sets the decription of the course.
     * @param description New description of the course
     */
    public void setDescription(String description) {
        if (description.equals("") || description.equals(" "))
            throw new IllegalArgumentException("Description cannot be blank!");
        this.myDescription = description;
    }

    /**
     * Returns the description of the course.
     * @return Description of the course
     */
    public String getDescription() {
        return myDescription;
    }

    @Override
    public String toString() {
        return "Course{" + "Id=" + myId + ", Title= "
                + myTitle + ", Description= " + myDescription + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;

        Course course = (Course) o;
        if (getId() != course.getId()) return false;
        if (!getTitle().equals(course.getTitle())) return false;
        return getDescription().equals(course.getDescription());
    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + getTitle().hashCode();
        result = 31 * result + getDescription().hashCode();
        return result;
    }
}
