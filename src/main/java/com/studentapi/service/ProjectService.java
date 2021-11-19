package com.studentapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapi.repository.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private ProjectRepository projectrepo;
	
}
