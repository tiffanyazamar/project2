package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Role;
import com.revature.models.User;

public interface IUserDAO  extends JpaRepository<User, Integer>{
//	
//	User findByUsername(String username);
//	User findByUsernameAndPassword(String username, String password);
	User findByUserID(int id);
//	List<User> findAll();

	Role userRole(int id);

	User findByUsernameAndPassword(String username, String generateHash);

}
