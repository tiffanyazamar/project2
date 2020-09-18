package com.revature.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Role;
import com.revature.models.User;


public interface IUserDAO extends JpaRepository<User, Integer>{
	
	public User findByUsername(String username);
	public User findByUsernameAndPassword(String username, String password);
	public User findById(int id);
	public List<User> findAll();
	public User addUser(User u);
	public Role findUserRole(int id);
	public User updateUser(User u);
}
