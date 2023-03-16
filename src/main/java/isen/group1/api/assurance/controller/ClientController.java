package isen.group1.api.assurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import isen.group1.api.assurance.model.dto.ContratDTO;
import isen.group1.api.assurance.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
	
	@Autowired
	ClientService clientService;
		
	@GetMapping("/{client_id}/contrats")
	public List<ContratDTO> GetContratsFromClient(@PathVariable("client_id") Integer idClient) {
		return clientService.getAllContratsFromClientID(idClient);
	}
	
	@GetMapping("/{client_id}/contrats/{contrat_id}")
	public ContratDTO GetOneContratsFromClient(@PathVariable("client_id") Integer idClient, @PathVariable("contrat_id") Integer idContrat) {
		return clientService.getOneContratFromClientID(idClient, idContrat);
	}
}
