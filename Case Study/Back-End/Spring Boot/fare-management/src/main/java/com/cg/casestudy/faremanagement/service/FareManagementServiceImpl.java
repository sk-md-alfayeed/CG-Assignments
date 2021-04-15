package com.cg.casestudy.faremanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.casestudy.faremanagement.exception.FareNotFoundException;
import com.cg.casestudy.faremanagement.exception.IdNotFoundException;
import com.cg.casestudy.faremanagement.model.Fare;
import com.cg.casestudy.faremanagement.repository.FareManagementReopsitory;

@Service
public class FareManagementServiceImpl implements FareManagementService {

	@Autowired
	FareManagementReopsitory fareManagementRepository;

	// Getting 'All Fare List' from FareReopsitory
	@Override
	public List<Fare> getAllFares() {
		List<Fare> fareList = fareManagementRepository.findAll();
		if (fareList.isEmpty()) {
			throw new FareNotFoundException("No Fare available");
		}
		return fareList;
	}

	// Getting 'Fare object/Optional' from FareReopsitory
	@Override
	public Optional<Fare> getFare(String id) {
		Optional<Fare> fare = fareManagementRepository.findById(id);
		if (!fare.isPresent()) {
			throw new IdNotFoundException("Id not found");
		}
		return fare;
	}

	// Adding 'Fare' to database using FareFareReopsitory
	@Override
	public void addFare(Fare fare) {
		fareManagementRepository.save(fare);
	}
 
	// Updating 'Fare' in database using FareReopsitory
	@Override
	public void updateFare(Fare fare) {
		fareManagementRepository.save(fare);
	}

	// Deleting 'Fare' by Flight Id in database using FareReopsitory
	@Override
	public String deleteFare(String id) {
		if (fareManagementRepository.existsById(id)) {
			fareManagementRepository.deleteById(id);
			return "Fare Deleted with Flight Id : "+ id;
		} else {
			throw new IdNotFoundException("Id not exist");
		}

	}

}
