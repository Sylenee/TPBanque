package isen.group1.api.assurance.service.imp;

import isen.group1.api.assurance.data.repository.ClientRepository;
import isen.group1.api.assurance.model.dto.ClientDTO;
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
		return null;
	}
	
	/*@Override
	public Integer nombreDePersonne() {
		return this.clientRepository.nombreDePersonne();
	}*/

	/*@Override
	public List<ClientDTO> getListeClient() {
		return this.clientRepository.findAll().stream().map(ClientDTO::new).collect(Collectors.toList());
	}*/

	/*@Override
	public void ajouterClient(ClientDTO client) {
		this.clientRepository.save(client.toEntity());
	}*/

}