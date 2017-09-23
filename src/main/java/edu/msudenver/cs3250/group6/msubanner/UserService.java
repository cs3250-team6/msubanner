package edu.msudenver.cs3250.group6.msubanner;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service  // marks as a Spring business service, creates singleton
public class UserService {
	
	@Autowired
	private UserRepository UserRepository;

	public List<User> getAllUsers() {
		// return Users;
		List<User> Users = new ArrayList<>(); // creates new list
		UserRepository.findAll() // iterate over everything in the repository
		.forEach(Users::add); // populate the list with each element
		return Users;
	}
	
	public User getUser(long id) {
		// iterates on Users List
		// return Users.stream().filter(t -> t.getId().equals(id)).findFirst().get(); // lambda checks that User id equals id passed in 
		return UserRepository.findOne(id);
	}

	public void addUser(User user) {
		UserRepository.save(user); // out of the box save method to db
	}

	public void updateUser(long id, User user) {
		UserRepository.save(user);
	}

	public void deleteUser(long id) {
		UserRepository.delete(id);
	}
}