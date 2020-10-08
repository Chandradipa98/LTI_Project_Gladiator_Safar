package com.lti.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lti.model.SeatTbl;
import com.lti.service.SeatService;

@RestController
@RequestMapping(path = "Seat")
@CrossOrigin
public class SeatAppController {

	@Autowired
	private SeatService service5;

	@PostMapping(path = "/")
	public void addSeat(@RequestBody SeatTbl seat) {
		service5.addSeat(seat);
		System.out.println(seat.getBusDetails());
	}

	@GetMapping(path = "/")
	public List<SeatTbl> getAllSeat() {
		List<SeatTbl> seat = service5.findAllSeat();
		System.out.println(seat);
		return seat;
	}
	
	@GetMapping(path = "{id}/{date}")
	public List<SeatTbl> getAllSeatByIdDate(@PathVariable("id") int id,  @PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
		List<SeatTbl> seat = service5.findAllSeatByIdDate(id, date);
		return seat;
	}

	@PutMapping(path = "/")
	public SeatTbl updateSeatById(@RequestBody SeatTbl seat) {
		boolean result = service5.modifySeat(seat);
		if (result)
			seat = service5.findSeatBySeatId(seat.getSeatId());
		return seat;
	}

	@DeleteMapping(path = "{id}")
	public void deleteSeatById(@PathVariable("id") int id) {
		service5.removeSeat(id);
	}
}
