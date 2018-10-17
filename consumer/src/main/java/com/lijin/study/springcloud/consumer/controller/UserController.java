package com.lijin.study.springcloud.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping(path = "/qryAll")
	public String qryAll() {
		return restTemplate.getForEntity("http://db-service/user/qryAll", String.class).getBody();
	}

	@GetMapping(path = "/qry/{id}")
	public String qryUser(@PathVariable int id) {
		return restTemplate.getForEntity("http://db-service/user/qry/" + id, String.class).getBody();
	}
	
}
