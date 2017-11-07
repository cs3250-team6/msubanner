package edu.msudenver.cs3250.group6.msubanner.entities;

import javax.persistence.*;

@Entity
public class Professor {
    /**
     * Semester id number.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private long id;
    /**
     * Relationship with sections
     */
    //@OneToMany(mappedBy = "professor")
    //private Section sections;
    /**
     * Professor first name
     */
    @Column(unique = false)
    private String firstName;
    /**
     * Professor last name
     */
    @Column(unique = false)
    private String lastName;

    /**
     * Default constructor, creates blank professor
     */
    public Professor(){}

    /**
     *
     * @param firstname professors first name
     * @param lastname professors last name
     */
    public Professor(String firstname, String lastname){
        this.firstName = firstname;
        this.lastName = lastname;
    }

    /**
     *
     * @return returns sections that professor belongs to
     */
   /* public Section getSections(){
        return sections;
    }
*/
    /**
     *
     * @return returns professors first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName sets professors first name to firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return returns professors last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName sets professors last name to lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
