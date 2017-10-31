package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import edu.msudenver.cs3250.group6.msubanner.entities.Room;
import edu.msudenver.cs3250.group6.msubanner.entities.Schedule;
import edu.msudenver.cs3250.group6.msubanner.services.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ScheduleController {

    @Autowired
    private ScheduleService scheduleService;

    @RequestMapping("/schedules")
    public ModelAndView getAllSchedules() {
        ModelAndView mav = new ModelAndView("schedules");
        mav.addObject("allschedules", scheduleService.getAllSchedules());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/schedules/addschedule")
    public ModelAndView addSchedule(@RequestParam final Room room, @RequestParam final Building building, String semester, String startDate, int duration, String days, String hours) {
        Schedule schedule = new Schedule(room, building, semester, startDate, duration, days, hours);
        scheduleService.addSchedule(schedule);

        ModelAndView mav = new ModelAndView("schedules");
        mav.addObject("allschedules", scheduleService.getAllSchedules());

        return mav;
    }

    /**
     * Gets a schedule by id number.
     *
     * @param id the schedule id
     * @return the schedule
     */
    @RequestMapping("/schedules/getSchedule/{id}")
    public ModelAndView getSchedule(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("showschedule");
        mav.addObject("schedule", scheduleService.getSchedule(id));
        return mav;
    }
    /**
     * Updates a schedule.
     *
     * @param schedule the schedule to be updated
     * @param id the schedule's id
     */
    @RequestMapping(method = RequestMethod.PUT,
            value = "/schedules/updateschedule/{id}")
    public void updateSection(@RequestBody final Schedule schedule,
                              @PathVariable final long id) {
        scheduleService.updateSchedule(schedule);
    }
    /**
     * Deletes a section.
     *
     * @param id the schedule's id
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/schedules/deleteschedule/{id}")
    public String deleteSchedule(@PathVariable final String id) {
        scheduleService.deleteSchedule(id);
        return "redirect:/schedules/";
    }
}