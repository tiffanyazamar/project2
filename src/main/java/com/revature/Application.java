package com.revature;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.revature.daos.IEventDAO;
import com.revature.daos.IUserDAO;
import com.revature.models.Event;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.Hash;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws NoSuchAlgorithmException {
//		SpringApplication.run(Application.class, args);
//		
//		String pw1 = Hash.generateHash("ilikesushi", "MD5");
//		//String pw2 = Hash.generateHash("ilikehoney", "MD5");
//		
//		Role r = new Role("Tenant");
//		
//		User u = new User("hk", pw1, "Hello", "Kitty", "15719992107", r, null);
//		Event e = new Event("BBQ", "Texas BBQ and fireworks!!!", Date.valueOf("2021-07-04"), u);
//				
//		List<Event> eventList = new ArrayList<Event>();
//		List<User> userList = new ArrayList<User>();
//		eventList.add(e);
//		userList.add(u);
//
//		e.setUserList(userList);
//		u.setEventList(eventList);
////
//		IUserDAO udao = null;
//		IEventDAO edao = null;
//		udao.addUser(u);
//		edao.addEvent(e);
		
		
	}

}
