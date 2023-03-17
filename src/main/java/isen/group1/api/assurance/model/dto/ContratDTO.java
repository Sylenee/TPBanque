package isen.group1.api.assurance.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import isen.group1.api.assurance.data.entity.ContratEntity;
import lombok.Getter;
import lombok.Setter;
import net.bytebuddy.implementation.bind.annotation.BindingPriority;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.Serializable;
import java.sql.Timestamp;
@Getter
@Setter
public class ContratDTO implements Serializable {

    @Schema(readOnly = true)
    private Integer id;

    public ContratDTO(ContratEntity contratEntity) {
        ContratDTO contratDTO = new ContratDTO();
        this.id = contratEntity.getId();
        this.mensualite = contratEntity.getMensualite();
        this.type = contratEntity.getType();
        this.dateDebut = contratEntity.getDateDebut();
        this.dateFin = contratEntity.getDateFin();
        this.idClient = contratEntity.getClientId();
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
