package com.cg.casestudy.flightsearch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.casestudy.flightsearch.model.Flight;
import com.cg.casestudy.flightsearch.model.Search;

@Service
public interface FlightSearchService {

	List<Flight> getFlights(Search search);

	List<Flight> getAllFlights();

	Optional<Flight> getFlight(String id);

	String addFlight(Flight flight);

	String updateFlight(Flight flight);

	String deleteFlight(String flightId);

}
