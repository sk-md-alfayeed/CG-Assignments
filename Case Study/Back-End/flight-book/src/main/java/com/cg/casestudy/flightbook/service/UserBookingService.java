package com.cg.casestudy.flightbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.casestudy.flightbook.model.UserInformation;

@Service
public interface UserBookingService {

	
	public List<UserInformation> getAllUserBookings();

	public Optional<UserInformation> getUserBooking(String username);
	
	public String addUserBooking(UserInformation userInformation);
	
	public String updateUserBooking(UserInformation userInformation);
}
