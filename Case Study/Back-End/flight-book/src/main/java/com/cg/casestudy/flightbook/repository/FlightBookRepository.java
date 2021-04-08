package com.cg.casestudy.flightbook.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.casestudy.flightbook.model.Booking;

@Repository
public interface FlightBookRepository extends MongoRepository<Booking, String>{

	List<Booking> findByUserId(String userId);
	

}
