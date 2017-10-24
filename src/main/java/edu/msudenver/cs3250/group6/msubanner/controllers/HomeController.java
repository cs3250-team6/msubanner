package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.ClassLevel;
import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.services.BuildingService;
import edu.msudenver.cs3250.group6.msubanner.services.CourseService;
import edu.msudenver.cs3250.group6.msubanner.services.DepartmentService;
import edu.msudenver.cs3250.group6.msubanner.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/*
 *  The purpose here is to get a mapping to the index.html in templates
 *  from: https://spring.io/blog/2016/11/21
 *          /the-joy-of-mustache-server-side-templates-for-the-jvm
 *        https://springframework.guru
 *          /spring-boot-web-application-part-2-using-thymeleaf/
 */

/**
 * Controller for mapping to index.html home page.
 */
@Controller
class HomeController {


    @Autowired
    private CourseService courseService;


    @Autowired
    private UserService userService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private BuildingService buildingService;

    /**
     * Maps the home page to index.html.
     *
     * @return the index string
     */
    @RequestMapping("/")
    ModelAndView index() {
        ModelAndView mav = new ModelAndView("index");
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add user form.
     *
     * @return the add user form string
     */
    @RequestMapping("/users/adduser")
    String addUserForm() {
        return "adduserform";
    }

    /**
     * Maps to the add department form.
     *
     * @return the add department form string
     */
    @RequestMapping("/departments/adddepartment")
    ModelAndView addDepartmentForm() {
        ModelAndView mav = new ModelAndView("adddepartmentform");
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add course form.
     *
     * @return the add course form string
     */
    @RequestMapping("/courses/addcourse")
    ModelAndView addCourseForm() {
        ModelAndView mav = new ModelAndView("addcourseform");
        mav.addObject("prereqs", ClassLevel.values());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add section form.
     *
     * @return the add section form string
     */
    @RequestMapping("sections/addsection")
    ModelAndView addSectionForm() {
        ModelAndView mav = new ModelAndView("addsectionform");
        mav.addObject("allcourses", courseService.getAllCourses());
        mav.addObject("allprofs", userService.getAllUsers());

        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add building form.
     *
     * @return the add building form string
     */
    @RequestMapping("/buildings/addbuilding")
    String addBuildingForm() {
        return "addbuildingform";
    }

    /**
     * Maps to the add room form.
     *
     * @return the add room form string
     */
    @RequestMapping("/rooms/addroom")
    ModelAndView addRoomForm() {
        ModelAndView mav = new ModelAndView("addroomform");
        mav.addObject("allbuildings", buildingService.getAllBuildings());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

}
