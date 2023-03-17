package isen.group1.api.assurance.controller;


import io.swagger.v3.oas.annotations.Operation;
import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;
import isen.group1.api.assurance.service.ConseillerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conseiller")
@AllArgsConstructor
@Tag(name = "Conseiller", description = "Endpoints pour les opérations sur les conseillers")
public class ConseillerController {

    @Autowired
    private ConseillerService conseillerService;

    @GetMapping("/{idConseiller}/listClient")
    @Operation(summary = "Récupère la liste des clients d'un conseiller", description = "Récupère la liste des clients d'un conseiller à partir de l'ID du conseiller.")
    public ResponseEntity<List<ClientDTO>> getListClient(@PathVariable("idConseiller")Integer idConseiller) throws Exception{
        return ResponseEntity.status(HttpStatus.CREATED).body(conseillerService.getListClient(idConseiller));
    }

    @DeleteMapping("/{idConseiller}/supprimer/client/{idClient}")
    @Operation(summary = "Supprime un client d'un conseiller", description = "Supprime un client d'un conseiller à partir de l'ID du conseiller et de l'ID du client.")
    public ResponseEntity<Object> deleteClient(@PathVariable("idConseiller")Integer idConseiller, @PathVariable("idClient")Integer idClient) throws Exception {
        conseillerService.deleteClient(idConseiller, idClient);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @PostMapping("/{idConseiller}/ajouter/client")
    public ResponseEntity<Object> addClient(@PathVariable("idConseiller")Integer idConseiller, @RequestBody ClientDTO newClient) throws Exception {
        ClientDTO clientNew = conseillerService.ajouterClient(idConseiller, newClient);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientNew);
    }

    @PutMapping("/{idConseiller}/modifier/client/{idClient}")
    @Operation(summary = "Met à jour un client d'un conseiller", description = "Met à jour un client d'un conseiller à partir de l'ID du conseiller, l'ID du client et des informations de mise à jour du client.")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable("idConseiller")Integer idConseiller, @RequestBody ClientDTO clientModif,@PathVariable("idClient") Integer idClient) throws Exception {
        conseillerService.updateClient(idConseiller, clientModif, idClient);
        return ResponseEntity.status(HttpStatus.OK).body(clientModif);
    }

    @PutMapping("{idconseiller}/modifier/contrat/{idcontrat}")
    @Operation(summary = "Met à jour un contrat d'un conseiller", description = "Met à jour un contrat d'un conseiller à partir de l'ID du conseiller, l'ID du contrat et des informations de mise à jour du contrat.")
    public ResponseEntity<ContratDTO> updateContrat(@RequestBody ContratDTO contrat, @PathVariable("idcontrat") Integer idcontrat,@PathVariable("idconseiller") Integer idConseiller) throws Exception {
        contrat.setId(idcontrat);
        ContratDTO contratDTO = this.conseillerService.updateContrat(idcontrat, contrat, idConseiller);
        return ResponseEntity.status(HttpStatus.OK).body(contrat);
    }

    @PostMapping("{idconseiller}/ajouter/contrat/{idclient}")
    @Operation(summary = "Ajouter un contrat", description = "Ajoute un nouveau contrat pour un client donné et un conseiller donné")
    public ResponseEntity<ContratDTO> addContrat(@RequestBody ContratDTO contrat, @PathVariable("idclient") Integer idclient,@PathVariable("idconseiller") Integer idConseiller) throws Exception {
        contrat.setIdClient(idclient);
        ContratDTO contratDTO = this.conseillerService.ajouterContrat(contrat, idConseiller);
        contrat = contratDTO;
        return ResponseEntity.status(HttpStatus.CREATED).body(contrat);
    }
}
