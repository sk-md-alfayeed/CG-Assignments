package com.cg.rest.a1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping(value = "/hello.html", method = RequestMethod.GET)
	public String getHello() {
		return "Hello REST";
	}

}
