package isen.group1.api.assurance.model.dto;

import isen.group1.api.assurance.data.entity.ContratEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;
public class ContratDTO implements Serializable {

    private Integer id;

    public ContratDTO(ContratEntity contratEntity) {
        ContratDTO contratDTO = new ContratDTO();
        /*
        contratDTO.setId(contratEntity.getId());
        contratDTO.setMensualite(contratEntity.getMensualite());
        contratDTO.setType(contratEntity.getType());
        contratDTO.setDateDebut(contratEntity.getDateDebut());
        contratDTO.setDateFin(contratEntity.getDateFin());
        contratDTO.setIdClient(contratEntity.getClientId());
        return contratDTO;*/
        this.id = contratEntity.getId();
        this.mensualite = contratEntity.getMensualite();
        this.type = contratEntity.getType();
        this.dateDebut = contratEntity.getDateDebut();
        this.dateFin = contratEntity.getDateFin();
        this.idClient = contratEntity.getClientId();
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    private float mensualite;
    private String type;
    private Timestamp dateDebut;
    private Timestamp dateFin;
    private Integer idClient;

    public ContratDTO(Integer id, float mensualite, String type, Timestamp dateDebut, Timestamp dateFin, Integer idClient) {
        this.id = id;
        this.mensualite = mensualite;
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.idClient = idClient;
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
        if (id != null) {
            contratEntity.setId(id);
        }
        contratEntity.setMensualite(mensualite);
        contratEntity.setType(type);
        contratEntity.setDateDebut(dateDebut);
        contratEntity.setDateFin(dateFin);
        contratEntity.setClientId(idClient);
        return contratEntity;
    }
}
