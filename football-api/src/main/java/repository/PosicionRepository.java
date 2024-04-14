package repository;
import org.springframework.data.jpa.repository.JpaRepository;
import model.Posicion;

public interface PosicionRepository extends JpaRepository<Posicion, Integer> {

}
