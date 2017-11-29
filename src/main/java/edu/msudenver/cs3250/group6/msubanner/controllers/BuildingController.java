package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.services.BuildingService;
import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * The controller for the building class.
 */
@Controller
public class BuildingController {

    /** The building service. */
    @Autowired
    private BuildingService buildingService;

    /**
     * Gets the list of all buildings.
     *
     * @return the list of all buildings
     */
    @RequestMapping("/buildings")
    public ModelAndView getAllBuildings() {
        ModelAndView mav = new ModelAndView("buildings");
        mav.addObject("allbuildings", buildingService.getAllBuildings());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Gets a building by id number.
     *
     * @param id the building id
     * @return the building
     */
    @RequestMapping("/buildings/getbuilding/{id}")
    public ModelAndView getBuilding(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("showbuilding");
        mav.addObject("building", buildingService.getBuilding(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Adds a building.
     *
     * @param buildingName the building name
     * @return the building
     */
    @RequestMapping(method = RequestMethod.POST,
            value = "/buildings/addbuilding")
    public ModelAndView addBuilding(@RequestParam final String buildingName) {
        Building building = new Building(buildingName);
        buildingService.addBuilding(building);
        ModelAndView mav = new ModelAndView("showbuilding");
        mav.addObject("building", building);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Updates a building.
     *
     * @param buildingName the building name
     * @param id the building's id
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/buildings/updatebuilding/{id}")
    public ModelAndView updateBuilding(@RequestParam final String buildingName,
            @PathVariable final String id) {
        Building building = buildingService.getBuilding(id);
        building.setBuildingName(buildingName);
        buildingService.updateBuilding(building);

        ModelAndView mav = new ModelAndView("showbuilding");
        mav.addObject("building", building);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Deletes a building.
     *
     * @param id the building's id
     * @return the model and view
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/buildings/deletebuilding/{id}")
    public ModelAndView deleteBuilding(@PathVariable final String id) {
        buildingService.deleteBuilding(id);
        ModelAndView mav = new ModelAndView("buildings");
        mav.addObject("allbuildings", buildingService.getAllBuildings());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the edit building form.
     *
     * @param id Id of the building
     * @return ModelAndView containing the building object referenced by id, and
     *         the Global school name
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/buildings/editbuilding/{id}")
    public ModelAndView editBuilding(@PathVariable final String id) {

        ModelAndView mav = new ModelAndView("editbuildingform");
        mav.addObject("building", buildingService.getBuilding(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add building form.
     *
     * @return the add building form string
     */
    @RequestMapping("/buildings/addbuilding")
    public ModelAndView addBuildingForm() {
        ModelAndView mav = new ModelAndView("addbuildingform");
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

}
