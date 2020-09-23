package com.revature.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Role;
import com.revature.models.User;

public interface IUserDAO  extends JpaRepository<User, Integer>{

	Optional<User> findById(int id);
//	User findByUsernameAndPassword(String username, String password);
	User findByUserID(int id);
//	List<User> findAll();

	Role userRole(int id);

	User findUserByUsernameAndPassword(String username, String password);
}
