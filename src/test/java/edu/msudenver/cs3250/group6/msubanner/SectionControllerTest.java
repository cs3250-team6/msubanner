package edu.msudenver.cs3250.group6.msubanner;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * References:
 * www.bytestree.com/spring/restful-web-services-unit-testing-spring-boot/
 * memorynotfound.com/unit-test-spring-mvc-rest-service-junit-mockito/
 */

public class SectionControllerTest {
/*
    private MockMvc mockMvc;

    @Mock
    private SectionService sectionService;

    @InjectMocks
    private SectionController sectionController;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(sectionController).build();
    }

    @Test
    public void testUpdateSectionSuccess() throws Exception {
        Course course = new Course();
        User prof = new User("Mr.", "Meseeks");
        Section section = new Section(course, prof);

        when(sectionService.getSection(section.getId())).thenReturn(section);
        doNothing().when(sectionService).updateSection(section);

        mockMvc.perform(put("/sections/updatesection/{id}", section.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(asJsonString(section))).andExpect(status().isOk());

        verify(sectionService, times(1)).getSection(section.getId());
        verify(sectionService, times(1)).updateSection(section);
        verifyNoMoreInteractions(sectionService);
    }


    @Test
    public void testAddSectionSuccess() throws Exception {

        Course course = new Course();
        User prof = new User("Mr.", "Meseeks");
        Section section = new Section(course, prof);

        when(sectionService.getSection(section.getId())).thenReturn(section);
        doNothing().when(sectionService).addSection(section);

        mockMvc.perform(post("/sections/addsection/{id}", section.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .contentType(asJsonString(section))).andExpect(status().isOk());

        verify(sectionService, times(1)).getSection(section.getId());
        verify(sectionService, times(1)).addSection(section);
        verifyNoMoreInteractions(sectionService);
    }

    @Test
    public void testDeleteSectionSuccess() throws Exception {

        Course course = new Course();
        User prof = new User("Mr.", "Meseeks");
        Section section = new Section(course, prof);

        when(sectionService.getSection(section.getId())).thenReturn(section);
        doNothing().when(sectionService).deleteSection(section.getId());

        mockMvc.perform(post("/sections/deletesection/{id}", section.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .contentType(asJsonString(section))).andExpect(status().isOk());

        verify(sectionService, times(1)).getSection(section.getId());
        verify(sectionService, times(1)).deleteSection(section.getId());
        verifyNoMoreInteractions(sectionService);
    }

    @Test
    public void testReadSectionSuccess() throws Exception {

        Course course = new Course();
        User prof = new User("Mr.", "Meseeks");
        Section section = new Section(course, prof);

        when(sectionService.getSection(section.getId())).thenReturn(section);
        doNothing().when(sectionService).deleteSection(section.getId());

        mockMvc.perform(post("/sections/getsection/{id}", section.getId())
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .contentType(asJsonString(section))).andExpect(status().isOk());

        verify(sectionService, times(1)).getSection(section.getId());
        verify(sectionService, times(1)).deleteSection(section.getId());
        verifyNoMoreInteractions(sectionService);
    }
*/
    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
