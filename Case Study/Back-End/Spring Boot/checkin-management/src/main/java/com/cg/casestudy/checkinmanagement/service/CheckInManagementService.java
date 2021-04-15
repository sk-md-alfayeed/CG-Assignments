package com.cg.casestudy.checkinmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.cg.casestudy.checkinmanagement.exception.CheckInNotFoundException;
import com.cg.casestudy.checkinmanagement.exception.IdNotFoundException;
import com.cg.casestudy.checkinmanagement.model.CheckIn;

@Service
public interface CheckInManagementService {
	
	List<CheckIn> getAllCheckIns() throws CheckInNotFoundException;

	Optional<CheckIn> getCheckIn(String id) throws CheckInNotFoundException;

	void addCheckIn(CheckIn checkIn);

	void updateCheckIn(CheckIn checkIn);

	String deleteCheckIn(String id) throws IdNotFoundException;


}
