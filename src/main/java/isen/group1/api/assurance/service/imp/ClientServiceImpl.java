package isen.group1.api.assurance.service.imp;

import isen.group1.api.assurance.data.repository.jdbc.impl.ClientRepositoryImpl;
import isen.group1.api.assurance.model.dto.ContratDTO;
import isen.group1.api.assurance.service.ClientService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
	@Autowired
	private ClientRepositoryImpl clientRepository;
	
	@Override
	public List<ContratDTO> getAllContratsFromClientID(int id) throws Exception {
		return this.clientRepository.getAllContratsFromClientID(id);
	}

	@Override
	public ContratDTO getOneContratFromClientID(int idClient, int idContrat) throws Exception {
		return this.clientRepository.getOneContratFromClientID(idClient, idContrat);
	}
}