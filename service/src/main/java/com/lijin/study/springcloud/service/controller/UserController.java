package com.lijin.study.springcloud.service.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lijin.study.springcloud.service.dao.UserRepository;
import com.lijin.study.springcloud.service.dao.entity.User;

@RestController
@RequestMapping(path="/user")
public class UserController {
	
	private final static Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private DiscoveryClient discoverclient;

	@GetMapping(path = "/add") // Map ONLY GET Requests
	public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String email) {
		User n = new User();
		n.setName(name);
		n.setEmail(email);
		userRepository.save(n);
		return "Saved";
	}
	
	@GetMapping(path = "/qryAll")
	public @ResponseBody Iterable<User> qryAll() {
		List<String> services = discoverclient.getServices();
		services.forEach((svc) -> {
			logger.info(svc);
		});
		return userRepository.findAll();
	}

	@GetMapping(path = "/qry/{id}")
	public @ResponseBody Optional<User> qryUser(@PathVariable int id) {
		return userRepository.findById(id);
	}
}
