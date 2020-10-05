package com.lti.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.lti.dao.BusDao;
import com.lti.model.BusTbl;


@Service("service1")
@Scope(scopeName = "singleton")
public class BusServiceImpl implements BusService {

	@Autowired
	private BusDao dao = null;

	@Override
	public boolean addBus(BusTbl bus) {
		int result = dao.createBus(bus);
		return (result > 0) ? true : false;
	}

	@Override
	public List<BusTbl> findAllBus() {

		return dao.readAllBus();
	}

	@Override
	public boolean modifyBus(BusTbl bus) {

		BusTbl result = dao.updateBus(bus);
		return ((result != null) ? true : false);
	}

	@Override
	public boolean removeBus(int id, Date dt) {
		int result = dao.deleteBus(id,dt);
		return (result == 1) ? true : false;
	}

	@Override
	public BusTbl findBusByIdDate(int id, Date dt) {

		return dao.readBusByIdDate(id, dt);
	}

	@Override
	public List<BusTbl> findBusByFromToDate(String from, String to, Date dt) {
		return dao.readBusByFromToDate(from, to, dt);
	}


}
