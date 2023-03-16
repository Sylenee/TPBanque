package isen.group1.api.assurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import isen.group1.api.assurance.service.ClientService;

@RestController
@RequestMapping("/assurance")
public class ClientController {
	
	@Autowired
	ClientService clientService;
	
	@GetMapping("/hello")
	public Integer sayHello() {
		return clientService.nombreDePersonne();
	}
}
