package isen.group1.api.assurance.service;

import java.util.List;
import isen.group1.api.assurance.model.dto.ContratDTO;

public interface ClientService {

	List<ContratDTO> getAllContratsFromClientID(int id);
	ContratDTO getOneContratFromClientID(int idClient, int idContrat);
}