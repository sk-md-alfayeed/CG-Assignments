package com.cg.mvc.a6;


import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CustomerController {

	@RequestMapping(value = "/index.html", method = RequestMethod.GET)
	public ModelAndView getIndex() {

		ModelAndView model = new ModelAndView("registration");

		return model;
	}

	@RequestMapping(value = "/submitRegister.html", method = RequestMethod.POST)
	public ModelAndView submitRegister(@Valid @ModelAttribute("customer") Customer customer, BindingResult result) {
		
		 if (result.hasErrors()) {

			 ModelAndView model = new ModelAndView("registration");
				model.addObject("msg", "Registration Sucessful");
		 }

		ModelAndView model = new ModelAndView("registration");
		return model;

	
	}

}
