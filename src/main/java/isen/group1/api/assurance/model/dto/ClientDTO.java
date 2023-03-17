package isen.group1.api.assurance.model.dto;

import java.io.Serializable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Repository;
import isen.group1.api.assurance.data.entity.ClientEntity;
import isen.group1.api.assurance.data.entity.ContratEntity;



@Repository
@Getter
@Setter
public class ClientDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Schema(readOnly = true)

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

	@Override
	public String toString() {
		return "ClientDTO [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", idConseiller=" + idConseiller + "]";
	}

}
