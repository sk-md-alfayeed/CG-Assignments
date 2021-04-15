package com.cg.casestudy.bookingmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.casestudy.bookingmanagement.exception.BookingNotFoundException;
import com.cg.casestudy.bookingmanagement.exception.IdNotFoundException;
import com.cg.casestudy.bookingmanagement.model.Booking;
import com.cg.casestudy.bookingmanagement.model.Fare;
import com.cg.casestudy.bookingmanagement.model.Flight;
import com.cg.casestudy.bookingmanagement.repository.BookingManagementRepository;


@Service
public class BookingManagementServiceImpl implements BookingManagementService {

	@Autowired
	private BookingManagementRepository bookingManagementRepository;

	@Autowired
	@Lazy
	private RestTemplate restTemplate;

//	// (space between '$' and '{' is important)
//	@Value("$ {microservice.flight-management.endpoints.endpoint.uri}")
//	private String FLIGHT_ENDPOINT_URL;
//
//	// (space between '$' and '{' is important)
//	@Value("$ {microservice.fare-management.endpoints.endpoint.uri}")
//	private String FARE_ENDPOINT_URL;

	// Getting 'Flight & Fare object combined ' from 'flight-search' & 'flight-fare'
	// Microservices
	@Override
	public Optional<Flight> getFlight(String flightId) {

		// Getting the Flight from Flight Search Microservice using RestTemplate
		try {
			Flight flight = restTemplate.getForObject("http://flight-management/flight" + "/getFlight/" + flightId,
					Flight.class);
			try {
				// Getting the Fare from Flight Fare Microservice using RestTemplate
				Fare fare = restTemplate.getForObject("http://fare-management/fare" + "/getFare/" + flightId,
						Fare.class);
				flight.setFlightFare(fare.getFlightFare());
			} catch (Exception e) {
				flight.setFlightFare(0);
			}
			return Optional.of(flight);
		} catch (Exception e) {
			return Optional.empty();

		}

	}

	// Getting 'Booking List related to the userID from BookingManagementReopsitory
	@Override
	public List<Booking> getBookingsByUserId(String userId) {
		List<Booking> bookingList = bookingManagementRepository.findByUserId(userId);
		if (bookingList.isEmpty()) {
			throw new BookingNotFoundException("No Booking available with userId : " + userId);
		}
		return bookingList;

	}

	// Getting 'All Booking List' from BookingManagementReopsitory
	@Override
	public List<Booking> getAllBookings() {
		List<Booking> allBookingList = bookingManagementRepository.findAll();
		if (allBookingList.isEmpty()) {
			throw new BookingNotFoundException("No Booking available");
		}
		return allBookingList;
	}

	// Getting 'Booking object/Optional' from BookingManagementReopsitory
	@Override
	public Optional<Booking> getBooking(String bookingId) {
		Optional<Booking> booking = bookingManagementRepository.findById(bookingId);
		if (!booking.isPresent()) {
			throw new BookingNotFoundException("No Booking available with bookingId : " + bookingId);
		}
		return booking;
	}

	// Adding 'Booking' to database using BookingManagementReopsitory
	@Override
	public String addBooking(Booking booking) {
		bookingManagementRepository.save(booking);
		return "Flight Booked with: " + booking.getId();
	}

	// Updating 'Booking' to database using BookingManagementReopsitory
	@Override
	public String updateBooking(Booking booking) {
		bookingManagementRepository.save(booking);
		return "Flight Updated with: " + booking.getId();
	}

	// Deleting 'Booking' by Flight Id in database using FareReopsitory
		@Override
		public String deleteBooking(String bookingId) {
			if (bookingManagementRepository.existsById(bookingId)) {
				bookingManagementRepository.deleteById(bookingId);
				return "Fare Deleted with Flight Id : "+ bookingId;
			} else {
				throw new IdNotFoundException("Id not exist");
			}

		}
}
