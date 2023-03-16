package isen.group1.api.assurance.data.repository;

import isen.group1.api.assurance.data.entity.ClientEntity;
import isen.group1.api.assurance.data.entity.ContratEntity;
import isen.group1.api.assurance.model.dto.ClientDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository  extends JpaRepository<ClientDTO, Integer> {
}
