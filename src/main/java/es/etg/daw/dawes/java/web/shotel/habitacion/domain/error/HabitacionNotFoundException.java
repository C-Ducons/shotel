package es.etg.daw.dawes.java.web.shotel.habitacion.domain.error;

import es.etg.daw.dawes.java.web.shotel.common.domain.error.EntityNotFoundException;

public class HabitacionNotFoundException extends EntityNotFoundException {
    public static final String ENTIDAD = "habitación";

    public HabitacionNotFoundException() {
        super(ENTIDAD);
    }

    public HabitacionNotFoundException(int id) {
        super(ENTIDAD, id);
    }
}