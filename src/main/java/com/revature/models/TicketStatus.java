package com.revature.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Component
@Entity
@Table (name="ticket_status")
public class TicketStatus implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="status_id")
	private int statusId;
	@Column (nullable=false)
	private String status;
	@OneToMany(mappedBy = "statusId", fetch = FetchType.EAGER)
	@JsonManagedReference //prevents infinite loops in my json
	private List<MaintenanceTicket> tickets;
	
	
	public TicketStatus(int statusId, String status, List<MaintenanceTicket> tickets) {
		super();
		this.statusId = statusId;
		this.status = status;
		this.tickets = tickets;
	}
	public TicketStatus(int statusId, String status) {
		super();
		this.statusId = statusId;
		this.status = status;
	}
	public TicketStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TicketStatus(String status) {
		super();
		this.status = status;
	}
	
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public List<MaintenanceTicket> getTickets() {
		return tickets;
	}
	public void setTickets(List<MaintenanceTicket> tickets) {
		this.tickets = tickets;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + statusId;
		result = prime * result + ((tickets == null) ? 0 : tickets.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TicketStatus other = (TicketStatus) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (statusId != other.statusId)
			return false;
		if (tickets == null) {
			if (other.tickets != null)
				return false;
		} else if (!tickets.equals(other.tickets))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "TicketStatus [statusId=" + statusId + ", status=" + status + ", tickets=" + tickets + "]";
	}

	
	

}
