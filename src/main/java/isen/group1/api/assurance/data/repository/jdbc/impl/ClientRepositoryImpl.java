package isen.group1.api.assurance.data.repository.jdbc.impl;

import java.util.List;

import isen.group1.api.assurance.data.repository.jdbc.ClientRepositoryJDBC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import isen.group1.api.assurance.model.dto.ContratDTO;

@Repository
public class ClientRepositoryImpl implements ClientRepositoryJDBC {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ClientRepositoryImpl() {
		super();
	}

	@Override
	public List<ContratDTO> getAllContratsFromClientID(int id) throws Exception {
		if(!isExistingClient(id)){
			throw new Exception("Client with id : " + id + " not found");
		}
		String sql = "Select * from contrat WHERE id_client=?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ContratDTO>(ContratDTO.class), id);
	}
	
	@Override
	public ContratDTO getOneContratFromClientID(int idClient, int idContrat) throws Exception {
		if(!isExistingClient(idClient)){
			throw new Exception("Client with id : " + idClient + " not found");
		}
		if(!isExistingContrat(idContrat)){
			throw new Exception("Contrat with id : " + idContrat + " not found");
		}
		String sql = "Select * from contrat WHERE id_client=? AND id=?";
		List<ContratDTO> contrats = jdbcTemplate.query(sql, new BeanPropertyRowMapper<ContratDTO>(ContratDTO.class), idClient, idContrat);
		if(contrats == null || contrats.isEmpty()){
			throw new Exception("Le contrat : " + idContrat + " n'appartient pas au client : " + idClient);
		}
		return contrats.get(0);
	}

	@Override
	public boolean isExistingClient(int id){
		String sql = "Select COUNT(*) from client WHERE id=?";
		return this.jdbcTemplate.queryForObject(sql,Integer.class, id) == 1 ? true : false;
	}

	@Override
	public boolean isExistingContrat(int id){
		String sql = "Select COUNT(*) from contrat WHERE id=?";
		return this.jdbcTemplate.queryForObject(sql,Integer.class, id) == 1 ? true : false;
	}

}
