package com.studentapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.studentapi.entity.Role;
import com.studentapi.entity.User;
import com.studentapi.repository.UserRepository;
import com.studentapi.service.RoleService;
import com.studentapi.service.UserService;

@RestController
public class RoleController {

	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService usersr;
	
	@Autowired
	private UserRepository urepo;
	@PostMapping({"/createNewRole"})
	public Role createNewRole( @RequestBody Role role) {
		 return roleService.createNewRole(role);
		
	}
	
	
	@GetMapping({"/findUserById/{id}"})
	@PreAuthorize("hasRole('admin')")
	public User foradmin(@PathVariable("id") Long id) {
		
		return usersr.findById(id);
	}
	
	
	@GetMapping({"/findAll"})
	
	@PreAuthorize("hasRole('admin')")
	public List<User> findAll() {
		return usersr.findAll();
		
	}
}
