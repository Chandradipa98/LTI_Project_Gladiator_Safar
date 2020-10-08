package com.lti.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.BusTbl;

@Repository
@Scope(scopeName = "singleton")
public class BusDaoImpl implements BusDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public int createBus(BusTbl bus) {
		entityManager.persist(bus);
		return bus.getId();
	}

	@Override
	public List<BusTbl> readAllBus() {
		String jpql = "Select b From BusTbl b";
		TypedQuery<BusTbl> tquery = entityManager.createQuery(jpql, BusTbl.class);
		return tquery.getResultList();

	}

	@Override
	@Transactional
	public BusTbl updateBus(BusTbl bus) {
		bus = entityManager.merge(bus);
		return bus;
	}
	
	
	/*@Override
	@Transactional
	public int deleteBus(int id) {
		BusTbl bus = entityManager.find(BusTbl.class, id);
		entityManager.remove(bus);
		return 1;
	}*/

	@Override
	public BusTbl readBusByIdDate(int id, Date depDate) {
		String jpql = "Select b From BusTbl b where b.id = :id and b.departureDate = :dd and b.busStatus = 1";
		TypedQuery<BusTbl> tquery = entityManager.createQuery(jpql, BusTbl.class);
		tquery.setParameter("id", id);
		tquery.setParameter("dd", depDate);
		
		return tquery.getSingleResult();
	}

	@Override
	public List<BusTbl> readBusByFromToDate(String from, String to, Date dt) {
		String jpql = "Select b From BusTbl b where b.source = :s and b.destination = :d and b.departureDate = :dd and b.busStatus = 1 and b.availableSeat>0 and b.coachBusStatus = 0";
		//String jpql = "Select b From BusTbl b where b.source = :s and b.destination = :d";
		TypedQuery<BusTbl> tquery = entityManager.createQuery(jpql, BusTbl.class);
		tquery.setParameter("s", from);
		tquery.setParameter("d", to);
		tquery.setParameter("dd", dt);
		return tquery.getResultList();
	}

	@Override
	@Transactional
	public int deleteBus(int id, Date depDate) {
		String jpql1 = "Delete From BusTbl b where b.id = :id and b.departureDate = :dd";
		Query query1 = entityManager.createQuery(jpql1);
		query1.setParameter("id", id);
		query1.setParameter("dd", depDate);
		query1.executeUpdate();
		return 1;
	}

	@Override
	public List<BusTbl> readBusByFromToDateCB(String from, String to, Date date, int cb) {
		String jpql = "Select b From BusTbl b where b.source = :s and b.destination = :d and b.departureDate = :dd and b.busStatus = 1 and b.coachBusStatus = :cb and b.availableSeat=b.totalSeat";
		//String jpql = "Select b From BusTbl b where b.source = :s and b.destination = :d";
		TypedQuery<BusTbl> tquery = entityManager.createQuery(jpql, BusTbl.class);
		tquery.setParameter("s", from);
		tquery.setParameter("d", to);
		tquery.setParameter("dd", date);
		tquery.setParameter("cb", cb);
		return tquery.getResultList();
	}

	@Override
	@Transactional
	public int updateBusByIdDate(int id, Date date, int seats) {
		String jpql1 = "Update BusTbl b SET b.availableSeat = :seat where b.id = :id and b.departureDate = :dd";
		Query query1 = entityManager.createQuery(jpql1);
		query1.setParameter("seat", seats);
		query1.setParameter("id", id);
		query1.setParameter("dd", date);
		//System.out.println(seats);
		int result = query1.executeUpdate();
		return result;
	}


}
