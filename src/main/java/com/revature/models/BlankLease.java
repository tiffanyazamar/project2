package com.revature.models;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;

@Entity
@Table(name="blank_lease")
public class BlankLease implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="blank_lease_id", nullable=false)
	private int blankLeaseID;
	@Column(name="blank_lease", nullable=false)
	private String blankLeaseName;
	
	
	
	public BlankLease() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BlankLease(String blankLeaseName) {
		super();
		this.blankLeaseName = blankLeaseName;
	}
	public BlankLease(int blankLeaseID, String blankLeaseName) {
		super();
		this.blankLeaseID = blankLeaseID;
		this.blankLeaseName = blankLeaseName;
	}
	public int getBlankLeaseID() {
		return blankLeaseID;
	}
	public void setBlankLeaseID(int blankLeaseID) {
		this.blankLeaseID = blankLeaseID;
	}
	public String getBlankLeaseName() {
		return blankLeaseName;
	}
	public void setBlankLeaseName(String blankLeaseName) {
		this.blankLeaseName = blankLeaseName;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + blankLeaseID;
		result = prime * result + ((blankLeaseName == null) ? 0 : blankLeaseName.hashCode());
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
		BlankLease other = (BlankLease) obj;
		if (blankLeaseID != other.blankLeaseID)
			return false;
		if (blankLeaseName == null) {
			if (other.blankLeaseName != null)
				return false;
		} else if (!blankLeaseName.equals(other.blankLeaseName))
			return false;
		return true;
	}

}
