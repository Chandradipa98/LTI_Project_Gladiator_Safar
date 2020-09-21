package com.lti.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

public class PK_Bus implements Serializable{
	private int busId;
	private Date departure;
	public PK_Bus() {
		super();
	}
	public PK_Bus(int busId, Date departure) {
		super();
		this.busId = busId;
		this.departure = departure;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + busId;
		result = prime * result + ((departure == null) ? 0 : departure.hashCode());
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
		PK_Bus other = (PK_Bus) obj;
		if (busId != other.busId)
			return false;
		if (departure == null) {
			if (other.departure != null)
				return false;
		} else if (!departure.equals(other.departure))
			return false;
		return true;
	}
	
}
