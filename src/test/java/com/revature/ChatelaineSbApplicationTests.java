//package com.revature;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.hamcrest.CoreMatchers.any;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.sql.Timestamp;
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.BeforeClass;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.revature.controllers.EventController;
//import com.revature.controllers.LeaseController;
//import com.revature.controllers.TicketController;
//import com.revature.controllers.UserController;
//import com.revature.models.Event;
//import com.revature.models.Lease;
//import com.revature.models.LeaseDTO;
//import com.revature.models.MaintenanceTicket;
//import com.revature.models.Role;
//import com.revature.models.TicketDTO;
//import com.revature.models.TicketStatus;
//import com.revature.models.User;
//import com.revature.models.UserDTO;
//import com.revature.repositories.ITicketDAO;
//import com.revature.repositories.IUserDAO;
//import com.revature.services.EventServices;
//import com.revature.services.LeaseServices;
//import com.revature.services.RoleService;
//import com.revature.services.TicketServices;
//import com.revature.services.UserServices;
//
//@SpringBootTest
//@Transactional(propagation = Propagation.NOT_SUPPORTED)
//class ChatelaineSbApplicationTests {
//
//	@Autowired
//	private UserController ucontroller;
//	@Autowired 
//	private TicketController tcontroller;
//	@Autowired
//	private LeaseController lcontroller;
//	@Autowired 
//	private EventController econtroller;
//	@Autowired
//	private UserServices us;
//	@Autowired 
//	private TicketServices ts;
//	@Autowired
//	private IUserDAO udao;
//	@Autowired
//	private ITicketDAO tdao;
//	@Autowired 
//	public LeaseServices ls; //change to constructor injection
//	@Autowired 
//	public EventServices es; 
//	@Autowired 
//	public RoleService rs; 
//
//	
//	public static int userId;
//	public static int leaseID;
//	public static String status;
//	public Event event;
//	public User user;
//	public List<User> ulist;
//
//
//
//	
//	@BeforeClass
//	public static void initialize() {
//		userId = 9;
//		leaseID = 1;
//		status = "signed";
//	}
//
//
//	@Test
//	public void userController() throws Exception {
//		assertThat(ucontroller).isNotNull();
//	}
//	@Test
//	public void eventController() throws Exception {
//		assertThat(econtroller).isNotNull();
//	}
//	@Test
//	public void leaseController() throws Exception {
//		assertThat(lcontroller).isNotNull();
//	}
//	@Test
//	public void ticketController() throws Exception {
//		assertThat(tcontroller).isNotNull();
//		assertThat(ts.getAll()).isNotNull();
//	}
//
//
//	@Test
//	void testUserServices(){
//		// given
//		Role role = new Role(1, "Tenant");
//		User user = new User(9,"cadie","5F4DCC3B5AA765D61D8327DEB882CF99","Cadie", "Limbaker", "123-123-1238",role );
//		User user3 = new User(100,"cadien","5F4DCC3B5AA765D61D8327DEB882CF99","Cadien", "Limbakern", "123-123-1238",role );
//		User userEntity = udao.findByUserID(9);
//		User user4 = udao.findByUserID(100);
//		Optional<User> user5 = udao.findById(9);
//		System.out.println(user);
//		System.out.println(userEntity);
//		assertThat(userEntity).isEqualTo(user);
//		System.out.println(user4);
//		System.out.println(user3);
//		assertThat(us.findById(9)).isEqualTo(user5);
//		assertThat(us.findAll()).doesNotContainNull();
//		assertThat(us.login("cadie", "password")).isEqualTo(user);
//		assertThat(us.updateUser(user)).isEqualTo(user);
//		
//	}
//	
//	@Test
//	void testTicketServices(){
//		Role role = new Role(1, "Tenant");
//		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//		Date date1;
//		long time = 1600761522;
//		try {
//			date1 = dateFormat.parse("22/09/2020 19:58:42");
//			time = date1.getTime();
//		} catch (ParseException e) {
//		}
//		Timestamp date = new Timestamp(time);
//		TicketStatus status = new TicketStatus(1, "Unresolved");
//		User user = new User(9,"cadie","5F4DCC3B5AA765D61D8327DEB882CF99","Cadie", "Limbaker", "123-123-1238",role );
//		MaintenanceTicket ticket = new MaintenanceTicket(15, "Bed Bugs!!!!" ,null, date, user, status);   
//		MaintenanceTicket ticketEntity = ts.findById(15);
//		System.out.println(ticket);
//		System.out.println(date);
//		List<MaintenanceTicket> list = tdao.findAll();
//		assertThat(list).isNotEmpty();
//		List<MaintenanceTicket> list2 = ts.findByStatus("Resolved");
//		assertThat(list2).isNotEmpty();
//		List<MaintenanceTicket> list3 = ts.findByAuthor1(9);
//		assertThat(list3).isNotEmpty();
//		assertThat(ts.addTicket(ticket)).isEqualTo(ticket);
//		
//		
//		
//		
//	}
//	@Test 
//	void updateTicket() {
//		MaintenanceTicket t = ts.findById(15);
//		TicketDTO td = new TicketDTO(1);
//		assertThat(ts.updateTicket(td)).isNotNull();
//	}
//	
//	
//	@Test
//	void testLeaseService() {
//		Role role = new Role(1, "Tenant");
//		User user = new User(9,"cadie","5F4DCC3B5AA765D61D8327DEB882CF99","Cadie", "Limbaker", "123-123-1238",role );
//		assertThat(ls.findAll("all")).isNotEmpty();
//		assertThat(ls.findById(4)).isEqualTo(ls.findLeaseByTenant(9));
//		LeaseDTO l = new LeaseDTO(4, "Tenant");
//		assertThat(ls.updateLease(l)).isEqualTo(ls.findLeaseByTenant(9));
//		LeaseDTO l2 = new LeaseDTO(4, "tenant");
//		assertThat(ls.updateLease(l2)).isNotNull();
//		LeaseDTO l3 = new LeaseDTO(4, "landlord");
//		assertThat(ls.updateLease(l3)).isNotNull();
//		
//	}
//	
//	@Test
//	public void findAll() {
//		List<Lease> eList= ls.findAll("signed");
//		assertTrue(eList!=null);
//	}
//	
//	@Test
//	public void findByTenant() {
//		Lease eList= ls.findLeaseByTenant(9);
//		assertTrue(eList!=null);
//	}
//	
//	@Test
//	public void findById() {
//		Lease l = ls.findById(1);
//		assertTrue(l!=null);
//	}
//
//	@Test
//	public void findAllEvent() {
//		List<Event> eList= es.findAll();
//		assertTrue(eList!=null);
//	}
//	
//	@Test
//	public void findByGuest() {
//		List<Event> eList= es.findByGuest(userId);
//		assertTrue(eList!=null);
//	}
//	
//	@Test
//	void testRoleService() {
//		Role role = new Role(1, "Tenant");
//		assertThat(rs.findById(1)).isEqualTo(rs.findByName(role.getRole()));
//		assertThat(us.findUserRole(1)).isNotNull();
//		
//
//	}
//
//	
//	@Test
//	void testEventService() {
////		List<Event> e = es.findByGuest(1);
////		assertThat(es.updateEvent(e.get(0))).isNotNull();
////		assertThat(es.addEvent(e.get(0))).isNotNull();
////		
//
//	}
//	
//	
//	
//	
//
//
//}
