package com.revature.daos;

import java.util.List;

import javax.persistence.Query;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.MaintenanceTicket;
import com.revature.models.TicketStatus;
import com.revature.models.User;

@Repository
@Transactional
public class TicketDAO implements ITicketDAO{	
	
	private SessionFactory sf;

	private IUserDAO uDao;


	private static final Logger log = LogManager.getLogger(EventDAO.class);
	
	@Autowired
	public TicketDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Override
	public MaintenanceTicket findById(int id) {
		Session ses = sf.getCurrentSession();
		
		MaintenanceTicket t = ses.get(MaintenanceTicket.class, id);
		return t;
	}

	@Override
	public List<MaintenanceTicket> findAll() {
		Session ses = sf.getCurrentSession();
		
		List<MaintenanceTicket> list = ses.createQuery("FROM MaintenanceTicket").list();
		return list;
	}

	@Override
	public TicketStatus findTicketStatus(int id) {
		Session ses = sf.getCurrentSession();
		
		TicketStatus status = ses.get(TicketStatus.class, id);
		return status;
	}

	@Override
	public boolean addTicket(MaintenanceTicket t) {
		Session ses = sf.getCurrentSession();
		
		try {
			ses.save(t);
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.info("Could not add Ticket");
			return false;
		}
	}

	@Override
	public List<MaintenanceTicket> findByAuthor(int id) {
		Session ses = sf.getCurrentSession();
		
		User u = uDao.findById(id);
		Query query = ses.createQuery("FROM MaintenanceTicket where author=:author",MaintenanceTicket.class);
		query.setParameter("author", u);
		
		return query.getResultList();
	}

	@Override
	public List<MaintenanceTicket> findByStatus(int id) {
		Session ses = sf.getCurrentSession();
		
		TicketStatus status = findTicketStatus(id);
		Query query = ses.createQuery("FROM MaintenanceTicket where status=:ts",MaintenanceTicket.class);
		query.setParameter("ts", status);
		
		return query.getResultList();
	}

	@Override
	public boolean updateTicket(MaintenanceTicket t) {
		Session ses = sf.getCurrentSession();
		
		Transaction tx = ses.beginTransaction();
		
		try {
			ses.merge(t);
			tx.commit();
			return true;
		} catch (HibernateException e) {
			e.printStackTrace();
			log.info("Could not update Ticket");
			tx.rollback();
			return false;
		}
	}

}
