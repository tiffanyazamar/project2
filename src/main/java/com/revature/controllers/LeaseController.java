package com.revature.controllers;

import java.util.List;

import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Lease;
import com.revature.models.LeaseDTO;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.ILeaseDAO;
import com.revature.services.LeaseServices;

@RestController
@RequestMapping(value = "/lease")
@ResponseBody
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LeaseController {

	private LeaseServices lServices;

	@Autowired
	public LeaseController(LeaseServices lServices) {
		super();
		this.lServices = lServices;
	}

	@GetMapping("allLeases/{status}")
	public List<Lease> getAllLease(@PathVariable("status") String status) {
		return lServices.findAll(status);
	}

//	@GetMapping("/{blank}")
//	public ResponseEntity<Lease> getBlankLease(@PathVariable("blank") int id) {
//		Lease r = lServices.getBlankLease(id);
//		if (r == null) {
//			return ResponseEntity.status(HttpStatus.SC_NO_CONTENT).build();
//		}
//		return ResponseEntity.status(HttpStatus.SC_ACCEPTED).body(r);
//	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Lease> findLeaseByTenant(@PathVariable int id) {
		Lease a = lServices.findLeaseByTenant(id);
		if (a == null) {
			return ResponseEntity.status(HttpStatus.SC_NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.SC_ACCEPTED).body(a);
	}

	@PostMapping("update")
	public ResponseEntity<Boolean> updateLease(@RequestBody LeaseDTO l) {
		Lease lease = lServices.updateLease(l);
		if (lease == null) {
			return ResponseEntity.status(HttpStatus.SC_NO_CONTENT).build();
		}
		return ResponseEntity.status(HttpStatus.SC_ACCEPTED).body(true);
	}

}
