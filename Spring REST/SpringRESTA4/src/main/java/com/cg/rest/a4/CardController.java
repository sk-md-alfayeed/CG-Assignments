package com.cg.rest.a4;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CardController {

	String regex = "^(?:(?<visa>4[0-9]{12}(?:[0-9]{3})?)|" + "(?<mastercard>5[1-5][0-9]{14})|"
			+ "(?<discover>6(?:011|5[0-9]{2})[0-9]{12})|" + "(?<amex>3[47][0-9]{13})|"
			+ "(?<diners>3(?:0[0-5]|[68][0-9])?[0-9]{11})|" + "(?<jcb>(?:2131|1800|35[0-9]{3})[0-9]{11}))$";

	Pattern pattern = Pattern.compile(regex);

	@RequestMapping(value = "/card/{number}", method = RequestMethod.GET)
	public String checkCard(@PathVariable String number) {

		try {
			Matcher matcher = pattern.matcher(number);

			while (matcher.find()) {
				for (int i = 1; i <= matcher.groupCount(); i++) {
					if (matcher.group(i) != null) {
						if (i == 1) {
							return "Visa";
						} else if (i == 2) {
							return "Mater Card";
						} else if (i == 3) {
							return "Discover";
						} else if (i == 4) {
							return "Amex";
						} else if (i == 6) {
							return "JCB";
						}
						break;
					}
				}
			}
			return "card invalid";
		} catch (Exception e) {
			return "Exception : " + e;
		}

	}
}
