package isen.group1.api.assurance.service.imp;

import isen.group1.api.assurance.data.repository.ClientRepository;
import isen.group1.api.assurance.data.repository.ContratRepository;
import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;
import isen.group1.api.assurance.service.ConseillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConseillerServiceImpl implements ConseillerService {

    @Autowired
    private ContratRepository contratRepository;
    @Autowired
    private ClientRepository clientRepository;

    @Override
    public List<ClientDTO> getListClient(int idConseiller) {
        return this.clientRepository.findByIdConseiller(idConseiller);
    }

    @Override
    public List<ClientDTO> getListClientFromConseiller(int idConseiller) {
        List<ClientDTO> resultList = new ArrayList<>();
        List<ClientDTO> clientDTOList = this.clientRepository.findAll().stream().map(ClientDTO::new).collect(Collectors.toList());
        for (ClientDTO clientDTO : clientDTOList
             ) {
            if (clientDTO.getIdConseiller() == idConseiller) {
                resultList.add(clientDTO);
            }
        }
        return resultList;
    }

    @Override
    public void deleteClient(int idConseiller, int idClient) {
        List<ClientDTO> listClientConseille = getListClient(idConseiller);
        for (ClientDTO c : listClientConseille) {
            if (c.getId() == idClient)
                this.clientRepository.deleteById(idClient);
        }
    }

    @Override
    public void updateClient(int idConseiller, ClientDTO clientModif, int idClient) {
        List<ClientDTO> listClientConseille = getListClient(idConseiller);
        for (ClientDTO c : listClientConseille) {
            if (c.getId() == idClient)
                this.clientRepository.findById(idClient)
                        .map(p -> {
                            p.setIdConseiller(clientModif.getIdConseiller());
                            p.setAdresse(clientModif.getAdresse());
                            p.setNom(clientModif.getNom());
                            p.setPrenom(clientModif.getPrenom());
                            return this.clientRepository.save(p);
                        });
        }
    }

    public ContratDTO updateContrat(Integer contratId, ContratDTO contrat, Integer idConseiller) {
        ContratDTO contratDTO = new ContratDTO();
        List<ClientDTO> listClientConseille = getListClient(idConseiller);
        ContratDTO newContrat = null;
        for (ClientDTO c : listClientConseille) {
            if (c.getId() == contrat.getIdClient()) {
                if (this.contratRepository.findById(contratId).isPresent() && contratId.equals(contrat.getId())) {
                    contratDTO = this.contratRepository.findById(contratId).get().toDto();
                }
                contratDTO.setId(contrat.getId());
                contratDTO.setMensualite(contrat.getMensualite());
                contratDTO.setDateDebut(contrat.getDateDebut());
                contratDTO.setDateFin(contrat.getDateFin());
                newContrat = this.contratRepository.save(contratDTO.toEntity()).toDto();

            }
        }
        return newContrat;
    }

    public ContratDTO ajouterContrat(ContratDTO contrat, int idConseiller) {
        List<ClientDTO> listClientConseille = getListClient(idConseiller);
        ContratDTO newContrat = null;
        for (ClientDTO c : listClientConseille) {
            if (c.getId() == contrat.getIdClient())
                newContrat = this.contratRepository.save(contrat.toEntity()).toDto();
        }
        return newContrat;

    }

}
