package com.cg.casestudy.flightbook.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.casestudy.flightbook.model.UserInformation;

@Repository
public interface UserBookingRepository extends MongoRepository<UserInformation, String> {

}
