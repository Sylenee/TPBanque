package isen.group1.api.assurance.model.dto;

import java.io.Serializable;
import isen.group1.api.assurance.data.entity.ClientEntity;
import isen.group1.api.assurance.data.entity.ContratEntity;




public class ClientDTO implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String nom;

	private String prenom;

	private String adresse;
	private Integer idConseiller;
	public ClientDTO() {
		super();
	}
	public ClientDTO(final ClientEntity clientEntity) {
		this.id = clientEntity.getId();
		this.nom = clientEntity.getNom();
		this.prenom = clientEntity.getPrenom();
		this.adresse = clientEntity.getAdresse();
		this.idConseiller = clientEntity.getIdConseiller();
	}


    public ClientEntity toEntity(){
		ClientEntity clientEntity = new ClientEntity();
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
