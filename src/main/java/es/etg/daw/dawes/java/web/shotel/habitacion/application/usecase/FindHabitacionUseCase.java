package es.etg.daw.dawes.java.web.shotel.habitacion.application.usecase;

import java.util.List;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.error.HabitacionNotFoundException;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.model.Habitacion;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.repository.HabitacionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FindHabitacionUseCase {
    private final HabitacionRepository habitacionRepository;

    public List<Habitacion> findAll() {
        List<Habitacion> habitaciones = habitacionRepository.getAll();
        if (habitaciones.isEmpty()) {
            throw new HabitacionNotFoundException();
        }
        return habitaciones;
    }

    public Habitacion findById(int id) {
        return habitacionRepository.getById(id)
                .orElseThrow(() -> new HabitacionNotFoundException(id));
    }
}