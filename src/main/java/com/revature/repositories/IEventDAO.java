package com.revature.repositories;

import java.sql.Date;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.Event;

public interface IEventDAO  extends JpaRepository<Event, Integer> {

	Event findByEventDate(Date date);


//	List<Event> findUpcoming(Date date);
//	List<Event> findPast(Date date);


	List<Event> findByEventCreator(int id);
	
}
