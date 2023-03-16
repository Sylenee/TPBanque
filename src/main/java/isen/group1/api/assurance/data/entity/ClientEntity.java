package isen.group1.api.assurance.data.entity;

import java.io.Serializable;

import isen.group1.api.assurance.model.dto.ClientDTO;
import isen.group1.api.assurance.model.dto.ConseillerDTO;
import org.springframework.stereotype.Repository;

import javax.persistence.*;

@Table(name = "client")
@Entity
public class ClientEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "id")
	@Id
	private Integer id;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")

	private String prenom;
	@Column(name = "adresse")

	private String adresse;
	@Column(name = "id_conseiller")
	private Integer idConseiller;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
	}


	public Integer getIdConseiller() {
		return idConseiller;
	}


	public void setIdConseiller(Integer idConseiller) {
		this.idConseiller = idConseiller;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(final Integer id) {
		this.id = id;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(final String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return this.adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(final String adresse) {
		this.adresse = adresse;
	}

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
