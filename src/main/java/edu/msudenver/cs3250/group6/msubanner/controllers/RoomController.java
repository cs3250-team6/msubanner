package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import edu.msudenver.cs3250.group6.msubanner.entities.Room;
import edu.msudenver.cs3250.group6.msubanner.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * The controller for the room class.
 */
@Controller
public class RoomController {

    /**
     * The room service.
     */
    @Autowired
    private RoomService roomService;

    /**
     * Gets the list of all rooms.
     *
     * @return the list of all rooms
     */
    @RequestMapping("/rooms")
    public ModelAndView getAllRooms() {
        ModelAndView mav = new ModelAndView("rooms");
        mav.addObject("allrooms", roomService.getAllRooms());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Gets a room by id number.
     *
     * @param id the room id
     * @return the room
     */
    @RequestMapping("/rooms/getroom/{id}")
    public ModelAndView getRoom(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("showroom");
        mav.addObject("room", roomService.getRoom(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Adds a room.
     *
     * @param roomNumber the room number
     * @param roomCapacity the room capacity
     * @return the room
     */
    @RequestMapping(method = RequestMethod.POST, value = "/rooms/addroom")
    public ModelAndView addRoom(@RequestParam final int roomNumber, int roomCapacity, Building building) {
        Room room = new Room(roomNumber, roomCapacity);
        roomService.addRoom(room);
        ModelAndView mav = new ModelAndView("showroom");
        mav.addObject("room", room);
        return mav;
    }

    /**
     * Updates a room.
     *
     * @param room the room to be updated
     * @param id the room's id
     */
    @RequestMapping(method = RequestMethod.PUT,
            value = "/rooms/updateroom/{id}")
    public void updateRoom(@RequestBody final Room room,
            @PathVariable final long id) {
        roomService.updateRoom(room);
    }

    /**
     * Deletes a room.
     *
     * @param id the course's id
     */
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/rooms/deleteroom/{id}")
    public void deleteRoom(@PathVariable final String id) {
        roomService.deleteRoom(id);
    }

    @RequestMapping(method=RequestMethod.GET,
            value = "/rooms/deleteroom/{id}")
    public ModelAndView deleteRoomRedirect(@PathVariable final String id) {
        roomService.deleteRoom(id);
        ModelAndView mav = new ModelAndView("rooms");
        mav.addObject("allrooms", roomService.getAllRooms());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }
}
