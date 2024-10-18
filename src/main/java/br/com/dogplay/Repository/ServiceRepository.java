package br.com.dogplay.Repository;

import br.com.dogplay.models.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ServiceRepository extends JpaRepository<Servico, UUID> {

}