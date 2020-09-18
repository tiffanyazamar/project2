package com.revature.daos;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.Lease;


@Repository
@Transactional
public class LeaseDAO implements ILeaseDAO {
	
	private SessionFactory sf;
	
	@Autowired
	public LeaseDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Override
	public List<Lease> findAllLease() {
		Session s = sf.getCurrentSession();
		CriteriaQuery<Lease> cq = s.getCriteriaBuilder().createQuery(Lease.class);
		cq.from(Lease.class);
		return s.createQuery(cq).getResultList();
	}

	@Override
	public Lease findLeaseByTenant(int id) {
		return null;
	}

	@Override
	public Lease findBySig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lease findCurrent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lease findExpired() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Lease updateLease(int id) {
		Session ses = sf.getCurrentSession();
		Transaction tx = ses.beginTransaction();
		Lease lease = findLeaseByTenant(id);
		try {
			ses.merge(lease);
			tx.commit();
			return lease;
		} catch (HibernateException e) {
			e.printStackTrace();
			tx.rollback();
			return lease;
		}
	}


	
	

	

}
