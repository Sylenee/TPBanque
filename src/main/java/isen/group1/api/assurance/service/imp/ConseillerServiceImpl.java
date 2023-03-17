package isen.group1.api.assurance.service.imp;

import isen.group1.api.assurance.data.repository.jpa.ClientRepositoryJPA;
import isen.group1.api.assurance.data.repository.jpa.ContratRepositoryJPA;
import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;
import isen.group1.api.assurance.service.ClientService;
import isen.group1.api.assurance.service.ConseillerService;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class ConseillerServiceImpl implements ConseillerService {

    @Autowired
    private ContratRepositoryJPA contratRepositoryJPA;
    @Autowired
    private ClientRepositoryJPA clientRepository;
    @Autowired
    ClientService clientService;

    @Override
    public List<ClientDTO> getListClient(int idConseiller) throws Exception{
        try {
            List<ClientDTO> listClient = this.clientRepository.findByIdConseiller(idConseiller);
                if(ObjectUtils.isEmpty(listClient))
                    throw new Exception("Le conseiller : "+ idConseiller + " n'existe pas");
            return listClient;
        }catch (Exception e){
            throw new Exception(e.getMessage());
        }
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
    public void deleteClient(int idConseiller, int idClient) throws Exception {
        boolean exist = false;
        List<ClientDTO> listClientConseille = getListClient(idConseiller);
        List<ContratDTO> listContrats = this.clientService.getAllContratsFromClientID(idClient);
        try {
            for (ClientDTO c : listClientConseille) {
                if (c.getId() == idClient) {
                    exist = true;
                    for (ContratDTO contrat : listContrats) {
                        this.contratRepositoryJPA.deleteById(contrat.getId());
                    }
                    this.clientRepository.deleteById(idClient);
                }
            }

            if(!exist)
                throw new Exception("Le client : "+ idClient +" n'appartient pas au conseiller : "+ idConseiller);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void updateClient(int idConseiller, ClientDTO clientModif, int idClient) throws Exception {
        List<ClientDTO> listClientConseille = getListClient(idConseiller);
        boolean clientExist = false;
        try{
            for (ClientDTO c : listClientConseille) {
                if (c.getId() == idClient) {
                    clientExist = true;
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
            if(!clientExist)
               throw new Exception("Le client : " + idClient + " n'appartient pas au conseiller : "+idConseiller);
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ContratDTO updateContrat(Integer contratId, ContratDTO contrat, Integer idConseiller) throws Exception {
        ContratDTO contratDTO = new ContratDTO();
        boolean clientExist = false;
        List<ClientDTO> listClientConseille = getListClient(idConseiller);
        ContratDTO newContrat = null;
        try{
            for (ClientDTO c : listClientConseille) {
                if (c.getId() == contrat.getIdClient()) {
                    clientExist = true;
                    List<ContratDTO> listContratclient = clientService.getAllContratsFromClientID(contrat.getIdClient());
                    for (ContratDTO unContrat : listContratclient) {
                        if (unContrat.getId() == contratId) {
                            contratDTO = this.contratRepositoryJPA.findById(contratId).get().toDto();
                            contratDTO.setId(contrat.getId());
                            contratDTO.setMensualite(contrat.getMensualite());
                            contratDTO.setDateDebut(contrat.getDateDebut());
                            contratDTO.setDateFin(contrat.getDateFin());
                            newContrat = this.contratRepositoryJPA.save(contratDTO.toEntity()).toDto();
                        }
                    }
                }
            }
            if (!clientExist)
                throw new Exception("Le client : " + contrat.getIdClient() + " n'appartient pas au conseiller : " + idConseiller);

            if (Objects.isNull(newContrat))
                throw new Exception("Le contrat : " + contrat.getId() + " n'appartient pas au client : " + contrat.getIdClient());

            return newContrat;

        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    public ContratDTO ajouterContrat(ContratDTO contrat, int idConseiller) throws Exception {
        List<ClientDTO> listClientConseille = getListClient(idConseiller);
        ContratDTO newContrat = null;
        try{
            for (ClientDTO c : listClientConseille) {
                if (c.getId() == contrat.getIdClient()){
                    newContrat = this.contratRepositoryJPA.save(contrat.toEntity()).toDto();
                }
            }
            if(ObjectUtils.isEmpty(newContrat))
                throw new Exception("Le contrat n'a pas pu être créé verifiez que le client : " + contrat.getIdClient()+ " appartient bien au conseiller : "+ idConseiller);
            return newContrat;
        }catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public ClientDTO ajouterClient(int idConseiller, ClientDTO clientDTO) throws Exception {
        if(clientDTO.getIdConseiller() != idConseiller)
            throw new Exception("L'id du conseiller ne corespond pas");
        try {
            return this.clientRepository.save(clientDTO.toEntity()).toDto();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

}
