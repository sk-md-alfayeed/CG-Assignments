package com.cg.casestudy.flightsearch.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.casestudy.flightsearch.model.Airline;

@Repository
public interface AirlineRepository extends MongoRepository<Airline, String>{

}
