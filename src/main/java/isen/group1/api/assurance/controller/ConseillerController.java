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
    public ResponseEntity<Object> createClient(@PathVariable("idConseiller")Integer idConseiller, @PathVariable("idClient")Integer idClient) {
        conseillerService.deleteClient(idConseiller, idClient);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @PutMapping("/{idConseiller}/modifier/client/{idClient}")
    public ResponseEntity<ClientDTO> updateClient(@PathVariable("idConseiller")Integer idConseiller, @RequestBody ClientDTO clientModif,@PathVariable("idClient") Integer idClient) {
        conseillerService.updateClient(idConseiller, clientModif, idClient);
        return ResponseEntity.status(HttpStatus.OK).body(clientModif);
    }

    @PutMapping("/modifier/contrat/{idcontrat}")
    public ResponseEntity<ContratDTO> updateContrat(@RequestBody ContratDTO contrat, @PathVariable("idcontrat") Integer idcontrat) {
        contrat.setId(idcontrat);
        ContratDTO contratDTO = this.conseillerService.updateContrat(contrat);
        return ResponseEntity.status(HttpStatus.OK).body(contrat);
    }

    @PostMapping("ajouter/client/{idconseiller}")
    public ResponseEntity<ClientDTO> ajouterClient(@RequestBody ClientDTO client, @PathVariable("idconseiller") Integer idconseiller) {
        client.setIdConseiller(idconseiller);
        ClientDTO clientDTO = this.conseillerService.ajouterClient(client);
        client = clientDTO;
        return ResponseEntity.status(HttpStatus.CREATED).body(client);
    }

    @PostMapping("/ajouter/contrat/{idclient}")
    public ResponseEntity<ContratDTO> ajouterContrat(@RequestBody ContratDTO contrat, @PathVariable("idclient") Integer idclient) {
        contrat.setIdClient(idclient);
        ContratDTO contratDTO = this.conseillerService.ajouterContrat(contrat);
        contrat = contratDTO;
        return ResponseEntity.status(HttpStatus.CREATED).body(contrat);
    }
}
