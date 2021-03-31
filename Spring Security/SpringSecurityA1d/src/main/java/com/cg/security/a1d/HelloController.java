package com.cg.security.a1d;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	
	@GetMapping("/")
	public String show() {
		return ("<h1>Hello World</h1>");

	}

	@GetMapping("/user")
	public String showUser() {
		return ("<h1>Hello User</h1>");

	}

	@GetMapping("/admin")
	public String showAdmin() {
		return ("<h1>Hello Admin</h1>");

	}

}
