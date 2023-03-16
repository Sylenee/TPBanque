package isen.group1.api.assurance.service;

import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ConseillerService {
    public List<ClientDTO> getListClient();
    public String deleteClient(int i);
    public ClientDTO updateClient(int i);
    public ContratDTO updateContrat(Integer contratId, ContratDTO contrat);
    public ContratDTO ajouterContrat(ContratDTO contrat);
    }
