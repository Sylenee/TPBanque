package isen.group1.api.assurance.model.dto;

import isen.group1.api.assurance.data.entity.ContratEntity;

import javax.persistence.Column;
import java.io.Serializable;
import java.sql.Timestamp;

public class ContratDTO implements Serializable {

    private Integer id;
    private float mensualite;
    private String type;
    private Timestamp dateDebut;
    private Timestamp dateFin;

    public ContratDTO(Integer id, float mensualite, String type, Timestamp dateDebut, Timestamp dateFin) {
        this.id = id;
        this.mensualite = mensualite;
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public ContratDTO() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getMensualite() {
        return mensualite;
    }

    public void setMensualite(float mensualite) {
        this.mensualite = mensualite;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Timestamp getDateFin() {
        return dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
        this.dateFin = dateFin;
    }

    public ContratEntity toEntity() {
        ContratEntity contratEntity = new ContratEntity();
        contratEntity.setId(id);
        contratEntity.setMensualite(mensualite);
        contratEntity.setType(type);
        contratEntity.setDateDebut(dateDebut);
        contratEntity.setDateFin(dateFin);
        return contratEntity;
    }
}