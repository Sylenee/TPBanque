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
	public List<ContratDTO> getAllContratsFromClientID(int id){
		String sql = "Select * from contrat WHERE id_client=?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ContratDTO>(ContratDTO.class), id);
	}
	
	@Override
	public ContratDTO getOneContratFromClientID(int idClient, int idContrat){
		String sql = "Select * from contrat WHERE id_client=? AND id=?";
		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<ContratDTO>(ContratDTO.class), idClient, idContrat).get(0);
	}

}
