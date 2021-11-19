package com.studentapi.entity;


import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity; 
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {

	@GeneratedValue
	
	private long id;
	@Id
	private String userName;
	private String firstName;
	private String lastName;
	private int mobileNumber;
	private String email;
	private String userPassword;
	
	@OneToMany(targetEntity = Projects.class,cascade=CascadeType.ALL)
	@JoinTable(name= "TOTAL_PROJECT",
	joinColumns= {
			@JoinColumn(name ="USER_ID")
	},
	 inverseJoinColumns = {
			 @JoinColumn(name ="PROJECT_ID")
	})
	private List<Projects> projects;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade= CascadeType.ALL)
	@JoinTable(name= "USER_ROLE",
	joinColumns= {
			@JoinColumn(name ="USER_ID")
	},
	 inverseJoinColumns = {
			 @JoinColumn(name ="ROLE_ID")
	})
	private Set<Role> role;
}
