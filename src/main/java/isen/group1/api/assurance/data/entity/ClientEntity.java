package isen.group1.api.assurance.data.entity;

import java.io.Serializable;
import org.springframework.stereotype.Repository;

@Repository
public class ClientEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nom;
	private String prenom;
	private String adresse;
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

}
