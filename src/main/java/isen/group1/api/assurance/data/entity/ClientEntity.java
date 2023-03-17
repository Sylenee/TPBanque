package isen.group1.api.assurance.data.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import isen.group1.api.assurance.model.dto.ClientDTO;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "client")
@Entity
@NoArgsConstructor
@Getter
@Setter
public class ClientEntity implements Serializable {


	private static final long serialVersionUID = 1L;
	@Column(name = "id")
	@JsonIgnore
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")

	private String prenom;
	@Column(name = "adresse")

	private String adresse;
	@Column(name = "id_conseiller")
	private int idConseiller = -1;

	public ClientDTO toDto() {
		ClientDTO clientDTO = new ClientDTO();
		clientDTO.setIdConseiller(getIdConseiller());
		clientDTO.setNom(getNom());
		clientDTO.setPrenom(getPrenom());
		clientDTO.setId(getId());
		clientDTO.setAdresse(getAdresse());
		return clientDTO;
	}
}
