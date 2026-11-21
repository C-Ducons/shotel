package es.etg.daw.dawes.java.web.shotel.habitacion.domain.repository;

import java.util.Optional;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.model.Habitacion;

public interface HabitacionRepository extends CRUDRepository<Habitacion, Integer> {
    Optional<Habitacion> getByNumero(String numero);
}
