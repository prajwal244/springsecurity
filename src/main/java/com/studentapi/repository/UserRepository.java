package com.studentapi.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapi.entity.User;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	
	
	List<User> findAll();

	User getById(Long id);
	
		
}
