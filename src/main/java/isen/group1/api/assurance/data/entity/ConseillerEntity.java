package isen.group1.api.assurance.data.entity;

import isen.group1.api.assurance.model.dto.ConseillerDTO;
import isen.group1.api.assurance.model.dto.ContratDTO;
import lombok.*;

import javax.persistence.*;

@Table(name = "conseiller")
@Getter
@Entity
@Setter
@NoArgsConstructor
@ToString
public class ConseillerEntity {

    @Id
    @Column(name = "id")
    private Integer idConseiller;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "id_client")
    private String idClient;
    public ConseillerDTO toDto() {
        ConseillerDTO contratDTO = new ConseillerDTO();
        contratDTO.setIdConseiller(getIdConseiller());
        contratDTO.setNom(getNom());
        contratDTO.setPrenom(getPrenom());
        contratDTO.setIdClient(getIdClient());
        return contratDTO;
    }
}
