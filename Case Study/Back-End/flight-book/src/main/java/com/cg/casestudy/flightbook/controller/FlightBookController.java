package com.cg.casestudy.flightbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.casestudy.flightbook.model.Booking;
import com.cg.casestudy.flightbook.model.Flight;
import com.cg.casestudy.flightbook.service.FlightBookService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FlightBookController {

	@Autowired
	private FlightBookService flightBookService;

	// Getting REST GET request and returning 'Flight object' from FlightBookService
	@GetMapping("/getFlight/{flightId}")
	public Flight getFlight(@PathVariable String flightId) {
		return flightBookService.getFlight(flightId);
	}

	// Getting REST GET request and returning 'Booking list' related to the userId
	// from FlightBookService
	@GetMapping("/getBookingsByUserId/{userId}")
	public List<Booking> getBookingsByUserId(@PathVariable String userId) {
		return flightBookService.getBookingsByUserId(userId);
		
	}

	// Getting REST GET request and returning 'Booking List' from FlightBookService
	@GetMapping("/allBookings")
	public List<Booking> getAllBookings() {
		return flightBookService.getAllBookings();
	}

	// Getting REST GET request and returning 'Booking Object/ Optional' from
	// FlightBookService
	@GetMapping("/getBooking/{bookingId}")
	public Optional<Booking> getBooking(@PathVariable String bookingId) {
		return flightBookService.getBooking(bookingId);
	}

	// Getting REST POST request and returning 'String/Void' from FlightBookService
	@PostMapping("/addBooking")
	public String addBooking(@RequestBody Booking booking) {
		return flightBookService.addBooking(booking);
	}

	// Getting REST PUT request and returning 'String/Void' from FlightBookService
	@PutMapping("/updateBooking")
	public String updateBooking(@RequestBody Booking booking) {
		return flightBookService.updateBooking(booking);
	}

}
