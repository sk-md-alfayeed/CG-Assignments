package com.cg.casestudy.flightbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.casestudy.flightbook.dao.FlightBookRepo;
import com.cg.casestudy.flightbook.model.Booking;
import com.cg.casestudy.flightbook.model.Fair;
import com.cg.casestudy.flightbook.model.Flight;

@Service
public class FlightBookServiceImpl {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private FlightBookRepo flightBookRepo;

	public Flight getFlight(String flightId) {

		// Getting the Flight from Flight Search Microservice
		try {
			Flight flight = restTemplate.getForObject("http://localhost:8081/findFlight/" + flightId, Flight.class);
			try {
				Fair fair = restTemplate.getForObject("http://localhost:8082/findFair/" + flightId, Fair.class);
				flight.setFlightFair(fair.getFlightFair());
			} catch (Exception e) {
				flight.setFlightFair(0);

			}
			return flight;

		} catch (Exception e) {
			System.out.println(e);
		}
		// Getting the Fair from Flight Fair Microservice
		return null;

	}

	public String saveBooking(Booking booking) {
		flightBookRepo.save(booking);
		return "Flight Booked";
	}

	public String cancelBooking(String id) {

		return "Flight Cancelled";
	}

}
