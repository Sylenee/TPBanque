package isen.group1.api.assurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isen.group1.api.assurance.model.dto.ClientDTO;
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
	
	@GetMapping("/test/{compte_id}")
	public String GetClient(@PathVariable("compte_id") Integer compteId) {
		String a = clientService.getClient(compteId).getAdresse();
		System.out.println("test 3");
		return a;
	}
}
