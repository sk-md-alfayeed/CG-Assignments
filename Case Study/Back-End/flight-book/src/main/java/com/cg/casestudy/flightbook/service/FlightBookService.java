package com.cg.casestudy.flightbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.casestudy.flightbook.model.Booking;
import com.cg.casestudy.flightbook.model.Flight;

@Service
public interface FlightBookService {

	public Flight getFlight(String flightId);

	public List<Booking> getAllBookings();

	public Optional<Booking> getBooking(String bookingId);
	
	public String addBooking(Booking booking);
	
	public String updateBooking(Booking booking);
}
