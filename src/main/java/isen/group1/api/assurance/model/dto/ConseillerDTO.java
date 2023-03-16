package isen.group1.api.assurance.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Table;
@Getter
@Setter
@AllArgsConstructor
@ToString
public class ConseillerDTO {

    private Integer idConseiller;

    private String nom;

    private String prenom;

    private String idClient;

}
