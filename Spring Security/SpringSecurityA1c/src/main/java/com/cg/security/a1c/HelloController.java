package com.cg.security.a1c;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	@RequestMapping("/")
	public String show() {
		return ("<h1>Hello World</h1>");

	}

	@RequestMapping("/user")
	public String showUser() {
		return ("<h1>Hello User</h1>");

	}

	@RequestMapping("/admin")
	public String showAdmin() {
		return ("<h1>Hello Admin</h1>");

	}

}
