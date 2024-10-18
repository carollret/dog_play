package br.com.dogplay.Repository;

import br.com.dogplay.models.Pets;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetsRepository extends JpaRepository<Pets, Long> {



}
