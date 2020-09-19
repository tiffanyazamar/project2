package com.revature.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.MaintenanceTicket;
import com.revature.models.TicketStatus;


public interface ITicketDAO  extends JpaRepository<MaintenanceTicket, Integer> {

//	MaintenanceTicket findById(int id);
//
//	MaintenanceTicket findTicketStatus(int id);
//
//	List<MaintenanceTicket> addTicket(MaintenanceTicket t);
//
//	List<MaintenanceTicket> findByAuthor(int id);

//	MaintenanceTicket updateTicket(MaintenanceTicket t);
//
//	List<MaintenanceTicket> findAll();
//
	public List<MaintenanceTicket> findByStatusId(int sId);
	public List<MaintenanceTicket> findByAuthor(int aId);

}
