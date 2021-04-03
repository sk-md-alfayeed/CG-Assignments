package com.cg.casestudy.flightbook.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.casestudy.flightbook.dao.FlightBookRepository;
import com.cg.casestudy.flightbook.model.Booking;
import com.cg.casestudy.flightbook.model.Fair;
import com.cg.casestudy.flightbook.model.Flight;

@Service
public class FlightBookServiceImpl implements FlightBookService {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private FlightBookRepository flightBookRepository;

	// Getting 'Flight & Fair object combined ' from 'flight-search' & 'flight-fair' Microservices
	@Override
	public Flight getFlight(String flightId) {

		// Getting the Flight from Flight Search Microservice using RestTemplate
		try {
			Flight flight = restTemplate.getForObject("http://flight-search/getFlight/" + flightId, Flight.class);
			try {
				// Getting the Fair from Flight Fair Microservice using RestTemplate
				Fair fair = restTemplate.getForObject("http://flight-fair/getFair/" + flightId, Fair.class);
				flight.setFlightFair(fair.getFlightFair());
			} catch (Exception e) {
				flight.setFlightFair(0);

			}
			return flight;

		} catch (Exception e) {
			System.out.println(e);
		}

		return null;

	}
	
	// Getting 'All Booking List' from FlightBookReopsitory
	@Override
	public List<Booking> getAllBookings() {
		return flightBookRepository.findAll();
	}

	// Getting 'Booking object/Optional' from FlightBookReopsitory
	@Override
	public Optional<Booking> getBooking(String bookingId) {
		return flightBookRepository.findById(bookingId);
	}

	// Adding 'Booking' to database using FlightBookReopsitory
	@Override
	public String addBooking(Booking booking) {
		flightBookRepository.save(booking);
		return "Flight Booked with: " + booking.getId();
	}

	// Updating 'Booking' to database using FlightBookReopsitory
	@Override
	public String updateBooking(Booking booking) {
		flightBookRepository.save(booking);
		return "Flight Cancelled with: " + booking.getId();
	}

}
