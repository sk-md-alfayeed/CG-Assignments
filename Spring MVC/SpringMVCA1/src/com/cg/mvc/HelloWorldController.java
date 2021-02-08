package com.cg.mvc;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	@RequestMapping(value="index.html", method = RequestMethod.GET)
	public ModelAndView getAdmissionForm() {

		ModelAndView model = new ModelAndView("index");

		return model;
	}

	@RequestMapping(value="submitButton.html", method = RequestMethod.POST)
	public ModelAndView submitAdmissionForm() {

		ModelAndView model = new ModelAndView("helloWorld");
		model.addObject("msg","Hello World");

		return model;
	}
}