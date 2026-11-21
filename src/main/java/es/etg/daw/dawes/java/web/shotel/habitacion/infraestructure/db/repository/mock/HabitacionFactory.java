package es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.db.repository.mock;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.model.Habitacion;

public class HabitacionFactory {
    public static final Map<Integer, Habitacion> getDemoData() {
        Map<Integer, Habitacion> datos = new LinkedHashMap<>();
        datos.put(1, new Habitacion(1, "101", "Individual", 21.5, 75.0, LocalDateTime.now()));
        datos.put(2, new Habitacion(2, "202", "Doble Domótica", 22.0, 120.0, LocalDateTime.now()));
        datos.put(3, new Habitacion(3, "305", "Suite Automatizada", 20.5, 250.0, LocalDateTime.now()));
        return datos;
    }
}