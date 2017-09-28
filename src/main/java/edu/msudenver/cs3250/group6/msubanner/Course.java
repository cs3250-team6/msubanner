package edu.msudenver.cs3250.group6.msubanner;

import javax.persistence.*;

/*
    This is just a fake class to allow for testing of Section class

    Move along, nothing to see here....
 */
@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String title;

    public Course() {
        this.title = "Empty title";
    }

    public Course(String title) {
        this.title = title;
    }
}
