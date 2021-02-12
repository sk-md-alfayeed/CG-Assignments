package com.cg.rest.a2;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class UserController {

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {

		ModelAndView model = new ModelAndView("index");

		return model;
	}

	@RequestMapping(value = "/user/{name}", method = RequestMethod.POST)
	public String submitAdmissionForm(@RequestBody User user) {

		if (user.getUsername().equals("alpha") && user.getPassword().equals("pass")) {

			return "User valid";

		}

		return "User invalid";
	}

}
