package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Course;
import edu.msudenver.cs3250.group6.msubanner.entities.Section;
import edu.msudenver.cs3250.group6.msubanner.entities.User;
import edu.msudenver.cs3250.group6.msubanner.services.CourseService;
import edu.msudenver.cs3250.group6.msubanner.services.SectionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * The controller for the section class.
 */
@Controller
public class SectionController {

    /** The section service. */
    @Autowired
    private SectionService sectionService;

    /**
     * Gets the list of all sections.
     *
     * @return the list of all sections
     */
    @RequestMapping("/sections")
    public ModelAndView getAllSections() {
        ModelAndView mav = new ModelAndView("sections");
        mav.addObject("allsections", sectionService.getAllSections());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Gets a section by id number.
     *
     * @param id the section id
     * @return the section
     */
    @RequestMapping("/sections/getsection/{id}")
    public ModelAndView getSection(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("showsection");
        mav.addObject("section", sectionService.getSection(id));
        return mav;
    }

    /**
     * Adds a section.
     *
     * @param course The course the section belongs to
     * @return the section
     */
    @RequestMapping(method = RequestMethod.POST, value = "/sections/addsection")
    public ModelAndView addSection(@RequestParam final Course course, @RequestParam final User professor) {
        Section section = new Section(course, professor);

        System.out.println("Adding section " + course.getTitle() + " Taught by " + professor.getLastName() + ", " + professor.getFirstName());
        sectionService.addSection(section);


        ModelAndView mav = new ModelAndView("sections");
        mav.addObject("allsections", sectionService.getAllSections());
        return mav;
    }

    /**
     * Updates a section.
     *
     * @param id the section's id
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/sections/updatesection/{id}")
    public ModelAndView updateSection(@RequestParam final Course course, final User professor,
            @PathVariable final String id) {
        Section section = sectionService.getSection(id);
        section.setCourse(course);
        section.setProfessor(professor);
        sectionService.updateSection(section);
        ModelAndView mav = new ModelAndView("showsection");
        mav.addObject("section", section);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add section form.
     * @param id the id of the section
     * @return ModelAndView containing the selected section
     */
    @RequestMapping("/sections/editsection/{id}")
    public ModelAndView editSection(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("editsectionform");
        mav.addObject("section", sectionService.getSection(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Deletes a section.
     *
     * @param id the section's id
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/sections/deletesection/{id}")
    public String deleteSection(@PathVariable final String id) {
        sectionService.deleteSection(id);
        return "redirect:/sections/";
    }
}
