package edu.msudenver.cs3250.group6.msubanner.controllers;

import edu.msudenver.cs3250.group6.msubanner.Global;
import edu.msudenver.cs3250.group6.msubanner.entities.Building;
import edu.msudenver.cs3250.group6.msubanner.entities.Room;
import edu.msudenver.cs3250.group6.msubanner.services.BuildingService;
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

    @Autowired
    private BuildingService buildingService;

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
     * @param building the building that contains this room
     * @return the room
     */
    @RequestMapping(method = RequestMethod.POST, value = "/rooms/addroom")
    public ModelAndView addRoom(@RequestParam final int roomNumber, final int roomCapacity,
                                final Building building) {
        Room room = new Room(roomNumber, roomCapacity, building);
        roomService.addRoom(room);
        ModelAndView mav = new ModelAndView("showroom");
        mav.addObject("room", room);
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Updates a course.
     *
     * @param id the room's id
     */
    @RequestMapping(method = RequestMethod.GET,
            value = "/rooms/updateroom/{id}")
    public ModelAndView updateRoom(@RequestParam final int roomNumber, final int roomCapacity,
                                    final Building building, @PathVariable final String id) {
        Room room = roomService.getRoom(id);
        room.setRoomNumber(roomNumber);
        room.setRoomCapacity(roomCapacity);
        room.setBuilding(building);
        roomService.updateRoom(room);
        ModelAndView mav = new ModelAndView("showroom");
        mav.addObject("room", roomService.getRoom(id));
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Deletes a course.
     *
     * @param id the course's id
     */
    @RequestMapping(method = RequestMethod.DELETE,
            value = "/rooms/deleteroom/{id}")
    public void deleteRoom(@PathVariable final String id) {
        roomService.deleteRoom(id);
    }

    /**
     * Deletes the selected room.
     * @param id The room's id
     * @return ModelAndView containing the list of all rooms
     */
    @RequestMapping(method=RequestMethod.GET,
            value = "/rooms/deleteroom/{id}")
    public ModelAndView deleteRoomRedirect(@PathVariable final String id) {
        roomService.deleteRoom(id);
        ModelAndView mav = new ModelAndView("rooms");
        mav.addObject("allrooms", roomService.getAllRooms());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the edit room form
     * @param id The room's id
     * @return ModelAndView containing the selected room
     */
    @RequestMapping("/rooms/editroom/{id}")
    public ModelAndView editRoom(@PathVariable final String id) {
        ModelAndView mav = new ModelAndView("editroomform");
        mav.addObject("room", roomService.getRoom(id));
        mav.addObject("allbuildings",buildingService.getAllBuildings());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }

    /**
     * Maps to the add room form.
     *
     * @return ModelAndView containing the add room form
     */
    @RequestMapping("/rooms/addroom")
    public ModelAndView addRoomForm() {
        ModelAndView mav = new ModelAndView("addroomform");
        mav.addObject("allbuildings",buildingService.getAllBuildings());
        mav.addObject("school_name", Global.SCHOOL_NAME);
        return mav;
    }
}
