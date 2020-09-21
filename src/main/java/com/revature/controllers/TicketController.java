package com.revature.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.MaintenanceTicket;
import com.revature.services.TicketServices;




@RestController
@RequestMapping(value = "/ticket")
@CrossOrigin(origins = "*", allowedHeaders = "*")
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
	public ResponseEntity<List<MaintenanceTicket>> findByStatusId(@PathVariable("statusID") int sId) {
		List<MaintenanceTicket> a = ts.findByStatusId(sId);
		if (a == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(a);
	}
	
	@GetMapping("/id")
	public ResponseEntity<MaintenanceTicket> findById(@PathVariable("id") int id) {
		Optional<MaintenanceTicket> t = ts.findById(id);
		if(t.isPresent()) {
			MaintenanceTicket mt = t.get();
			return ResponseEntity.status(HttpStatus.OK).body(mt);
		} else {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		
	}
	
	//do we need to add a controller that looks for tickets by author AND statusID?
	
	@PostMapping
	public ResponseEntity<List<MaintenanceTicket>> addTicket(@RequestBody MaintenanceTicket t) {
		ts.addTicket(t);
		System.out.println(t);
		return ResponseEntity.status(HttpStatus.OK).body(ts.getAll());
	}
	
}