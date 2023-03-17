package isen.group1.api.assurance.controller;


import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;
import isen.group1.api.assurance.service.ConseillerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conseiller")
@AllArgsConstructor
public class ConseillerController {

    @Autowired
    private ConseillerService conseillerService;

    @GetMapping("/{idConseiller}/listClient")
    public ResponseEntity<List<ClientDTO>> getListClient(@PathVariable("idConseiller")Integer idConseiller) {
        return ResponseEntity.status(HttpStatus.CREATED).body(conseillerService.getListClient(idConseiller));
    }

    @DeleteMapping("/{idConseiller}/supprimer/client/{idClient}")
    public ResponseEntity<Object> deleteClient(@PathVariable("idConseiller")Integer idConseiller, @PathVariable("idClient")Integer idClient) {
        conseillerService.deleteClient(idConseiller, idClient);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/{idConseiller}/modifier/client/{idClient}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable("idConseiller")Integer idConseiller, @RequestBody ClientDTO clientModif,@PathVariable("idClient") Integer idClient) {
        conseillerService.updateClient(idConseiller, clientModif, idClient);
        return ResponseEntity.status(HttpStatus.OK).body(clientModif);
    }

    @PutMapping("{idconseiller}/modifier/contrat/{idcontrat}")
    public ResponseEntity<ContratDTO> updateContrat(@RequestBody ContratDTO contrat, @PathVariable("idcontrat") Integer idcontrat,@PathVariable("idconseiller") Integer idConseiller) {
        contrat.setId(idcontrat);
        ContratDTO contratDTO = this.conseillerService.updateContrat(idcontrat, contrat, idConseiller);
        return ResponseEntity.status(HttpStatus.OK).body(contrat);
    }

    @PostMapping("{idconseiller}/ajouter/contrat/{idclient}")
    public ResponseEntity<ContratDTO> addContrat(@RequestBody ContratDTO contrat, @PathVariable("idclient") Integer idclient,@PathVariable("idconseiller") Integer idConseiller) {
        contrat.setIdClient(idclient);
        ContratDTO contratDTO = this.conseillerService.ajouterContrat(contrat, idConseiller);
        contrat = contratDTO;
        return ResponseEntity.status(HttpStatus.CREATED).body(contrat);
    }
}
