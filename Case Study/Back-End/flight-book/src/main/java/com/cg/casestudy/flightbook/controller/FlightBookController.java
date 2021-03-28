package com.cg.casestudy.flightbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.casestudy.flightbook.model.Booking;
import com.cg.casestudy.flightbook.model.Flight;
import com.cg.casestudy.flightbook.service.FlightBookServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FlightBookController {

	@Autowired
	private FlightBookServiceImpl flightBookServiceImpl;

	@GetMapping("/findFlight/{flightId}")
	public Flight getFlight(@PathVariable String flightId) {
		return flightBookServiceImpl.getFlight(flightId);
	}
	
	@PostMapping("/addBooking")
	public String saveBooking(@RequestBody Booking booking) {
		return flightBookServiceImpl.saveBooking(booking);
	}

	@DeleteMapping("/cancelBooking/{id}")
	public String cancelBooking(@PathVariable String id) {
		return flightBookServiceImpl.cancelBooking(id);
	}

}
