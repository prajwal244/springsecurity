package com.studentapi.controller;



import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentapi.entity.User;
import com.studentapi.service.UserService;

@RestController
public class UserContoller {
     
	@Autowired
	private UserService userService;
	

@PostConstruct
	public void  initRolesAndUsers() {
userService.initRoleAndUser();
	}
		
	
	@PostMapping({"/registerNewUser"})
	public User registerNewUser(User user) {
		
		return userService.registerNewUser(user);
	}
}
