package com.revature.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.MaintenanceTicket;
import com.revature.models.User;



public interface ITicketDAO  extends JpaRepository<MaintenanceTicket, Integer> {



//	List<MaintenanceTicket> findByAuthor(int id);

//	MaintenanceTicket updateTicket(MaintenanceTicket t);

	public List<MaintenanceTicket> findByAuthor(User u );
	MaintenanceTicket findById(int id);
	public List<MaintenanceTicket> findByTicketId(int id);

}
