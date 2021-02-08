package com.cg.mvc.a2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SimpleInterestController {

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {

		ModelAndView model = new ModelAndView("simpleInterest");

		return model;
	}

	@RequestMapping(value = "/submitButton.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm(@RequestParam("pAmount") double amount,
			@RequestParam("nYears") double years, @RequestParam("rInterest") double interest) {

		ModelAndView model = new ModelAndView("simpleInterest");
		model.addObject("msg", "Simple Interest is : " + amount * years * interest / 100);

		return model;
	}
}
