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

import com.lti.model.BusTbl;
import com.lti.service.BusService;


@RestController
@RequestMapping(path = "Bus")
@CrossOrigin
public class BusAppController {
	@Autowired
	private BusService service1;
	
	@PostMapping(path = "/")
	public void addBus(@RequestBody BusTbl bus) {
		service1.addBus(bus);
	}

	@GetMapping(path = "/")
	public List<BusTbl> getAllBus() {
		List<BusTbl> bus = service1.findAllBus();
		return bus;
	}
	
	@GetMapping(path = "{id}/{dt}")
	public BusTbl getBusByIdDate(@PathVariable("id") int id, @PathVariable("dt") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dt) {
		BusTbl bus = service1.findBusByIdDate(id, dt);
		return bus;
	}
	
	@GetMapping(path = "{from}/{to}/{dt}")
	public List<BusTbl> getBusByFromTDate(@PathVariable("from") String from, @PathVariable("to") String to, @PathVariable("dt") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dt) {
		List<BusTbl> bus = service1.findBusByFromToDate(from, to, dt);
		return bus;
	}
	
	@GetMapping(path = "{from}/{to}/{dt}/{cb}")
	public List<BusTbl> getBusByFromTDateCB(@PathVariable("from") String from, @PathVariable("to") String to,
			@PathVariable("dt") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dt,@PathVariable("cb") int cb) {
		List<BusTbl> bus = service1.findBusByFromToDateCB(from, to, dt, cb);
		return bus;
	}
	
	@PutMapping(path = "/")
	public BusTbl updateBusById(@RequestBody BusTbl bus) {
		boolean result = service1.modifyBus(bus);
		if (result)
			bus = service1.findBusByIdDate(bus.getId(), bus.getDepartureDate());
		return bus;
	}

	@DeleteMapping(path = "{id}/{dt}")
	public void deleteBusById(@PathVariable("id") int id, @PathVariable("dt") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dt) {
		service1.removeBus(id, dt);
	}
	
	@PutMapping(path = "{id}/{dt}/{seats}")
	public void updateBusByIdDate(@PathVariable("id") int id, @PathVariable("dt") @DateTimeFormat(pattern = "yyyy-MM-dd") Date date, @PathVariable("seats") int seats) {
		System.out.println(seats);
		service1.modifyBusByIdDate(id, date, seats);
	}
	
}
