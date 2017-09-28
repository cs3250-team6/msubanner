package edu.msudenver.cs3250.group6.msubanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SectionController {

    /** The section service.*/
    @Autowired
    private SectionService sectionService;

    /**
     * Gets the list of all sections.
     * @return the list of all sections
     */
    @RequestMapping("/sections")
    public List<Section> getAllSections() {
        return sectionService.getAllSections();
    }

    /**
     * Gets a section by id number.
     * @param id the section id
     * @return the section
     */
    @RequestMapping("/sections/getsection/{id}")
    //@PathVariable indicates use of {id} wildcard above
    public Section getSection(@PathVariable final long id) {
        return sectionService.getSection(id);
    }

    /**
     * Adds a section.
     * @param section the section to be added
     */
    @RequestMapping(method = RequestMethod.POST, value = "/sections/addsection")
    // take request body, turn into Section instance and pass to addSection()
    public void addSection(@RequestBody final Section section) {
        // POST body should contain object being sent
        sectionService.addSection(section);
    }

    /**
     * Updates a section.
     * @param section the section to be updated
     * @param id the section's id
     */
    @RequestMapping(method = RequestMethod.PUT, value = "/sections/updatesection/{id}")
    // take request body, turn into Section instance and pass to addSection()
    public void updateSection(@RequestBody final Section section,
                           @PathVariable final long id) {
        // POST body should contain object being sent
        sectionService.updateSection(section);
    }

    /**
     * Deletes a section.
     * @param id the section's id
     */
    @RequestMapping(method = RequestMethod.DELETE, value = "/sections/deletesection/{id}")
    public void deleteSection(@PathVariable final long id) {
        //@PathVariable indicates use of wildcard above
        sectionService.deleteSection(id);
    }
}
