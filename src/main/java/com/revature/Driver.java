package com.revature;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.springframework.transaction.annotation.Transactional;

import com.revature.daos.EventDAO;
import com.revature.daos.IEventDAO;
import com.revature.models.Event;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.utils.Hash;


public class Driver {

	public static void main(String[] args) throws NoSuchAlgorithmException {
		
		insertValues();
		
//		Session ses = HibernateUtil.getSession();
//		List<Event> list = ses.createQuery("FROM Event").list();
//		for (Event u : list) {
//			System.out.println(u);
//		}

	}
	

	@Transactional
	public static void insertValues() throws NoSuchAlgorithmException {
		String pw1 = Hash.generateHash("ilikesushi", "MD5");
		//String pw2 = Hash.generateHash("ilikehoney", "MD5");
		
		Role r = new Role("Tenant");
		
		User u = new User("hk", pw1, "Hello", "Kitty", "15719992107", r, null);
		Event e = new Event("BBQ", "Texas BBQ and fireworks!!!", Date.valueOf("2021-07-04"), u);
				
		List<Event> eventList = new ArrayList<Event>();
		List<User> userList = new ArrayList<User>();
		eventList.add(e);
		userList.add(u);

		e.setUserList(userList);
//		u.setEventList(eventList);
//
//      IEventDAO eDao = new EventDAO();
//		eDao.addEvent(e);
		
//		IUserDAO uDao = new UserDAO();
//		uDao.addUser(u);
		SessionFactory sf;
//		Session ses2 = sf.getCurrentSession();
//		Transaction trans2 = ses2.beginTransaction();
//		try {
//			ses2.save(u);
//			trans2.commit();
//		} catch (Exception ex) {
//			ex.printStackTrace();
//		}
	}
}
