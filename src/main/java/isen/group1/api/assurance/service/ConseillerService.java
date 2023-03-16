package isen.group1.api.assurance.service;

import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ConseillerService {
    public List<ClientDTO> getListClient(int idConseiller);
    public void deleteClient(int idConseiller, int idClient);
    public void updateClient(int idConseiller, ClientDTO clientModif, int idClient);
    public List<ClientDTO> getListClientFromConseiller(int idConseiller);

    public ContratDTO updateContrat(Integer contratId, ContratDTO contrat);
    public ContratDTO ajouterContrat(ContratDTO contrat);
    public ContratDTO ajouterContrat(Integer clientId, ContratDTO contratDTO);

    ContratDTO updateContrat(ContratDTO contrat);
}
