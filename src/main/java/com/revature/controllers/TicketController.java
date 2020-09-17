package com.revature.controllers;

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

import com.revature.models.MaintenanceTicket;
import com.revature.services.TicketServices;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Controller
@RequestMapping(value = "/pokemon")
@ResponseBody
public class TicketController {

	TicketServices ts;
	
	@Autowired
	public TicketController(TicketServices ts) {
		super();
		this.ts = ts;
	}

	@RequestMapping(method = RequestMethod.GET)
	public List<MaintenanceTicket> getAll() {
		return ts.getAll();
	}

	@GetMapping("/{statusID}")
	public ResponseEntity<MaintenanceTicket> findByStatusId(@PathVariable("statusID") int sId) {
		MaintenanceTicket a = ts.findByStatusId(sId);
		if (a == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
	}
	
	//do we need to add a controller that looks for tickets by author AND statusID?
	
	@PostMapping
	public List<MaintenanceTicket> addTicket(@RequestBody MaintenanceTicket t) {
		return ts.addTicket(t);
	}
	
}