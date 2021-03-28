package com.cg.casestudy.flightfair.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.casestudy.flightfair.model.Fair;

@Repository
public interface FlightFairReopsitory extends MongoRepository<Fair, String>{
	
	List<Fair> findByFlightIdIn(List<String> flightId);
	
	Optional<Fair> findByFlightId(String flightId);
	
	Optional<Fair> deleteByFlightId(String flightId);


}
