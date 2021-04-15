package com.cg.casestudy.flightmanagement.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.casestudy.flightmanagement.model.Flight;
import com.cg.casestudy.flightmanagement.model.Search;
import com.cg.casestudy.flightmanagement.service.FlightManagementService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/flight")
public class FlightManagementController {

	@Autowired
	private FlightManagementService flightManagementService;

	// Getting REST POST request and returning 'flights list' from
	// FlightSearchService
	@PostMapping(value = "/flights")
	public ResponseEntity<List<Flight>> getFlights(@Valid @RequestBody Search search) {
		return ResponseEntity.ok(flightManagementService.getFlights(search));
	}

	// Getting REST GET request and returning 'all flights list' from
	// FlightSearchService
	@GetMapping(value = "/allFlights")
	public ResponseEntity<List<Flight>> getAllFlights() {
		return ResponseEntity.ok(flightManagementService.getAllFlights());
	}

	// Getting REST GET request and returning 'one flight' from FlightSearchService
	@GetMapping("/getFlight/{flightId}")
	public ResponseEntity<Optional<Flight>> getFlight(@PathVariable String flightId) {
		return ResponseEntity.ok(flightManagementService.getFlight(flightId));
	}

	// Getting REST POST request and returning response from FlightSearchService
	@PostMapping("/addFlight")
	public ResponseEntity<String> addFlight(@Valid @RequestBody Flight flight) {
		return ResponseEntity.ok(flightManagementService.addFlight(flight));
	}

	// Getting REST PUT request and returning response from FlightSearchService
	@PutMapping("/updateFlight")
	public ResponseEntity<String> updateFlight(@Valid @RequestBody Flight flight) {
		return ResponseEntity.ok(flightManagementService.updateFlight(flight));
	}

	// Getting REST DELETE request and returning response from FlightSearchService
	@DeleteMapping("/deleteFlight/{flightId}")
	public ResponseEntity<String> deleteFlight(@PathVariable String flightId) {
		return ResponseEntity.ok(flightManagementService.deleteFlight(flightId));
	}

}
