package com.studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapi.entity.Projects;

@Repository
public interface ProjectRepository extends JpaRepository<Projects, String> {

}
