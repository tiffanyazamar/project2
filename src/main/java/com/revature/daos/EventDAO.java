package com.revature.daos;

import java.sql.Date;
import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Event;



@Repository
@Transactional
public class EventDAO implements IEventDAO {
	private static final Logger log = LogManager.getLogger(EventDAO.class);
	private SessionFactory sf;

	@Autowired
	public EventDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Override
	public List<Event> findAll() {
		Session session = sf.getCurrentSession();

		List<Event> list = session.createQuery("FROM Event").list();

		System.out.println(list + " ");
		return list;
	}

	@Override
	public Event findByDate(Date date) {
		Session session = sf.getCurrentSession();

		Query q = session.createQuery("FROM Event WHERE eventDate=:date");
		q.setParameter("date", date);
		Event event = (Event) q.getResultList().get(0);
		return event;
	}

	@Override
	public boolean addEvent(Event event) {
		Session ses = sf.getCurrentSession();
		Transaction trans = ses.beginTransaction();
		try {
			ses.save(event);
			trans.commit();
			return true;
		} catch (HibernateException e) {
			log.info("Could not add Event");
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public boolean updateEvent(Event ev) {
		Session ses = sf.getCurrentSession();
		
		Transaction tx = ses.beginTransaction();
		
		try {
			ses.merge(ev);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.info("Could not update Ticket");
			tx.rollback();
			return false;
		}
	}
	
	@Override
	public List<Event> findUpcoming(Date date) {
		Session session = sf.getCurrentSession();
		
		String sql = "SELECT * FROM EVENTS WHERE event_date BETWEEN "+date+" AND DATEADD(month, 1, "+date+")";
		SQLQuery query = session.createSQLQuery(sql);
		query.addEntity(Event.class);
		List results = query.list();

		return results;
	}
	
	@Override
	public List<Event> findPast(Date date) {
		Session session = sf.getCurrentSession();

		Query q = session.createQuery("FROM Event WHERE eventDate < :date");
		q.setParameter("date", date);
		List<Event> list = q.getResultList();
		return list;
	}
	
	@Override
	public List<Event> findByUser(int userId) {
		Session session = sf.getCurrentSession();

		Query q = session.createQuery("FROM Event e JOIN e.userList u where u.userID=:userId");
		q.setParameter("userId", userId);
		List<Event> list = q.getResultList();
				
		return list;
	}

}
