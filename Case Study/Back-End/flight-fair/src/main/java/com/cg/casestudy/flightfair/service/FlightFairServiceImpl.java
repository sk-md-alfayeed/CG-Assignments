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
public class FlightFairServiceImpl {

	@Autowired
	FlightFairReopsitory flightFairRepository;

	public List<Fair> getAllFairs() {

		return flightFairRepository.findAll();
	}

	public Optional<Fair> getFair(String flightId) {
		return flightFairRepository.findByFlightId(flightId);

	}

	public FlightFair getFairs(FlightList flightList) {
		return new FlightFair(flightFairRepository.findByFlightIdIn(flightList.getFlightList()));
	}

	public String addFair(Fair fair) {
		flightFairRepository.save(fair);
		return "Added Fair with flightId : " + fair.getFlightId();

	}

	public String updateFair(Fair fair) {
		flightFairRepository.save(fair);
		return "Updated Fair with flightId : " + fair.getFlightId();
	}

	// Delete Fair by Flight Id
	public String deleteFair(String flightId) {
		flightFairRepository.deleteByFlightId(flightId);
		return "Fair Deleted with flightId : " + flightId;
	}

}
