package edu.msudenver.cs3250.group6.msubanner;

import javax.persistence.*;

/**
 * Persistent Section class.
 *
 */
@Entity
@Table(name = "sections")
public class Section {

    /**
     * Section's Id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    /**
     * Course this section belongs to.
     */
    @ManyToOne
    private Course course;

    /**
     * Section's professor.
     */
    @ManyToOne
    private User professor;

    /**
     * Default contstructor, creates a blank section.
     */
    public Section() {
        this.professor = new User();
        this.course = new Course();
    }

    /**
     * Creates a new section and instantiates the course and professor fields.
     * @param course The course that this section belongs to
     * @param professor The professor for this section
     */
    public Section(final Course course, final User professor) {
        if (course != null) this.course = course;
        if (professor != null) this.professor = professor;
    }

    /**
     * Returns the course id number.
     * @return id of this course
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the section id number.
     * @param id new id number for this section
     */
    public void setId(final long id) {
        if (id != 0) this.id = id;
    }

    /**
     * Returns the course this section belongs to.
     * @return course this section belongs to
     */
    public Course getCourse() {
        return course;
    }

    /**
     * Sets the course this section belongs to.
     * @param course new course for this section
     */
    public void setCourse(final Course course) throws IllegalArgumentException {
        if (course == null)
            throw new IllegalArgumentException("Course cannot be null!");

        this.course = course;
    }

    /**
     * Returns the professor of this section.
     * @return the professor of this section
     */
    public User getProfessor() {
        return professor;
    }

    /**
     * Sets the professor of this section.
     * @param professor new professor for this section
     */
    public void setProfessor(final User professor) throws IllegalArgumentException {
        if (professor == null) {
            throw new IllegalArgumentException("Professor cannot be null!");
        }
        this.professor = professor;
    }

    /**
     * Hash code function
     * @return some integer
     */

    @Override
    public int hashCode() {
        return (int) (getId() ^ (getId() >>> 32));
    }

    /**
     * Returns the Section as a nice, readable string.
     * @return The Section as a nice, readable string.
     */
    @Override
    public String toString() {
        return "Section{" + "id=" + id + ", Course="
                + /*course.toString() +*/ ", professor:"
                + professor.toString() + '}';
    }
}

