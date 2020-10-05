package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.BusTbl;
import com.lti.model.ReservationTbl;
import com.lti.service.ReservationService;

@RestController
@RequestMapping(path = "Reserve")
@CrossOrigin
public class ReservationAppController {

	@Autowired
	private ReservationService service2;

	@PostMapping(path = "/")
	public void addReservation(@RequestBody ReservationTbl resv) {
		service2.addReservation(resv);
	}

	@GetMapping(path = "/")
	public List<ReservationTbl> getAllReservation() {
		List<ReservationTbl> resv = service2.findAllReservation();
		return resv;
	}
	
	@GetMapping(path = "{id}")
	public ReservationTbl getReservationBytno(@PathVariable("id") int tno) {
		ReservationTbl resv = service2.findReservationByTicketNo(tno);
		return resv;
	}
	
	@PutMapping(path = "/")
	public ReservationTbl updateReservationByTicketNo(@RequestBody ReservationTbl resv) {
		boolean result = service2.modifyReservation(resv);
		if (result)
			resv = service2.findReservationByTicketNo(resv.getTicketNo());
		return resv;
	}

	@DeleteMapping(path = "{id}")
	public void deleteReservationByTicketNo(@PathVariable("id") int ticketNo) {
		service2.removeReservation(ticketNo);
	}
	
	@PutMapping(path = "/set")
	public ReservationTbl setBus(@RequestBody ReservationTbl resv, @RequestBody BusTbl bus) {
		boolean result = service2.setBus(resv, bus);
		if (result)
			resv = service2.findReservationByTicketNo(resv.getTicketNo());
		return resv;
	}
}
