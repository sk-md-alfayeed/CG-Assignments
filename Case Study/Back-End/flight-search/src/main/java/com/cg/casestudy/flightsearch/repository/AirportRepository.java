package com.cg.casestudy.flightsearch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.casestudy.flightsearch.model.Airport;

@Repository
public interface AirportRepository extends MongoRepository<Airport, String>{

}
