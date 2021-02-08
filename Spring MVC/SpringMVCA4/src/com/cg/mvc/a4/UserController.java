package com.cg.mvc.a4;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {

		ModelAndView model = new ModelAndView("registration");

		return model;
	}

	@RequestMapping(value = "/submitRegistration.html", method = RequestMethod.POST)
	public ModelAndView submitRegistrationForm(@ModelAttribute("user") User user) {
		
		UserDB regDB = new UserDB();
		regDB.inserUser(user.getUsername(), user.getPassword(), user.getEmail());
		
		ModelAndView model = new ModelAndView("login");

		return model;
	}

	@RequestMapping(value = "/submitLogin.html", method = RequestMethod.POST)
	public ModelAndView submitLoginForm(@RequestParam String username, @RequestParam String password) {

		UserDB uDB = new UserDB();
		User user = uDB.getUser(username);
		

		if (user.getUsername().equals(username) && user.getPassword().equals(password)) {

			ModelAndView model = new ModelAndView("success");
			model.addObject("msg", "Login Success");

			return model;

		} else {
			ModelAndView model = new ModelAndView("error");
			model.addObject("msg", "Login Error");

			return model;
		}
	}
}
