package edu.msudenver.cs3250.group6.msubanner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * Basic CRUD operations for user
 * @author Group 6
 */

@RestController
public class UserController{
	
	@Autowired // indicate injection
	private UserService userService;
	

/*	@GetMapping("/user")
	public String userForm(Model model) {
		model.addAttribute("user", new User());
		return "user";
	}

	@PostMapping("/user")
	public String userSubmit(@ModelAttribute User user) {
		return "result";
	}
*/	
	@RequestMapping("/users")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	// {id} is wildcard for any id passed in
	@RequestMapping("/users/getuser/{id}")
	//@PathVariable indicates use of wildcard above
	public User getUser(@PathVariable long id) { 
		return userService.getUser(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/users/adduser")
	// take request body, turn into User instance and pass to addUser()
	public void addUser(@RequestBody User user) { 
		// POST body should contain object being sent
		userService.addUser(user);	
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/users/updateuser/{id}")
	public void updateUser(@RequestBody User user, @PathVariable long id) { // take request body, turn into User instance and pass to addUser()
		// POST body should contain object being sent
		userService.updateUser(id, user);	
	}
	
	// {id} is wildcard for any id passed in
	@RequestMapping(method=RequestMethod.DELETE, value="/users/deleteuser/{id}")
	//@PathVariable indicates use of wildcard above
	public void deleteUser(@PathVariable long id) { 
		userService.deleteUser(id);
	}
}