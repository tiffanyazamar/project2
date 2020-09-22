package com.revature.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.revature.models.Lease;
import com.revature.models.LeaseDTO;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.ILeaseDAO;
import com.revature.services.LeaseServices;

import io.jsonwebtoken.io.IOException;

@RestController
@RequestMapping(value = "/lease")
@ResponseBody
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LeaseController {

	private LeaseServices lServices;
	private HttpSession sess;

	@Autowired
	public LeaseController(LeaseServices lServices, HttpSession sess) {
		super();
		this.lServices = lServices;
		this.sess = sess;
	}

	@GetMapping("allLeases")
	public List<Lease> getAllLease() {
		return lServices.findAll();
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
	
	@PostMapping("upload")
	public ResponseEntity<Boolean> uploadLease(@RequestParam("file") MultipartFile f) {
		if (f != null) {
			Lease lease = new Lease();
			User u = (User) sess.getAttribute("user");
			try {
				lease.setLeaseFile(f.getBytes());
				lease.setUser(u);
				//lease.setUser(new User("username", "password", "firstN", "lastN", "12332112344", new Role("SuperUser")));
				//System.out.println("lease being added :" + lease);
			} catch (IOException | java.io.IOException e) {
				e.printStackTrace();
			}
			
			if (lServices.uploadLease(lease) == null) {
				return ResponseEntity.status(HttpStatus.SC_NO_CONTENT).build();
			}
			return ResponseEntity.status(HttpStatus.SC_ACCEPTED).body(true);
		} else {
			System.out.println("file is null");
			return ResponseEntity.status(HttpStatus.SC_NO_CONTENT).build();
		}
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
