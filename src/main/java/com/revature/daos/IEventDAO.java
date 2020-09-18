package com.revature.daos;

import java.sql.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Event;


public interface IEventDAO extends JpaRepository<Event, Integer>{
	
	public List<Event> findAll();
	public Event findByDate(Date date);
	public boolean addEvent(Event event);
	boolean updateEvent(Event ev);
	List<Event> findUpcoming(Date date);
	List<Event> findPast(Date date);
	List<Event> findByUser(int userId);
	
}
