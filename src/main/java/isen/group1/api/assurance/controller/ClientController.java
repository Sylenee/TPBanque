package isen.group1.api.assurance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<ContratDTO>> GetContratsFromClient(@PathVariable("client_id") Integer idClient) throws Exception {
		List<ContratDTO> listContrats = clientService.getAllContratsFromClientID(idClient);
		return ResponseEntity.status(HttpStatus.CREATED).body(listContrats);

	}
	
	@GetMapping("/{client_id}/contrats/{contrat_id}")
	public ResponseEntity<ContratDTO> GetOneContratsFromClient(@PathVariable("client_id") Integer idClient, @PathVariable("contrat_id") Integer idContrat) throws Exception {
		ContratDTO contrat = clientService.getOneContratFromClientID(idClient, idContrat);
		return ResponseEntity.status(HttpStatus.CREATED).body(contrat);
	}
}
