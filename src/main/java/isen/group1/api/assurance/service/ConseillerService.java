package isen.group1.api.assurance.service;

import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ConseillerService {
    List<ClientDTO> getListClient(int idConseiller);
    void deleteClient(int idConseiller, int idClient);
    void updateClient(int idConseiller, ClientDTO clientModif, int idClient);
    List<ClientDTO> getListClientFromConseiller(int idConseiller);
    ContratDTO ajouterContrat(ContratDTO contrat, int idConseiller);
    ContratDTO updateContrat(Integer idcontrat, ContratDTO contrat, Integer idConseiller);
    ClientDTO ajouterClient(ClientDTO clientDTO);
}
