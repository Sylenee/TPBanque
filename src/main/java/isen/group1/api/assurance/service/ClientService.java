package isen.group1.api.assurance.service;

import java.util.List;

import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;

public interface ClientService {

	//List<ClientDTO> getListeClient();
	//void ajouterClient(ClientDTO client);
	public Integer nombreDePersonne();
	public List<ContratDTO> getClientContrats();
	ClientDTO getClient(int id);
}