package com.cg.mvc.a3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {

		ModelAndView model = new ModelAndView("login");

		return model;
	}

	@RequestMapping(value = "/submitButton.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@ModelAttribute("user") User user) {

		if (user.getEmail().equals("alpha@email.com") && user.getUsername().equals("alpha")
				&& user.getPassword().equals("pass")) {

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
