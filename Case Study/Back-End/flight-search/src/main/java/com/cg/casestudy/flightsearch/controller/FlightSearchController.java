package com.cg.casestudy.flightsearch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.casestudy.flightsearch.model.Flight;
import com.cg.casestudy.flightsearch.model.Search;
import com.cg.casestudy.flightsearch.service.FlightSearchService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FlightSearchController {

	@Autowired
	private FlightSearchService flightSearchService;
	
	//Getting REST POST request and returning 'flights list' from FlightSearchService
	@PostMapping(value = "/flights")
	public List<Flight> getFlights(@RequestBody Search search) {
		return flightSearchService.getFlights(search);
	}

	//Getting REST GET request and returning 'all flights list' from FlightSearchService
	@GetMapping(value = "/allFlights")
	public List<Flight> getAllFlights() {
		return flightSearchService.getAllFlights();
	}

	//Getting REST GET request and returning 'one flight' from FlightSearchService
	@GetMapping("/getFlight/{id}")
	public Optional<Flight> getFlight(@PathVariable String id) {
		return flightSearchService.getFlight(id);
	}

	//Getting REST POST request and returning response from FlightSearchService
	@PostMapping("/addFlight")
	public String addFlight(@RequestBody Flight flight) {
		return flightSearchService.addFlight(flight);
	}

	//Getting REST PUT request and returning response from FlightSearchService
	@PutMapping("/updateFlight")
	public String updateFlight(@RequestBody Flight flight) {
		return flightSearchService.updateFlight(flight);
	}

	//Getting REST DELETE request and returning response from FlightSearchService
	@DeleteMapping("/deleteFlight/{id}")
	public String deleteFlight(@PathVariable String id) {
		return flightSearchService.deleteFlight(id);
	}

}
