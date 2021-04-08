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

import com.cg.casestudy.flightbook.model.UserInformation;
import com.cg.casestudy.flightbook.service.UserBookingService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserBookingController {
	
	@Autowired
	private UserBookingService userBookingService;


	//Getting REST GET request and returning 'Booking List' from UserBookingService
	@GetMapping(value = "/allUserBookings")
	public List<UserInformation> getAllUserBookings() {
		return userBookingService.getAllUserBookings();
	}
	
	//Getting REST GET request and returning 'Booking Object/ Optional' from UserBookingService
	@GetMapping("/getUserBooking/{bookingId}")
	public Optional<UserInformation> getUserBooking(@PathVariable String bookingId) {
		return userBookingService.getUserBooking(bookingId);
	}
	
	//Getting REST POST request and returning 'String/Void' from UserBookingService
	@PostMapping("/addUserBooking")
	public String addUserBooking(@RequestBody UserInformation userInformation) {
		return userBookingService.addUserBooking(userInformation);
	}
	
	//Getting REST PUT request and returning 'String/Void' from UserBookingService
	@PutMapping("/updateUserBooking")
	public String updateUserBooking(@RequestBody UserInformation userInformation) {
		return userBookingService.updateUserBooking(userInformation);
	}

}
