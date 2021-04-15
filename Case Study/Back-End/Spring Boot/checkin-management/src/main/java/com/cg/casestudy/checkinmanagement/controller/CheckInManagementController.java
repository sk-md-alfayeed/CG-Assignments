package com.cg.casestudy.checkinmanagement.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.casestudy.checkinmanagement.model.CheckIn;
import com.cg.casestudy.checkinmanagement.service.CheckInManagementService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/checkIn")
public class CheckInManagementController {
	
	@Autowired
	public CheckInManagementService checkInManagementService;
	
	// Getting REST GET request and returning 'All CheckIn List' from FlightCheckInService
		@GetMapping(value = "/allCheckIns")
		public ResponseEntity<List<CheckIn>> getAllCheckIns() {
			return ResponseEntity.ok(checkInManagementService.getAllCheckIns());
		}

		// Getting REST GET request and returning 'CheckIn object/ Optional' from
		// FlightCheckInService
		@GetMapping(value = "/getCheckIn/{id}")
		public ResponseEntity<Optional<CheckIn>> getCheckIn(@PathVariable String id) {
			return ResponseEntity.ok(checkInManagementService.getCheckIn(id));

		}

		// Getting REST POST request and returning 'String/Void' from FlightCheckInService
		@PostMapping("/addCheckIn")
		public ResponseEntity<CheckIn> addCheckIn(@Valid @RequestBody CheckIn checkIn) {
			checkInManagementService.addCheckIn(checkIn);
			return ResponseEntity.ok(checkIn);
		}

		// Getting REST PUT request and returning 'String/Void' from FlightCheckInService
		@PutMapping(value = "/updateCheckIn")
		public ResponseEntity<CheckIn> updateCheckIn(@Valid @RequestBody CheckIn checkIn) {
			checkInManagementService.updateCheckIn(checkIn);
			return ResponseEntity.ok(checkIn);
		}

		// Getting REST DELETE request and returning 'String/Void' from
		// FlightCheckInService
		@DeleteMapping("/deleteCheckIn/{id}")
		public ResponseEntity<String> deleteCheckIn(@PathVariable String id) {
			return ResponseEntity.ok(checkInManagementService.deleteCheckIn(id));

		}

}
