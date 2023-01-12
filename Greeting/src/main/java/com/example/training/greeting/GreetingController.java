package com.example.training.greeting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
	@RequestMapping(path="/greet", method = RequestMethod.GET)
	public String greet() {
		return "Greetings! Welcome to Spring Boot Microservice";
	}
}

