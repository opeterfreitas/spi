package app.spi.repositories;

import app.spi.models.Despesa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DespesaRepository extends JpaRepository<Despesa, Long> {
}