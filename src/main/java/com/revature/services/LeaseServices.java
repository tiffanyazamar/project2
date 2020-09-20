package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.revature.repositories.ILeaseDAO;

import com.revature.models.Lease;

@Service
public class LeaseServices {
	
	private ILeaseDAO lDAO;
	
	@Autowired
	public LeaseServices(ILeaseDAO lDAO) {
		super();
		this.lDAO = lDAO;
	}



//	public Lease findLeaseByTenant(int id) {
//		return lDAO.findByUser(id);
//	}

	public List<Lease> findAll() {
		return lDAO.findAll();
	}



	public Lease updateLease(Lease l) {
	 return lDAO.save(l);
	}




//	public Lease getBlankLease(int id) {
//		return lDAO.BlankLeaseName(id);
//	}



}