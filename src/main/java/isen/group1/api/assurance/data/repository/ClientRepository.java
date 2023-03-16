package isen.group1.api.assurance.data.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.swing.tree.RowMapper;
import javax.swing.tree.TreePath;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import isen.group1.api.assurance.model.dto.ContratDTO;
import isen.group1.api.assurance.model.dto.ClientDTO;

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
		return this.jdbcTemplate.queryForObject(sql,Integer.class);
	}

	@Override
	public List<ContratDTO> getClientContrats(int id){
		String query = "SELECT * FROM EMPLOYEE WHERE ID = ?";
		//ClientDTO client = (ClientDTO) jdbcTemplate.queryForList(query, new Object[] { id }, new ClientRowMapper());
		return null;
	}
	
	
	
	
	
	@SuppressWarnings("deprecation")
	@Override
	public ClientDTO getClient(int id) {
		System.out.println("test + id = "+id);
		String sql = "SELECT * FROM client WHERE id = ?";
		System.out.println("test 2");
		return this.jdbcTemplate.queryForObject(sql, new Object[] { id }, ClientDTO.class);
	}
	
	
	
	/*public class ClientRowMapper implements RowMapper {
	    public ClientDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
	        ClientDTO client = new ClientDTO();

	        client.setId(rs.getInt("ID"));
	        client.setNom(rs.getString("nom"));
	        client.setPrenom(rs.getString("prenom"));
	        client.setAdresse(rs.getString("adresse"));
	        client.setIdConseiller(rs.getInt("idConseiller"));

	        return client;
	    }

		@Override
		public int[] getRowsForPaths(TreePath[] path) {
			// TODO Auto-generated method stub
			return null;
		}

	}*/

}
