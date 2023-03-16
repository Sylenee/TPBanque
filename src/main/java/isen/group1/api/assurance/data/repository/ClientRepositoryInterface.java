package isen.group1.api.assurance.data.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;

@Repository
public interface ClientRepositoryInterface {

	public Integer nombreDePersonne();
	public List<ContratDTO> getClientContrats(int id);
	ClientDTO getClient(int id);
}
