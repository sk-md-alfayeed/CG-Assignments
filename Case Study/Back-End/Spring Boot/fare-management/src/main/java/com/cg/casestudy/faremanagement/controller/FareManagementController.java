package com.cg.casestudy.faremanagement.controller;

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

import com.cg.casestudy.faremanagement.model.Fare;
import com.cg.casestudy.faremanagement.service.FareManagementService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/fare")
public class FareManagementController {

	@Autowired
	public FareManagementService fareManagementService;

	// Getting REST GET request and returning 'All Fare List' from FlightFareService
	@GetMapping(value = "/allFares")
	public ResponseEntity<List<Fare>> getAllFares() {
		return ResponseEntity.ok(fareManagementService.getAllFares());
	}

	// Getting REST GET request and returning 'Fare object/ Optional' from
	// FlightFareService
	@GetMapping(value = "/getFare/{id}")
	public ResponseEntity<Optional<Fare>> getFare(@PathVariable String id) {
		return ResponseEntity.ok(fareManagementService.getFare(id));

	}

	// Getting REST POST request and returning 'String/Void' from FlightFareService
	@PostMapping("/addFare")
	public ResponseEntity<Fare> addFare(@Valid @RequestBody Fare fare) {
		fareManagementService.addFare(fare);
		return ResponseEntity.ok(fare);
	}

	// Getting REST PUT request and returning 'String/Void' from FlightFareService
	@PutMapping(value = "/updateFare")
	public ResponseEntity<Fare> updateFare(@Valid @RequestBody Fare fare) {
		fareManagementService.updateFare(fare);
		return ResponseEntity.ok(fare);
	}

	// Getting REST DELETE request and returning 'String/Void' from
	// FlightFareService
	@DeleteMapping("/deleteFare/{id}")
	public ResponseEntity<String> deleteFare(@PathVariable String id) {
		return ResponseEntity.ok(fareManagementService.deleteFare(id));

	}
}
