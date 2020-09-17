package com.revature.daos;

import java.util.List;

import com.revature.models.Role;
import com.revature.models.User;

public interface IUserDAO {
	
	public User findByUsername(String username);
	public User findByUsernameAndPassword(String username, String password);
	public User findById(int id);
	public List<User> findAll();
	public User addUser(User u);
	public Role findUserRole(int id);
	User updateUser(User u);
}
