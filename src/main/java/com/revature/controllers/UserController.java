package com.revature.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.SessionScope;

import com.revature.models.LoginDTO;
import com.revature.models.MaintenanceTicket;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.models.UserDTO;
import com.revature.repositories.IUserDAO;
import com.revature.services.UserServices;


@RestController
//Adding the URI mapping for what requests this controller will handle

@RequestMapping(value="/user")
@ResponseBody //This will at compile time add @ResponseBody to all methods in the class
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	private UserServices uServices;
	private HttpSession sesh;

	@Autowired
	public UserController(UserServices uServices, HttpSession sesh) {
		super();
		this.uServices = uServices;
		this.sesh = sesh;
	}

	@PostMapping("/login")
	public @ResponseBody User login(@RequestBody LoginDTO loginDTO) {
		User u = uServices.login(loginDTO.username, loginDTO.password);
		if (u != null) {
			sesh.setAttribute("user", u);
			System.out.println("loggedin User: "+sesh.getAttribute("user"));
			sesh.setAttribute("loggedin", true);
		}
		return u;

	}
//	@PostMapping("/register")
//	public @ResponseBody User register(@RequestBody UserDTO loginDTO) {
//		return uServices.register(loginDTO);
//
//	}

	// indicates that a get method to the base URI of the controller (/avenger) will
	// call this method.
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody //This will make sure the response is sent back with JSON
	public List<User> assemble() {
		return uServices.findAll();
	}

	@GetMapping("id/{id}") // Get mapping will direct GET requests to the given mapping. It avoids having
							// to use the method paramater
	public ResponseEntity<User> findById(@PathVariable("id") int id) { // @PathVariable allows you to get the Path
																		// Parameter out of the URI
		Optional<User> a = uServices.findById(id);
		if(a.isPresent()) {
			User u = a.get();
			return ResponseEntity.status(HttpStatus.OK).body(u);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

	}

	@GetMapping("roleid/{role}") // Get mapping will direct GET requests to the given mapping. It avoids having
							// to use the method paramater
	public ResponseEntity<Role> findUserRole(@PathVariable("role") int id) { // @PathVariable allows you to get the Path
																				// Parameter out of the URI
		Role r = uServices.findUserRole(id);
		if (r == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // sends back an empty body in the response.
		}
		return ResponseEntity.status(HttpStatus.OK).body(r);
	}

	@PostMapping("/update")
	public ResponseEntity<User> updateUser(@RequestBody User p) {// Takes the JSON from the request and puts it in the
																	// indicated object
		p = uServices.updateUser(p);
		if (p == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // sends back an empty body in the response.
		}
		return ResponseEntity.status(HttpStatus.OK).body(p);
	}

	@PostMapping("register")
	public ResponseEntity<User> addUser(@RequestBody UserDTO p) {
		User temp = uServices.addUser(p);
		if (temp == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); // sends back an empty body in the response.
		}
		return ResponseEntity.status(HttpStatus.OK).body(temp);
	}

}
