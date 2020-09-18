package com.revature.controllers;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.Event;
import com.revature.services.EventServices;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping(value = "/pokemon")
@ResponseBody
public class EventController {

	private EventServices es;
	
	@Autowired
	public EventController(EventServices es) {
		super();
		this.es = es;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<Event> getAll() {
		return es.findAll();
	}

	@GetMapping("/{date}")
	public ResponseEntity<Event> findByDate(@PathVariable("date") Date date) {
		Event a = es.findByDate(date);
		if (a == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
	}
	
	@GetMapping("/{userId}")
	public ResponseEntity<List<Event>> findByUser(@PathVariable("userId") int id) {
		List<Event> events = es.findByUser(id);
		if (events == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(events);
	}
	
	@GetMapping("/upcoming")
	public ResponseEntity<List<Event>> findUpcomingEvents(Date date) {
		List<Event> events = es.findUpcoming(date);
		if (events == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(events);
	}
	
	@GetMapping("/past")
	public ResponseEntity<List<Event>> findPastEvents(Date date) {
		List<Event> events = es.findPast(date);
		if (events == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(events);
	}
	
	@PostMapping
	public List<Event> addEvent(@RequestBody Event ev) {
		return es.addEvent(ev);
	}
	
}