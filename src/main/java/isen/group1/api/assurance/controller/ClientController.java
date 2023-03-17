package isen.group1.api.assurance.controller;

import java.util.List;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Clients", description = "Endpoints pour les opérations sur les clients")
public class ClientController {

	@Autowired
	ClientService clientService;

	@GetMapping("/{client_id}/contrats")
	@Operation(summary = "Obtenir tous les contrats d'un client", description = "Récupère la liste de tous les contrats d'un client avec l'identifiant donné", tags = {"Clients"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Liste des contrats du client retournée", content = @Content(schema = @Schema(implementation = ContratDTO.class))),
			@ApiResponse(responseCode = "404", description = "Client non trouvé", content = @Content(schema = @Schema(implementation = Exception.class))),
			@ApiResponse(responseCode = "500", description = "Raison inconnu", content = @Content(schema = @Schema(implementation = Exception.class)))
	})
	public ResponseEntity<List<ContratDTO>> GetContratsFromClient(@PathVariable("client_id") Integer idClient) throws Exception {
		List<ContratDTO> listContrats = clientService.getAllContratsFromClientID(idClient);
		return ResponseEntity.status(HttpStatus.CREATED).body(listContrats);

	}

	@GetMapping("/{client_id}/contrats/{contrat_id}")
	@Operation(summary = "Obtenir un contrat d'un client", description = "Récupère un contrat d'un client avec les identifiants donnés", tags = {"Clients"})
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Contrat du client retourné", content = @Content(schema = @Schema(implementation = ContratDTO.class))),
			@ApiResponse(responseCode = "404", description = "Client ou contrat non trouvé", content = @Content(schema = @Schema(implementation = Exception.class))),
			@ApiResponse(responseCode = "500", description = "Raison inconnu", content = @Content(schema = @Schema(implementation = Exception.class)))
	})
	public ResponseEntity<ContratDTO> GetOneContratsFromClient(@PathVariable("client_id") Integer idClient, @PathVariable("contrat_id") Integer idContrat) throws Exception {
		ContratDTO contrat = clientService.getOneContratFromClientID(idClient, idContrat);
		return ResponseEntity.status(HttpStatus.CREATED).body(contrat);
	}
}
