package es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.db.repository.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.stereotype.Repository;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.model.Habitacion;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.repository.HabitacionRepository;

@Repository
public class HabitacionRepositoryMockImpl implements HabitacionRepository {

    private final Map<Integer, Habitacion> habitaciones = HabitacionFactory.getDemoData();

    @Override
    public Habitacion save(Habitacion t) {
        if (t.getId() == 0) {
            t.setId(obtenerSiguienteId());
        }
        habitaciones.put(t.getId(), t);
        return t;
    }

    private int obtenerSiguienteId() {
        int ultimo = 0;
        for (Habitacion h : habitaciones.values()) {
            if (h.getId() > ultimo) {
                ultimo = h.getId();
            }
        }
        return ultimo + 1;
    }

    @Override
    public List<Habitacion> getAll() {
        return new ArrayList<>(habitaciones.values());
    }

    @Override
    public Optional<Habitacion> getById(Integer id) {
        return Optional.ofNullable(habitaciones.get(id));
    }

    @Override
    public void deleteById(Integer id) {
        habitaciones.remove(id);
    }

    @Override
    public Optional<Habitacion> getByNumero(String numero) {
        return habitaciones.values().stream()
                .filter(h -> h.getNumero().equalsIgnoreCase(numero))
                .findFirst();
    }
}