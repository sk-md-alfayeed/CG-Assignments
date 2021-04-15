package com.cg.casestudy.bookingmanagement.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.casestudy.bookingmanagement.model.Booking;
import com.cg.casestudy.bookingmanagement.model.Flight;
import com.cg.casestudy.bookingmanagement.service.BookingManagementService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/booking")
public class BookingManagementController {

	@Autowired
	private BookingManagementService bookingManagementService;

	// Getting REST GET request and returning 'Flight object' from BookingManagementService
	@GetMapping("/getFlight/{flightId}")
	public ResponseEntity<Optional<Flight>> getFlight(@PathVariable String flightId) {
		return ResponseEntity.ok(bookingManagementService.getFlight(flightId));
	}

	// Getting REST GET request and returning 'Booking list' related to the userId
	// from BookingManagementService
	@GetMapping("/getBookingsByUserId/{userId}")
	public ResponseEntity<List<Booking>> getBookingsByUserId(@PathVariable String userId) {
		return ResponseEntity.ok(bookingManagementService.getBookingsByUserId(userId));
		
	}

	// Getting REST GET request and returning 'Booking List' from BookingManagementService
	@GetMapping("/allBookings")
	public ResponseEntity<List<Booking>> getAllBookings() {
		return ResponseEntity.ok(bookingManagementService.getAllBookings());
		
	}

	// Getting REST GET request and returning 'Booking Object/ Optional' from
	// BookingManagementService
	@GetMapping("/getBooking/{bookingId}")
	public ResponseEntity<Optional<Booking>> getBooking(@PathVariable String bookingId) {
		return ResponseEntity.ok(bookingManagementService.getBooking(bookingId));
	}

	// Getting REST POST request and returning 'String/Void' from BookingManagementService
	@PostMapping("/addBooking")
	public ResponseEntity<String> addBooking(@Valid @RequestBody Booking booking) {
		return ResponseEntity.ok(bookingManagementService.addBooking(booking));
	}

	// Getting REST PUT request and returning 'String/Void' from BookingManagementService
	@PutMapping("/updateBooking")
	public ResponseEntity<String> updateBooking(@Valid @RequestBody Booking booking) {
		return ResponseEntity.ok(bookingManagementService.updateBooking(booking));
	}
	
	// Getting REST DELETE request and returning 'String/Void' from BookingManagementService
		@DeleteMapping("/deleteBooking/{bookingId}")
		public ResponseEntity<String> deleteBooking(@PathVariable String bookingId) {
			return ResponseEntity.ok(bookingManagementService.deleteBooking(bookingId));
		}

}
