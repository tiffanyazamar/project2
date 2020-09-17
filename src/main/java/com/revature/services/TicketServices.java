package com.revature.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.ITicketDAO;
import com.revature.daos.IUserDAO;
import com.revature.models.MaintenanceTicket;

@Service
public class TicketServices {
	private static final Logger log = LogManager.getLogger(TicketServices.class);

	private ITicketDAO tdao;
	@Autowired
	public TicketServices(ITicketDAO tdao, IUserDAO udao) {
		super();
		this.tdao = tdao;
	}
	
	public List<MaintenanceTicket> getAll() {
		log.info("Finding all Maintenance Tickets");
		return tdao.findAll();
	}
	
	public MaintenanceTicket findByStatusId(int sid) {
		log.info("Finding Maintenance Ticket by Status ID");
		return (MaintenanceTicket) tdao.findByStatus(sid);
	}
	
	public List<MaintenanceTicket> addTicket(MaintenanceTicket t) {
		log.info("Adding Maintenance Ticket");
		tdao.addTicket(t);
		return tdao.findAll();
	}
}
