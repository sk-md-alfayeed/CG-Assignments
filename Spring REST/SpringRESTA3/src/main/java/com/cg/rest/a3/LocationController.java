package com.cg.rest.a3;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {

	@RequestMapping(value = "/location/{zip}", method = RequestMethod.POST)
	public Location addLocation(@PathVariable String zip, @RequestBody Location location) {
		return location;
	}

	@RequestMapping(value = "/location/{zip}", method = RequestMethod.GET)
	public Location getLocation(@PathVariable String zip) {
		Location loc = new Location();
		loc.setCity("The City");
		loc.setCountry("The Country");
		loc.setState("The State");
		loc.setZip(zip);
		return loc;

	}

}
