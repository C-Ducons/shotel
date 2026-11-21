package es.etg.daw.dawes.java.web.shotel.habitacion.application.service;

import es.etg.daw.dawes.java.web.shotel.habitacion.application.usecase.DeleteHabitacionUseCase;

public class DeleteHabitacionService {
    
    private final DeleteHabitacionUseCase deleteHabitacionUseCase;

    public void delete(int id){
        deleteHabitacionUseCase.delete(id);
    }
}
