package isen.group1.api.assurance.data.repository.jpa;

import isen.group1.api.assurance.data.entity.ClientEntity;
import isen.group1.api.assurance.data.entity.ContratEntity;
import isen.group1.api.assurance.model.dto.ClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepositoryJPA  extends JpaRepository<ClientEntity, Integer> {
    List<ClientDTO> findByIdConseiller(int idConseiller);
}