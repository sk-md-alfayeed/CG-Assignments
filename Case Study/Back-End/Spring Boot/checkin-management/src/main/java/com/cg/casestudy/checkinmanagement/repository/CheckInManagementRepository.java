package com.cg.casestudy.checkinmanagement.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cg.casestudy.checkinmanagement.model.CheckIn;

@Repository
public interface CheckInManagementRepository extends MongoRepository<CheckIn, String> {

}
