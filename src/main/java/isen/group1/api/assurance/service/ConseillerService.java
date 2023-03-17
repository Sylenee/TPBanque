package isen.group1.api.assurance.service;

import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ConseillerService {
    List<ClientDTO> getListClient(int idConseiller) throws Exception;
    void deleteClient(int idConseiller, int idClient) throws Exception;
    void updateClient(int idConseiller, ClientDTO clientModif, int idClient) throws Exception;
    List<ClientDTO> getListClientFromConseiller(int idConseiller);
    ContratDTO ajouterContrat(ContratDTO contrat, int idConseiller) throws Exception;
    ContratDTO updateContrat(Integer idcontrat, ContratDTO contrat, Integer idConseiller) throws Exception;
    ClientDTO ajouterClient(int idConseiller, ClientDTO clientDTO) throws Exception;
}
