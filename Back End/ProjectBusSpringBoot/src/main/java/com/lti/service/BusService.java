package com.lti.service;

import java.util.Date;
import java.util.List;

import com.lti.model.BusTbl;

public interface BusService {
	public boolean addBus(BusTbl bus);

	public List<BusTbl> findAllBus();

	public boolean modifyBus(BusTbl bus);

	public boolean removeBus(int id, Date depDate);

	public BusTbl findBusByIdDate(int id, Date dt);
	
	public List<BusTbl> findBusByFromToDate(String from, String to, Date dt);
	
	public List<BusTbl> findBusByFromToDateCB(String from, String to, Date dt, int cb);
	
	public boolean modifyBusByIdDate(int id, Date date, int seats);

}
