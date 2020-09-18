package com.revature.services;

import java.sql.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.daos.IEventDAO;
import com.revature.models.Event;

@Service
public class EventServices {
	private static final Logger log = LogManager.getLogger(EventServices.class);

	private IEventDAO edao;
	
	@Autowired
	public EventServices(IEventDAO edao) {
		super();
		this.edao = edao;
	}
	
	public List<Event> findAll() {
		return edao.findAll();
	}
	
	public Event findByDate(Date date) {
		return edao.findByDate(date);
	}
	
	public List<Event> findByUser(int userId) {
		return edao.findByUser(userId);
	}
	
	public List<Event> findUpcoming(Date date) {
		return edao.findUpcoming(date);
	}
	
	public List<Event> findPast(Date date) {
		return edao.findPast(date);
	}
	
	public List<Event> addEvent(Event ev) {
		edao.addEvent(ev);
		return edao.findAll();
	}
}
