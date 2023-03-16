package isen.group1.api.assurance.service.imp;

import isen.group1.api.assurance.data.repository.ContratRepository;
import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;
import isen.group1.api.assurance.service.ConseillerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConseillerServiceImpl implements ConseillerService {

    @Autowired
    private ContratRepository contratRepository;

    public List<ClientDTO> getListClient() {
        return null;
    }

    public String deleteClient(int i) {
        return null;
    }

    public ClientDTO updateClient(int i) {
        return null;
    }

    @Override
    public ContratDTO updateContrat(Integer contratId, ContratDTO contrat) {
        ContratDTO contratDTO = new ContratDTO();
        if (this.contratRepository.findById(contratId).isPresent() && contratId.equals(contrat.getId())) {
            contratDTO = this.contratRepository.findById(contratId).get().toDto();
        }
        contratDTO.setId(contrat.getId());
        contratDTO.setMensualite(contrat.getMensualite());
        contratDTO.setDateDebut(contrat.getDateDebut());
        contratDTO.setDateFin(contrat.getDateFin());
        return this.contratRepository.save(contratDTO.toEntity()).toDto();
    }

    @Override
    public ContratDTO ajouterContrat(ContratDTO contrat) {
        return this.contratRepository.save(contrat.toEntity()).toDto();
    }

    @Override
    public ContratDTO ajouterContrat(Integer clientId, ContratDTO contrat) {
        return this.contratRepository.save(contrat.toEntity()).toDto();
    }

    @Override
    public ContratDTO updateContrat(ContratDTO contrat) {
        ContratDTO contratDTO = new ContratDTO();
        if (this.contratRepository.findById(contrat.getId()).isPresent() ) {
            contratDTO = this.contratRepository.findById(contrat.getId()).get().toDto();
        }
        contratDTO.setId(contrat.getId());
        contratDTO.setMensualite(contrat.getMensualite());
        contratDTO.setDateDebut(contrat.getDateDebut());
        contratDTO.setDateFin(contrat.getDateFin());
        contratDTO.setType(contrat.getType());
        return this.contratRepository.save(contratDTO.toEntity()).toDto();    }

}
