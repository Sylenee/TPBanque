package isen.group1.api.assurance.controller;


import isen.group1.api.assurance.data.entity.ClientEntity;
import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;
import isen.group1.api.assurance.service.imp.ConseillerServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/conseiller")
@AllArgsConstructor
public class ConseillerController {
    private final ConseillerServiceImpl conseillerService;

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
    public ContratDTO updateContrat(int i) {
        return conseillerService.updateContrat(i);
    }
}
