package es.etg.daw.dawes.java.web.shotel.habitacion.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.web.shotel.habitacion.application.usecase.DeleteHabitacionUseCase;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor 
@Service 
public class DeleteHabitacionService {
    
    private final DeleteHabitacionUseCase deleteHabitacionUseCase;

    public void delete(int id){
        deleteHabitacionUseCase.delete(id);
    }
}
