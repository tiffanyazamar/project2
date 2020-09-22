package com.revature.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.models.TicketStatus;

public interface ITicketStatusDAO extends JpaRepository<TicketStatus, Integer> {
	
	TicketStatus findByStatusId(int id);

	TicketStatus findByStatus(String status);

}
