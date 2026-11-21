package es.etg.daw.dawes.java.web.shotel.habitacion.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.web.shotel.habitacion.application.command.CreateHabitacionCommand;
import es.etg.daw.dawes.java.web.shotel.habitacion.application.usecase.CreateHabitacionUseCase;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.model.Habitacion;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor 
@Service 
public class CreateHabitacionService {
    private final CreateHabitacionUseCase createHabitacionUseCase;

    public Habitacion createHabitacion(CreateHabitacionCommand comando){
        return createHabitacionUseCase.create(comando);
    }
}
