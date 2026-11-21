package es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.web.mvc.dto;

import java.time.LocalDateTime;

public record HabitacionResponse(
        int id,
        String numero,
        String tipo,
        double temperatura,
        double precio,
        LocalDateTime createdAt) {
}