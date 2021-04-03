package com.cg.casestudy.flightfair.controller;

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

import com.cg.casestudy.flightfair.model.Fair;
import com.cg.casestudy.flightfair.model.FlightFair;
import com.cg.casestudy.flightfair.model.FlightList;
import com.cg.casestudy.flightfair.service.FlightFairService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class FlightFairController {

	@Autowired
	public FlightFairService flightFairService;
	
	//Getting REST POST request and returning 'FlightFair object' from FlightFairService
	@PostMapping(value = "/fairs")
	public FlightFair getFairs(@RequestBody FlightList flightList) {
		return flightFairService.getFairs(flightList);
	}
	
	//Getting REST GET request and returning 'All Fair List' from FlightFairService
	@GetMapping(value = "/allFairs")
	public List<Fair> getAllFairs() {
		return flightFairService.getAllFairs();
	}
	
	//Getting REST GET request and returning 'Fair object/ Optional' from FlightFairService
	@GetMapping(value = "/findFair/{flightId}")
	public Optional<Fair> getFair(@PathVariable String flightId) {
		return flightFairService.getFair(flightId);
	}

	//Getting REST POST request and returning 'String/Void' from FlightFairService
	@PostMapping("/addFair")
	public String addFair(@RequestBody Fair fair) {
		return flightFairService.addFair(fair);
	}
	
	//Getting REST PUT request and returning 'String/Void' from FlightFairService
	@PutMapping(value = "/updateFair")
	public String  updateFair(@RequestBody Fair fair) {
		return flightFairService.updateFair(fair);
	}

	//Getting REST DELETE request and returning 'String/Void' from FlightFairService
	@DeleteMapping("/deleteFair/{flightId}")
	public String deleteFair(@PathVariable String flightId) {
		return flightFairService.deleteFair(flightId);
	}

}
