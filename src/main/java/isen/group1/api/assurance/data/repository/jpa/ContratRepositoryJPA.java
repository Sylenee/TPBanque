package isen.group1.api.assurance.data.repository.jpa;

import isen.group1.api.assurance.data.entity.ContratEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratRepositoryJPA extends JpaRepository <ContratEntity, Integer> {


}
