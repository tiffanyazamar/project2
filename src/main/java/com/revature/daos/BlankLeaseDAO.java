package com.revature.daos;


import java.util.List;

import javax.persistence.criteria.CriteriaQuery;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.models.BlankLease;

@Repository
@Transactional
public class BlankLeaseDAO implements IBlankLeaseDAO {
	private static final Logger log = LogManager.getLogger(BlankLeaseDAO.class);
	private SessionFactory sf;

	@Autowired
	public BlankLeaseDAO(SessionFactory sf) {
		super();
		this.sf = sf;
	}

	@Override
	public BlankLease findBlankLease() {
		Session s = sf.getCurrentSession();
		CriteriaQuery<BlankLease> cq = s.getCriteriaBuilder().createQuery(BlankLease.class);
		cq.from(BlankLease.class);
		List<BlankLease> lease =  s.createQuery(cq).getResultList();
		return lease.get(0);
	}

}
