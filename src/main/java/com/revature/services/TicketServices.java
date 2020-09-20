package com.revature.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.repositories.ITicketDAO;
import com.revature.repositories.ITicketStatusDAO;
import com.revature.repositories.IUserDAO;
import com.revature.models.Event;
import com.revature.models.MaintenanceTicket;

@Service
public class TicketServices {
	private static final Logger log = LogManager.getLogger(TicketServices.class);

	private ITicketDAO tdao;
	private ITicketStatusDAO tsdao;
	@Autowired
	public TicketServices(ITicketDAO tdao, ITicketStatusDAO tsdao) {
		super();
		this.tdao = tdao;
		this.tsdao = tsdao;
	}
	
	public List<MaintenanceTicket> getAll() {
		log.info("Finding all Maintenance Tickets");
		System.out.println("<3"  + tdao.findAll());
		return tdao.findAll();
	}
	
	public List<MaintenanceTicket> findByStatusId(int sid) {
		log.info("Finding Maintenance Ticket by Status ID");
		return tdao.findByStatusId(sid);
	}
	
	@Transactional
	public MaintenanceTicket addTicket(MaintenanceTicket t) {
		log.info("Adding Maintenance Ticket");
		t.setStatusId(tsdao.findById(1).get());
		t.setSubmitted(new Timestamp(System.currentTimeMillis()));
		return tdao.save(t);
	}

	public Optional<MaintenanceTicket> findById(int id) {
		log.info("Finding Maintenance Ticket by ID");
		return tdao.findById(id);
	}

	public List<MaintenanceTicket> findByUser(int id) {
		log.info("Finding Maintenance Ticket by UserID");
		return tdao.findByAuthor(id);
	}
}

