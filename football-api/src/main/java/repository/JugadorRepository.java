package repository;
import org.springframework.data.jpa.repository.JpaRepository;
import model.Jugador;

public interface JugadorRepository extends JpaRepository<Jugador, Integer> {
}
