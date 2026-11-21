package es.etg.daw.dawes.java.web.shotel.habitacion.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.web.shotel.habitacion.application.command.EditHabitacionCommand;
import es.etg.daw.dawes.java.web.shotel.habitacion.application.usecase.EditHabitacionUseCase;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.model.Habitacion;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class EditHabitacionService{
    
    private final EditHabitacionUseCase editHabitacionUseCase;

    public Habitacion update(EditHabitacionCommand comando){
        return editHabitacionUseCase.update(comando);
    }
}