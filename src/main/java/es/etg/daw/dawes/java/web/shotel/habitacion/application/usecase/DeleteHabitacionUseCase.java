package es.etg.daw.dawes.java.web.shotel.habitacion.application.usecase;

import es.etg.daw.dawes.java.web.shotel.habitacion.domain.error.HabitacionNotFoundException;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.repository.HabitacionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DeleteHabitacionUseCase {
    private final HabitacionRepository habitacionRepository;

    public void delete(int id) {
        if (habitacionRepository.getById(id).isEmpty()) {
            throw new HabitacionNotFoundException(id);
        }
        habitacionRepository.deleteById(id);
    }
}