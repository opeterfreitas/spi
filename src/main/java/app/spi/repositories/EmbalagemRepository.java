package app.spi.repositories;

import app.spi.models.Embalagem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmbalagemRepository extends JpaRepository<Embalagem, Long> {
}
