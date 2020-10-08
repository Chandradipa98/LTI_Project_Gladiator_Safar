package com.lti.dao;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lti.model.ReservationTbl;
import com.lti.model.SeatTbl;

@Repository
@Scope(scopeName = "singleton")
public class SeatDaoImpl implements SeatDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public int createSeat(SeatTbl seat) {
		entityManager.persist(seat);
		System.out.println(seat.getBusDetails());
		return seat.getSeatId();
	}

	@Override
	@Transactional
	public List<SeatTbl> readAllSeats() {
		String jpql = "Select s From SeatTbl s";
		TypedQuery<SeatTbl> tquery = entityManager.createQuery(jpql, SeatTbl.class);
		return tquery.getResultList();
	}

	@Override
	@Transactional
	public int deleteSeat(int seatId) {
		SeatTbl seat = entityManager.find(SeatTbl.class, seatId);
		entityManager.remove(seat);
		return 1;
	}

	@Override
	@Transactional
	public SeatTbl updateSeat(SeatTbl seat) {
		seat = entityManager.merge(seat);
		return seat;
	}

	@Override
	@Transactional
	public SeatTbl readSeatBySeatId(int seatId) {

		return entityManager.find(SeatTbl.class, seatId);
	}

	@Override
	public List<SeatTbl> readAllSeatsByIdDate(int id, Date date) {
		String jpql = "Select s From SeatTbl s where s.busDetails.id = :id and s.busDetails = :dd";
		TypedQuery<SeatTbl> tquery = entityManager.createQuery(jpql, SeatTbl.class);
		tquery.setParameter("id", id);
		tquery.setParameter("dd", date);
		return tquery.getResultList();
	}

}
