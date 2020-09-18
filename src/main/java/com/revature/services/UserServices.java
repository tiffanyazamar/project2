package com.revature.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repositories.IUserDAO;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.utils.Hash;

@Service
public class UserServices {

	
	private IUserDAO userDAO;
	
	@Autowired
	public UserServices(IUserDAO userDAO) {
		super();
		this.userDAO = userDAO;
	}
	
	
//
//	public User register(UserDTO loginDTO) {
////		Role userRole = new Role();
////		User user = new User(username, password, firstName, lastName, phoneNumber, userRole);
//		return null;
//	}
	
	//	public User findByUsername(String username) {
//		return userDAO.findByUsername(username);
//		
//	}
//	public User findByUsernameAndPassword(String username, String password) {
//		return userDAO.findByUsernameAndPassword(username, password);
//		
//	}
	public User findById(int id) {
		return userDAO.findByUserID(id);
		
	}
	public List<User> findAll(){
		return userDAO.findAll();
		
	}
	public User addUser(User u) {
		return userDAO.save(u);
	}
	public Role findUserRole(int id) {
		return userDAO.userRole(id);
		
	}

	public User updateUser(User p) {
		return userDAO.save(p);
	}


	public User login(String username, String password) {
		// TODO Auto-generated method stub
		return userDAO.findUserByUsernameAndPassword(username, password);
	}
	
}