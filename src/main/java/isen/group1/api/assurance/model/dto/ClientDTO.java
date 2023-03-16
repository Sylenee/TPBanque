package isen.group1.api.assurance.model.dto;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import isen.group1.api.assurance.data.entity.ClientEntity;

@Repository
public class ClientDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String nom;
	private String prenom;
	private String adresse;
	private int idConseiller;

	public ClientDTO(int id, String nom, String prenom, String adresse, int idConseiller) {
		System.out.println("test 4 + id = "+ id);
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.idConseiller = idConseiller;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	public ClientEntity toEntity(){
		ClientEntity clientEntity = new ClientEntity();
		clientEntity.setId(id);
		clientEntity.setNom(nom);
		clientEntity.setPrenom(prenom);
		clientEntity.setAdresse(adresse);
		clientEntity.setIdConseiller(idConseiller);
		return clientEntity;
	}

	public Integer getIdConseiller() {
		return idConseiller;
	}
	public void setIdConseiller(Integer idConseiller) {
		this.idConseiller = idConseiller;
	}
	/**
	 * @return the id
	 */
	public Integer getId() {
		return this.id;
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
	
	@Override
	public String toString() {
		return "ClientDTO [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", idConseiller=" + idConseiller + "]";
	}

}
