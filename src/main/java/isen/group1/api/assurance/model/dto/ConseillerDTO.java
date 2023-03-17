package isen.group1.api.assurance.model.dto;

import isen.group1.api.assurance.data.entity.ConseillerEntity;
import isen.group1.api.assurance.data.entity.ContratEntity;
import lombok.*;

import javax.persistence.*;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ConseillerDTO implements Serializable {

    private Integer idConseiller;

    private String nom;

    private String prenom;

    private String idClient;
    public ConseillerEntity toEntity() {
        ConseillerEntity contratEntity = new ConseillerEntity();
        contratEntity.setIdConseiller(idConseiller);
        contratEntity.setIdClient(idClient);
        contratEntity.setNom(nom);
        contratEntity.setPrenom(prenom);
        return contratEntity;
    }
}
