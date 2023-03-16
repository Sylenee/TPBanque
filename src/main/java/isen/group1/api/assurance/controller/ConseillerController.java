package isen.group1.api.assurance.controller;


import isen.group1.api.assurance.data.entity.ClientEntity;
import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;
import isen.group1.api.assurance.service.ConseillerService;
import isen.group1.api.assurance.service.imp.ConseillerServiceImpl;
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

    @GetMapping("/listClient")
    public List<ClientDTO> getListClient() {
        return conseillerService.getListClient();
    }

    @PostMapping("/supprimer/client/{i}")
    public String createClient(int i) {
        return conseillerService.deleteClient(i);
    }

    @PutMapping("/modifier/client/{i}")
    public ClientDTO updateClient(int i) {
        return conseillerService.updateClient(i);
    }

    @PutMapping("/modifier/contrat/{i}")
    public ResponseEntity<ContratDTO> updateContrat(@RequestBody ContratDTO contrat, @PathVariable("contrat_id") Integer contratId) {
        this.conseillerService.updateContrat(contratId, contrat);
        return ResponseEntity.status(HttpStatus.OK).body(contrat);
    }

    @PostMapping("/ajouter/contrat/{i}")
    public ResponseEntity<ContratDTO> ajouterContrat(@RequestBody ContratDTO contrat) {
        // Ajouter le contrat dans la base de donnée
        // Renvoie une réponse 201 created avec le contrat créé dans la réponse
        this.conseillerService.ajouterContrat(contrat);
        return ResponseEntity.status(HttpStatus.CREATED).body(contrat);
    }
}
