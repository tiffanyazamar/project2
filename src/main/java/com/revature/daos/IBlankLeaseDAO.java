package com.revature.daos;



import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.BlankLease;

public interface IBlankLeaseDAO extends JpaRepository<BlankLease, Integer>{
	
	public BlankLease findBlankLease();
	

}
