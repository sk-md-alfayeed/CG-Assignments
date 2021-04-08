package com.cg.casestudy.flightbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.casestudy.flightbook.model.UserInformation;
import com.cg.casestudy.flightbook.repository.UserBookingRepository;

@Service
public class UserBookingServiceImpl implements UserBookingService{

	@Autowired
	private UserBookingRepository userBookingRepository;

	// Getting 'All Booking List' from UserBookingReopsitory
	@Override
	public List<UserInformation> getAllUserBookings() {
		return userBookingRepository.findAll();
	}

	// Getting 'Booking object/Optional' from UserBookingReopsitory
	@Override
	public Optional<UserInformation> getUserBooking(String username) {
		return userBookingRepository.findById(username);
	}

	// Adding 'Booking' to database using UserBookingReopsitory
	@Override
	public String addUserBooking(UserInformation userInformation) {
		userBookingRepository.save(userInformation);
		return "Flight Booked with: " + userInformation.getUsername();
	}

	// Updating 'Booking' to database using UserBookingReopsitory
	@Override
	public String updateUserBooking(UserInformation userInformation) {
		userBookingRepository.save(userInformation);
		return "Flight Cancelled with: " + userInformation.getUsername();
	}

}
