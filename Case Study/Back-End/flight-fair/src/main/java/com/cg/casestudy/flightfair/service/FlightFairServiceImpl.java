package com.cg.casestudy.flightfair.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.casestudy.flightfair.model.Fair;
import com.cg.casestudy.flightfair.model.FlightFair;
import com.cg.casestudy.flightfair.model.FlightList;
import com.cg.casestudy.flightfair.repository.FlightFairReopsitory;

@Service
public class FlightFairServiceImpl implements FlightFairService {

	@Autowired
	FlightFairReopsitory flightFairRepository;

	// Getting 'FlightFair object' from FlightFairReopsitory by custom search
	@Override
	public FlightFair getFairs(FlightList flightList) {
		return new FlightFair(flightFairRepository.findByFlightIdIn(flightList.getFlightList()));
	}
	
	// Getting 'All Fair List' from FlightFairReopsitory
	@Override
	public List<Fair> getAllFairs() {
		return flightFairRepository.findAll();
	}

	// Getting 'Fair object/Optional' from FlightFairReopsitory
	@Override
	public Optional<Fair> getFair(String flightId) {
		return flightFairRepository.findByFlightId(flightId);
	}

	// Adding 'Fair' to database using FlightFairReopsitory
	@Override
	public String addFair(Fair fair) {
		flightFairRepository.save(fair);
		return "Added Fair with flightId : " + fair.getFlightId();
	}
	
	// Updating 'Fair' in database using FlightFairReopsitory
	@Override
	public String updateFair(Fair fair) {
		flightFairRepository.save(fair);
		return "Updated Fair with flightId : " + fair.getFlightId();
	}

	// Deleting 'Fair' by Flight Id in database using FlightFairReopsitory
	@Override
	public String deleteFair(String flightId) {
		flightFairRepository.deleteByFlightId(flightId);
		return "Fair Deleted with flightId : " + flightId;
	}

}
