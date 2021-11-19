package com.studentapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapi.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

}
