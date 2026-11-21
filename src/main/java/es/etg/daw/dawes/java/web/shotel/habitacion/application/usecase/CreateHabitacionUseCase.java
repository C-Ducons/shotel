package es.etg.daw.dawes.java.web.shotel.habitacion.application.usecase;

import java.time.LocalDateTime;
import es.etg.daw.dawes.java.web.shotel.habitacion.application.command.CreateHabitacionCommand;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.model.Habitacion;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.repository.HabitacionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class CreateHabitacionUseCase {
    private final HabitacionRepository habitacionRepository;

    public Habitacion create(CreateHabitacionCommand comando) {
        Habitacion habitacion = Habitacion.builder()
                .numero(comando.numero())
                .tipo(comando.tipo())
                .temperatura(comando.temperatura())
                .precio(comando.precio())
                .createdAt(LocalDateTime.now())
                .build();

        return habitacionRepository.save(habitacion);
    }
}