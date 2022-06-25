package com.yebelo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.yebelo.servicesImpl.FetchNextNumberServiceImpl;

@RestController
public class Controller {
	
	@Autowired
	private FetchNextNumberServiceImpl service;
	
	@GetMapping("/FetchNextNumber/{categoryCode}")
	public List<Integer> fetchNextNumberHanler(@PathVariable Integer categoryCode) {
		List<Integer> numbers= this.service.findValue(categoryCode);
		return  numbers;
	}
	
}
