package isen.group1.api.assurance.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;

@Table(name = "conseiller")
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ConseillerEntity {

    @Column(name = "id")
    private Integer idConseiller;

    @Column(name = "nom")
    private String nom;

    @Column(name = "prenom")
    private String prenom;

    @Column(name = "id_client")
    private String idClient;

}
