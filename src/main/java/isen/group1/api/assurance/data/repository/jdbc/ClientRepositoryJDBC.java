package isen.group1.api.assurance.data.repository.jdbc;

import isen.group1.api.assurance.model.dto.ContratDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepositoryJDBC {

    public List<ContratDTO> getAllContratsFromClientID(int id);
    public ContratDTO getOneContratFromClientID(int idClient, int idContrat);
    public boolean isExistingClient(int id);
}
