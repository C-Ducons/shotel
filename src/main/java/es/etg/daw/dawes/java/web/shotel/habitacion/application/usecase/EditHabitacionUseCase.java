package es.etg.daw.dawes.java.web.shotel.habitacion.application.usecase;

import es.etg.daw.dawes.java.web.shotel.habitacion.application.command.EditHabitacionCommand;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.error.HabitacionNotFoundException;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.model.Habitacion;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.repository.HabitacionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class EditHabitacionUseCase {
    private final HabitacionRepository habitacionRepository;

    public Habitacion update(EditHabitacionCommand comando) {
        Habitacion habitacion = habitacionRepository.getById(comando.id())
                .orElseThrow(() -> new HabitacionNotFoundException(comando.id()));

        habitacion.setTipo(comando.tipo());
        habitacion.setTemperatura(comando.temperatura());
        habitacion.setPrecio(comando.precio());

        return habitacionRepository.save(habitacion);
    }
}