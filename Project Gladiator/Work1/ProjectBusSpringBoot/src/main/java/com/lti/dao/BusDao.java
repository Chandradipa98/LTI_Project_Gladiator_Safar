package com.lti.dao;

import java.util.Date;
import java.util.List;

import com.lti.model.BusTbl;

public interface BusDao {
	public int createBus(BusTbl bus);

	public List<BusTbl> readAllBus();

	public BusTbl updateBus(BusTbl bus);
	
	//public BusTbl disableBus(BusTbl bus);

	public int deleteBus(int id, Date depDate);

	public BusTbl readBusByIdDate(int id, Date depDate);
	
	public List<BusTbl> readBusByFromToDate(String from, String to, Date date);
	

}
