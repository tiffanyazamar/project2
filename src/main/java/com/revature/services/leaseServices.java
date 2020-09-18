package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.IBlankLeaseDAO;
import com.revature.daos.ILeaseDAO;
import com.revature.models.BlankLease;
import com.revature.models.Lease;

@Service
public class leaseServices {
	
	private ILeaseDAO lDAO;
	private IBlankLeaseDAO bDAO;
	@Autowired
	public leaseServices() {
	}



	public Lease findLeaseByTenant(int id) {
		return lDAO.findLeaseByTenant(id);
	}

	public List<Lease> findAllLease() {
		return lDAO.findAllLease();
	}



	public Lease updateLease(int id) {
	 return lDAO.updateLease(id);
	}




	public BlankLease findBlankLease() {
		return bDAO.findBlankLease();
	}



}
