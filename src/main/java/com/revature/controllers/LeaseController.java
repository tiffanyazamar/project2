package com.revature.controllers;

import java.util.Iterator;
import java.util.List;


import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
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
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.multipart.MultipartFile;

import com.revature.models.Lease;
import com.revature.models.LeaseDTO;

import com.revature.models.User;

import com.revature.services.LeaseServices;


@RestController
@RequestMapping(value = "/lease")
@ResponseBody
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LeaseController {

	private LeaseServices lServices;
	private HttpSession sesh;
	private UserController uc;
	

	@Autowired
	public LeaseController(LeaseServices lServices, HttpSession sesh, UserController uc) {
		super();
		this.lServices = lServices;
		this.sesh = sesh;
		this.uc = uc;

	}

	@GetMapping("allLeases/{status}")
	public List<Lease> getAllLease(@PathVariable("status") String status) {
		return lServices.findAll(status);
	}

//	@GetMapping("/{blank}")
//	public ResponseEntity<Lease> getBlankLease(@PathVariable("blank") int id) {
//		Lease r = lServices.getBlankLease(id);
//		if (r == null) {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//		}
//		return ResponseEntity.status(HttpStatus.OK).body(r);
//	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<Lease> findLeaseByTenant(@PathVariable int id) {
		Lease a = lServices.findLeaseByTenant(id);
		if (a == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(a);
	}
	
	@RequestMapping(value=("/upload"),method=RequestMethod.POST)
	public ResponseEntity<Boolean> uploadLease(@RequestParam("file") MultipartFile f) {
		//System.out.println(l);
		//MultipartFile f = l.file;
		if (f != null) {
			//Lease lease = new Lease();
			User u = uc.getU();
			System.out.println("heyyy");

			System.out.println("user: "+u);
			Lease lease = lServices.findLeaseByTenant(u.getUserID());
			System.out.println("lease"+lease);
			
			try {
				lease.setLeaseFile(f.getBytes());
				//lease.setUser(u);
				//lease.setUser(new User("username", "password", "firstN", "lastN", "12332112344", new Role("SuperUser")));
				//System.out.println("lease being added :" + lease);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			if (lServices.uploadLease(lease) == null) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
			}
			return ResponseEntity.status(HttpStatus.OK).body(true);
		} else {
			System.out.println("file is null");
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	

	@PostMapping("update")
	public ResponseEntity<Boolean> updateLease(@RequestBody LeaseDTO l) {
		Lease lease = lServices.updateLease(l);
		if (lease == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(true);
	}

}
