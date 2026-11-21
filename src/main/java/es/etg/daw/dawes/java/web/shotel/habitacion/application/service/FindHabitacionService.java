package es.etg.daw.dawes.java.web.shotel.habitacion.application.service;

import org.springframework.stereotype.Service;

import es.etg.daw.dawes.java.web.shotel.habitacion.application.usecase.FindHabitacionUseCase;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class FindHabitacionService {
    
    private final FindHabitacionUseCase findHabitacionUseCase;

    public List<Habitacion> findAll() {
        return findHabitacionUseCase.findAll();
    }
}
