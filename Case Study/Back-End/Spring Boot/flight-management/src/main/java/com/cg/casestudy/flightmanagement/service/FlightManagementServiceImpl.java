package com.cg.casestudy.flightmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.cg.casestudy.flightmanagement.exception.FlightNotFoundException;
import com.cg.casestudy.flightmanagement.exception.IdNotFoundException;
import com.cg.casestudy.flightmanagement.model.Fare;
import com.cg.casestudy.flightmanagement.model.Flight;
import com.cg.casestudy.flightmanagement.model.Search;
import com.cg.casestudy.flightmanagement.repository.FlightManagementRepository;

@Service
@RefreshScope
public class FlightManagementServiceImpl implements FlightManagementService {

	@Autowired
	private FlightManagementRepository flightManagementRepository;

	@Autowired
	@Lazy
	private RestTemplate restTemplate;
	
//	//(space between '$' and '{' is important)
//	@Value("$ {microservice.fare-management.endpoints.endpoint.uri}")
//    private String FARE_ENDPOINT_URL;

	// Get flights by custom search
	public List<Flight> getFlights(Search search) {

		// Custom search
		List<Flight> searchedList = flightManagementRepository
				.findByDepartureAirportAirportCodeAndDestinationAirportAirportCode(search.getDepartureAirport(),
						search.getDestinationAirport());
		if (searchedList.isEmpty()) {
			throw new FlightNotFoundException("No Flight available");
		}
		return searchedList;
	}

	// Getting All Flights
	@Override
	public List<Flight> getAllFlights() {

		List<Flight> flightList = flightManagementRepository.findAll();
		if (flightList.isEmpty()) {
			throw new FlightNotFoundException("No Flight available");
		}
		return flightList;
	}

	// Getting the Flight
	@Override
	public Optional<Flight> getFlight(String id) {
		Optional<Flight> flight = flightManagementRepository.findById(id);
		if (!flight.isPresent()) {
			throw new IdNotFoundException("Id not found");
		}
		return flight;
	}

	// Adding the Flight
	@Override
	public String addFlight(Flight flight) {
		flightManagementRepository.save(flight);
		Fare fare = new Fare(flight.getId(), flight.getAirline().getAirlineName(), 3000);
		try {
			// Adding the default Fare to Flight Fare Microservice while this addFlight
			// method is called
			restTemplate.postForObject("http://fare-management/fare" + "/addFare", fare, Fare.class);
			return "Flight and Fare added with id : " + flight.getId();
		} catch (Exception e) {
			return "Fare not added because of [" + e + "], but Flight added with Flight Id : " + flight.getId();
		}

	}

	// Updating the Flight
	@Override
	public String updateFlight(Flight flight) {
		flightManagementRepository.save(flight);
		return "Flight updated with id : " + flight.getId();
	}

	// Deleting the Flight
	@Override
	public String deleteFlight(String flightId) {
		flightManagementRepository.deleteById(flightId);
		try {
			// Deleting the Fare from Flight Fare Microservice while this deleteFlight
			// method is called
			restTemplate.delete("fare-management/fare" + "/deleteFare/" + flightId);
			return "Flight and Fare deleted with Flight Id : " + flightId;
		} catch (Exception e) {
			return "Fare not delete because of " + e + ", but Flight deleted with Flight Id : " + flightId;
		}
		
	}

}
