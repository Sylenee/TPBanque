package isen.group1.api.assurance.data.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import isen.group1.api.assurance.model.dto.ContratDTO;

@Repository
public interface ClientRepositoryInterface {

	public List<ContratDTO> getAllContratsFromClientID(int id);
	public ContratDTO getOneContratFromClientID(int idClient, int idContrat);
}
