package com.revature.services;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;

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
	
//	@Autowired
	private RoleService roleService;
//	
	@Autowired
	public UserServices(IUserDAO userDAO, RoleService roleService) {
		super();
		this.userDAO = userDAO;
		this.roleService = roleService;
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
	public Optional<User> findById(int id) {
		return userDAO.findById(id);
		
	}
	public List<User> findAll(){
		return userDAO.findAll();
		
	}
//	public User addUser(UserDTO p) {
//		Role userRole = roleService.findByName("Tenant");
//		User user = new User(p.userName, p.password, p.firstName, p.lastName, p.phoneNumber, userRole);
//		return userDAO.save(user);
//	}
	public Role findUserRole(int id) {
		return userDAO.userRole(id);
		
	}

	public User updateUser(User p) {
		
		
		return userDAO.save(p);
	}


	public User login(String username, String password) {
		return userDAO.findUserByUsernameAndPassword(username, password);
	}


	public User addUser(UserDTO p) {
		Role userRole = roleService.findByName("Tenant");
		User user = new User(p.username, p.password, p.firstName, p.lastName, p.phoneNumber, userRole);
		userDAO.save(user);
		return user;
	}
	
}