package com.revature.models;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lease")
public class Lease implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="lease_id", nullable=false)
	private int leaseID;
	@Column(name="lease")
	private Blob leaseName;
	@Column(name="start_date")
	private Timestamp startDate;
	@Column(name="end_date")
	private Timestamp endDate;
	@Column(name="landlord_sig")
	private boolean landlordSig;
	@ManyToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinColumn(name="user_id", nullable=false)
	private User user;
	

	public Lease() {
	}


	public Lease(int leaseID, Blob leaseName, Timestamp startDate, Timestamp endDate, boolean landlordSig, User user) {
		super();
		this.leaseID = leaseID;
		this.leaseName = leaseName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.landlordSig = landlordSig;
		this.user = user;
	}


	public int getLeaseID() {
		return leaseID;
	}


	public void setLeaseID(int leaseID) {
		this.leaseID = leaseID;
	}


	public Blob getLeaseName() {
		return leaseName;
	}


	public void setLeaseName(Blob leaseName) {
		this.leaseName = leaseName;
	}


	public Timestamp getStartDate() {
		return startDate;
	}


	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}


	public Timestamp getEndDate() {
		return endDate;
	}


	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}


	public boolean isLandlordSig() {
		return landlordSig;
	}


	public void setLandlordSig(boolean landlordSig) {
		this.landlordSig = landlordSig;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + (landlordSig ? 1231 : 1237);
		result = prime * result + leaseID;
		result = prime * result + ((leaseName == null) ? 0 : leaseName.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Lease other = (Lease) obj;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (landlordSig != other.landlordSig)
			return false;
		if (leaseID != other.leaseID)
			return false;
		if (leaseName == null) {
			if (other.leaseName != null)
				return false;
		} else if (!leaseName.equals(other.leaseName))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Lease [leaseID=" + leaseID + ", leaseName=" + leaseName + ", startDate=" + startDate + ", endDate="
				+ endDate + ", landlordSig=" + landlordSig + ", user=" + user + "]";
	}
	

}
