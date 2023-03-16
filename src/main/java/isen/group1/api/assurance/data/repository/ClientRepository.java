package isen.group1.api.assurance.data.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ClientRepository implements ClientRepositoryInterface{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public ClientRepository() {
		super();
	}
	
	@Override
	public Integer nombreDePersonne() {
		String sql = "SELECT COUNT(*) FROM client";
		return this.jdbcTemplate.queryForObject(sql,Integer .class);
	}

}
