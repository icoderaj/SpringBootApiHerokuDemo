package com.springrest.springrest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ApiController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private static String urlCountries="https://restcountries.eu/rest/v2/all"; 
	
	private static String urlTodo="https://jsonplaceholder.typicode.com/todos";
	
	//get all countries lists from an external api end point
	@GetMapping("/allcountries")
	public List<Object> getCountries(){
		Object[] countries= restTemplate.getForObject(urlCountries, Object[].class);
		
		return Arrays.asList(countries);
	}
	
	//get all todo lists from an external api end point
	@GetMapping("/alltodo")
	public List<Object> getTodo(){
		Object[] todo= restTemplate.getForObject(urlTodo, Object[].class);
		
		return Arrays.asList(todo);
	}
	

}
