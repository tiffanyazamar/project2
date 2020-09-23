package com.revature;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.revature.controllers.EventController;
import com.revature.controllers.LeaseController;
import com.revature.controllers.TicketController;
import com.revature.controllers.UserController;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.IUserDAO;
import com.revature.services.UserServices;

@SpringBootTest
class ChatelaineSbApplicationTests {

	@Autowired
	private UserController ucontroller;
	@Autowired 
	private TicketController tcontroller;
	@Autowired
	private LeaseController lcontroller;
	@Autowired 
	private EventController econtroller;
	@Autowired
	private UserServices us;
	
	@Autowired
	private IUserDAO udao;


	
	

	@Test
	public void userController() throws Exception {
		assertThat(ucontroller).isNotNull();
	}
	@Test
	public void eventController() throws Exception {
		assertThat(econtroller).isNotNull();
	}
	@Test
	public void leaseController() throws Exception {
		assertThat(lcontroller).isNotNull();
	}
	@Test
	public void ticketController() throws Exception {
		assertThat(tcontroller).isNotNull();
	}


	@Test
	void testUserServices(){
		// given
		Role role = new Role(1, "Tenant");
		User user = new User(9,"cadie","5F4DCC3B5AA765D61D8327DEB882CF99","Cadie", "Limbaker", "123-123-1238",role );
		User user3 = new User(100,"cadien","5F4DCC3B5AA765D61D8327DEB882CF99","Cadien", "Limbakern", "123-123-1238",role );
		User userEntity = udao.findByUserID(9);
		User user4 = udao.findByUserID(100);
		Optional<User> user5 = udao.findById(9);
		System.out.println(user);
		System.out.println(userEntity);
		assertThat(userEntity).isEqualTo(user);
		System.out.println(user4);
		System.out.println(user3);
		assertThat(us.findById(9)).isEqualTo(user5);
		assertThat(us.findAll()).doesNotContainNull();
		assertThat(us.login("cadie", "password")).isEqualTo(user);
		assertThat(us.updateUser(user)).isEqualTo(user);
		
	}

	


}
