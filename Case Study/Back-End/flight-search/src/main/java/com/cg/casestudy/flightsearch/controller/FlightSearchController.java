package com.cg.casestudy.flightsearch.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.cg.casestudy.flightsearch.model.Flight;
import com.cg.casestudy.flightsearch.model.Search;
import com.cg.casestudy.flightsearch.service.FlightSearchServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FlightSearchController {

	@Autowired
	private FlightSearchServiceImpl flightSearchServiceImpl;

	@GetMapping(value = "/allFlights")
	public List<Flight> getAllFlights() {
		return flightSearchServiceImpl.getAllFlights();
	}

	@PostMapping(value = "/flights")
	public List<Flight> getFlights(@RequestBody Search search) {
		return flightSearchServiceImpl.getFlights(search);
	}

	@GetMapping("/findFlight/{id}")
	public Optional<Flight> getFlight(@PathVariable String id) {
		return flightSearchServiceImpl.getFlight(id);
	}

	@PostMapping("/addFlight")
	public String saveFlight(@RequestBody Flight flight) {
		return flightSearchServiceImpl.saveFlight(flight);
	}

	@PutMapping("/updateFlight")
	public String updateFlight(@RequestBody Flight flight) {
		return flightSearchServiceImpl.saveFlight(flight);
	}

	@DeleteMapping("/deleteFlight/{id}")
	public String deleteFlight(@PathVariable String id) {

		return flightSearchServiceImpl.deleteFlight(id);
	}

}
