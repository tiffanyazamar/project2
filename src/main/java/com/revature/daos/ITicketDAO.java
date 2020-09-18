package com.revature.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.MaintenanceTicket;
import com.revature.models.TicketStatus;

public interface ITicketDAO extends JpaRepository<MaintenanceTicket, Integer>{

	MaintenanceTicket findById(int id);

	List<MaintenanceTicket> findAll();

	TicketStatus findTicketStatus(int id);

	boolean addTicket(MaintenanceTicket t);

	List<MaintenanceTicket> findByAuthor(int id);

	List<MaintenanceTicket> findByStatus(int id);

	boolean updateTicket(MaintenanceTicket t);

	public static void main(String[] args) {
		
	}

}
