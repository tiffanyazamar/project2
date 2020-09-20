package com.revature.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.models.Role;
import com.revature.repositories.IRoleDAO;

@Service
public class RoleService {

	@Autowired
	private IRoleDAO roleDao;
	
	public Role findById(int roleId) {
		return roleDao.findRoleByRoleID(roleId);
	}
	
	public Role findByName(String name) {
		return roleDao.findRoleByRole(name);
	}
	
}
