package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class GreetingController {
	
	@Autowired
	ConfigData configData;

	String manageEmployeeUrl = "http://localhost:9060/employees/";
	
	//Endpoint : /greet?empId=100
	@GetMapping("/greet")
	public String greetUser(@RequestParam Integer empId) {
		//Construct http://localhost:8080/employees/{empId}
		//String manageEmployeeRequestUrl = manageEmployeeUrl + empId;
		String manageEmployeeRequestUrl = configData.getManageEmployeeUrl() + empId;
		
		//Constructing REST Client object
		RestTemplate restTemplate = new RestTemplate();
		
		//Performing GET + http://localhost:8080/employees/{empId} invocation
		ResponseEntity<Employee> restResponse = restTemplate.getForEntity(manageEmployeeRequestUrl, Employee.class);
		
		//Checking if response has body
		if(restResponse.hasBody()) {
			//Converting response JSON to employee object
			Employee employee = restResponse.getBody();
			//Constructing the GreetMS response
			String response = "Greetings "+employee.getEmpName()+ "! Welcome to Microservices";
			//Returning response
			return response;
		}else {
			return null;
		}
	}
}

