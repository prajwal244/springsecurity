package com.studentapi.service;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.studentapi.entity.Projects;
import com.studentapi.entity.Role;
import com.studentapi.entity.User;
import com.studentapi.repository.ProjectRepository;
import com.studentapi.repository.RoleRepository;
import com.studentapi.repository.UserRepository;

@Service
public class UserService {
   
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ProjectRepository projectrepo;
	
	@Autowired
	private RoleRepository roleRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public List<User> findAll(){
		
		return userRepo.findAll();
	}
	
	public User findById(Long id) {
		
		return userRepo.getById(id);
		
	}
	
	
	public User registerNewUser(User user) {
		 Role role = roleRepo.findById("User").get();
	        Set<Role> userRoles = new HashSet<>();
	        userRoles.add(role);
	        user.setRole(userRoles);
	        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
       
	return	userRepo.save(user);
	}
	
	
	
public void initRoleAndUser() {
		Projects adminProject = new Projects();
		adminProject.setProjid("1ek");
		adminProject.setProjname("aaa");
		adminProject.setDurationInmonth(22);
		projectrepo.save(adminProject);
		
		
		Role adminRole = new Role();
		
		adminRole.setRoleName("admin");
		roleRepo.save(adminRole);
		
		
		Role userRole = new  Role();
		userRole.setRoleName("user");
		roleRepo.save(userRole);
		
		User adminUser = new User();
		
		adminUser.setUserName("admin");
		adminUser.setFirstName("adminf");
		adminUser.setLastName("adminl");
		adminUser.setMobileNumber(78145692);
		adminUser.setEmail("admin@email.com");
		adminUser.setUserPassword(getEncodedPassword("admin123"));
		
		List<Projects> adminProjects =new ArrayList<>();
		adminProjects.add(adminProject);
		adminUser.setProjects(adminProjects);
		userRepo.save(adminUser);
		
		Set<Role> adminRoles=new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRole(adminRoles);
		userRepo.save(adminUser);
		
		User user = new User();
		user.setId(2);
		user.setUserName("raj");
		user.setFirstName("rajf");
		user.setLastName("rajl");
		user.setMobileNumber(963852741);
		user.setEmail("raj@email.com");
		user.setUserPassword(getEncodedPassword("raj123"));
		Set<Role> userRoles=new HashSet<>();
		userRoles.add(userRole);
		user.setRole(userRoles); 
		userRepo.save(user);
	}



public String getEncodedPassword(String password) {
	
	return passwordEncoder.encode(password);
}
}
