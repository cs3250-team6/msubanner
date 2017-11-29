package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.controllers.BuildingController;
import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import edu.msudenver.cs3250.group6.msubanner.services.BuildingService;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BuildingControllerTest {

    @Autowired
    private BuildingController controller;

    @Mock
    private Model mockModel;

    @Test
    public void contextLoads() throws Exception {
        assertThat(controller).isNotNull();
    }

    @Test
    public void testGetAllBuildings() {
        ModelAndView ret = controller.getAllBuildings();
        assertThat("buildings".equals(ret));
    }

    @Test
    public void testBuildingById() {
        ModelAndView mav = controller.getBuilding("0");
        assertThat("showbuilding".equals(mav));
    }

    @Test
    public void testAddBuilding() {
        ModelAndView mav = controller.addBuilding("Name");
        assertThat("showbuilding".equals(mav));
    }


    @Test
    public void testUpdateBuilding() {
        ModelAndView mav = controller.updateBuilding("0", "1488");
        controller.updateBuilding("Test", "1488");
        assertThat(mav.getViewName().equals("showbuilding"));
    }



    @Test
    public void testDeleteBuilding() {
        ModelAndView mav = controller.deleteBuilding("0");
        assertThat("buildings".equals(mav));
    }

    @Test
    public void testEditBuilding() {
        ModelAndView mav = controller.editBuilding("0");
        assertThat("editbuildingform".equals(mav));

    }

    @Test
    public void testAddBuildingForm() {
        ModelAndView mav = controller.addBuildingForm();
        assertThat("addbuildingform".equals(mav));
    }
}