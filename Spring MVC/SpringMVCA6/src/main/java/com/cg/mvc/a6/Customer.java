package com.cg.mvc.a6;

import java.util.ArrayList;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.github.ankurpathak.password.bean.constraints.ContainDigit;
import com.github.ankurpathak.password.bean.constraints.ContainSpecial;
import com.github.ankurpathak.password.bean.constraints.NotContainWhitespace;

public class Customer {

	@NotEmpty(message = "Username should not be empty")
	@Size(min = 8, max = 20, message = "The username must be between 8 and 20")
	@NotContainWhitespace
	private String username;

	@NotContainWhitespace
	@ContainSpecial
	@ContainDigit
	@NotEmpty(message = "Password should not be empty")
	@Size(min = 8, max = 20, message = "The password must be between 8 and 20")
	private String password;

	@NotEmpty(message = "Email should not be empty")
	@Pattern(regexp = ".+@.+\\.[a-z]+", message = "Email is not valid")
	private String email;


	@Pattern(regexp = "(^$|[0-9]{10})", message = "The contact must be digits only")
	private String contact;

	private ArrayList<String> city;
 
	@Pattern(regexp = "(^$|[0-9]{6})", message = "The zipcode must be digits only")
	private String zipcode;

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ArrayList<String> getCity() {
		return city;
	}

	public void setCity(ArrayList<String> city) {
		this.city = city;
	}

}
