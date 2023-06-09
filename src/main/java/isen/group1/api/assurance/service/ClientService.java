package isen.group1.api.assurance.service;

import java.util.List;
import isen.group1.api.assurance.model.dto.ContratDTO;

public interface ClientService {

	public List<ContratDTO> getAllContratsFromClientID(int id) throws Exception;
	public ContratDTO getOneContratFromClientID(int idClient, int idContrat) throws Exception;
}