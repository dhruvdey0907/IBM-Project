package com.ibm.jwt.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.jwt.entity.User;
import com.ibm.jwt.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@PostConstruct
	public void initRolesAndUser() {
		userService.initRolesAndUser();
	}

	@PostMapping({ "/registerNewUser" })
	public User registerNewUser(@RequestBody User user) {

		return userService.registerNewuser(user);
	}
	
	@GetMapping({"/forAdmin"})
	public String forAdmin() {
		return "Only Admin can Access the site";
	}
	
	@GetMapping({"/forUser"})
	public String forUser() {
		return " Only User can access this";
	}

}
