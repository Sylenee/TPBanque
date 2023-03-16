package isen.group1.api.assurance.data.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import isen.group1.api.assurance.model.dto.ContratDTO;

@Repository
public class ClientRepository implements ClientRepositoryInterface{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ClientRepository() {
		super();
	}

	@Override
	public List<ContratDTO> getAllContratsFromClientID(int id){
		String sql = "Select * from contrat WHERE id_client=\""+id+"\"";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ContratDTO>(ContratDTO.class));
	}
	
	@Override
	public ContratDTO getOneContratFromClientID(int idClient, int idContrat){
		String sql = "Select * from contrat WHERE id_client=\""+idClient+"\" AND id=\""+idContrat+"\"";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ContratDTO>(ContratDTO.class)).get(0);
	}

}
