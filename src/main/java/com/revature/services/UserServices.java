package com.revature.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.UserDAO;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.utils.Hash;

@Service
public class UserServices {

	@Autowired
	private UserDAO userDAO;

	public User login(String username, String password) {
		try {
			return userDAO.findByUsernameAndPassword(username, Hash.generateHash(password, "MD5"));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User register(UserDTO loginDTO) {
//		Role userRole = new Role();
//		User user = new User(username, password, firstName, lastName, phoneNumber, userRole);
		return null;
	}
	
	public User findByUsername(String username) {
		return userDAO.findByUsername(username);
		
	}
	public User findByUsernameAndPassword(String username, String password) {
		return userDAO.findByUsernameAndPassword(username, password);
		
	}
	public User findById(int id) {
		return userDAO.findById(id);
		
	}
	public List<User> findAll(){
		return userDAO.findAll();
		
	}
	public User addUser(User u) {
		return userDAO.addUser(u);
	}
	public Role findUserRole(int id) {
		return userDAO.findUserRole(id);
		
	}

	public User updateUser(User p) {
		return userDAO.updateUser(p);
	}
	
}
