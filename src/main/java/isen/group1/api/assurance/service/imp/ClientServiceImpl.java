package isen.group1.api.assurance.service.imp;

import isen.group1.api.assurance.data.repository.ClientRepository;
import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;
import isen.group1.api.assurance.service.ClientService;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public Integer nombreDePersonne() {
		return this.clientRepository.nombreDePersonne();
	}

	public ClientDTO getClient(Integer id) {
		return this.clientRepository.getClient(id);
	}

	@Override
	public List<ContratDTO> getClientContrats() {
		// TODO Auto-generated method stub
		return null;
	}

}