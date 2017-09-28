package edu.msudenver.cs3250.group6.msubanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    public List<Section> getAllSections() {
        List<Section> sections = new ArrayList<>();
        // populate the section list with each element in the repository
        sectionRepository.findAll().forEach(sections::add);
        return sections;
    }

    /**
     * Gets a section by id.
     * @param id the section id
     * @return the section
     */
    public Section getSection(final long id) {
        return sectionRepository.findOne(id);
    }

    /**
     * Adds a section.
     * @param section the section to add
     */
    public void addSection(final Section section) {
        // out of the box save method to db
        sectionRepository.save(section);
    }

    /**
     * Updates a section.
     * @param section the section to update
     */
    public void updateSection(final Section section) {
        sectionRepository.save(section);
    }

    /**
     * Deletes a section.
     * @param id the section id
     */
    public void deleteSection(final long id) {
        sectionRepository.delete(id);
    }
}
