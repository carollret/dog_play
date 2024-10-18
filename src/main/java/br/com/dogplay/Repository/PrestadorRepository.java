package br.com.dogplay.Repository;

import br.com.dogplay.models.Prestador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrestadorRepository extends JpaRepository<Prestador, Long> {

}
