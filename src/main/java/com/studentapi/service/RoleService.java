package com.studentapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapi.entity.Role;
import com.studentapi.repository.RoleRepository;

@Service
public class RoleService {
	
	@Autowired
private RoleRepository rolerepo;
	
	public Role createNewRole(Role role) {
		
		 return rolerepo.save(role);
	} 
}
