package com.revature.daos;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.revature.models.Role;

import com.revature.models.User;


@Repository
@Transactional
public class UserDAO implements IUserDAO {

	private static final Logger log = LogManager.getLogger(UserDAO.class);
	private SessionFactory sf;
	
	@Autowired
	public UserDAO(SessionFactory sf) {
		super();
		this.sf=sf;
	}

	
	@Override
	public User findByUsername(String username) {
		Session session = sf.getCurrentSession();

		User u = session.createQuery("FROM User WHERE username='" + username+ "'", User.class).list().get(0);
		return u;
	}

	@Override
	public User findById(int id) {
		Session ses = sf.getCurrentSession();
		
		User u = ses.get(User.class, id);
		return u;
	}

	@Override
	public List<User> findAll() {
		Session session = sf.getCurrentSession();

		List<User> list = session.createQuery("FROM User").list();

		log.info("Viewing all Event");
		System.out.println(list + " ");
		return list;
	}

	@Override
	public User addUser(User u) {
		Session ses = sf.getCurrentSession();
	
		
		try {
			ses.save(u);
			return u;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.info("Could not add User");
			return u;
		}
	}

	@Override
	public Role findUserRole(int id) {
		Session ses = sf.getCurrentSession();
		Role role = ses.get(Role.class, id);
		
		return null;
	}

	@Override
	public User findByUsernameAndPassword(String username, String password) {
		Session session = sf.getCurrentSession();

		User u = session.createQuery("FROM User WHERE username='" + username+ "' AND password ='" + password + "'", User.class).list().get(0);
		return u;
	}
	
	@Override
	public User updateUser(User u) {
		Session s = sf.getCurrentSession();
		s.update(u);
		return u;
	}

}
