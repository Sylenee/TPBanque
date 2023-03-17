package isen.group1.api.assurance.data.entity;

import isen.group1.api.assurance.model.dto.ContratDTO;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@Table(name = "CONTRAT")
public class ContratEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "mensualite")
    private float mensualite;
    @Column(name = "type")
    private String type;
    @Column(name = "dateDebut")
    private Timestamp dateDebut;
    @Column(name = "dateFin")
    private Timestamp dateFin;
    @Column(name ="id_client")
    private int clientId;

    public ContratEntity() {
        // Constructeur par défaut
    }

    public ContratEntity(int id, float mensualite, String type, Timestamp dateDebut, Timestamp dateFin, int clientId) {
        this.id = id;
        this.mensualite = mensualite;
        this.type = type;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.clientId = clientId;
    }

    public ContratDTO toDto() {
        ContratDTO contratDTO = new ContratDTO();
        contratDTO.setId(getId());
        contratDTO.setMensualite(getMensualite());
        contratDTO.setType(getType());
        contratDTO.setDateDebut(getDateDebut());
        contratDTO.setDateFin(getDateFin());
        contratDTO.setIdClient(getClientId());
        return contratDTO;
    }
}
