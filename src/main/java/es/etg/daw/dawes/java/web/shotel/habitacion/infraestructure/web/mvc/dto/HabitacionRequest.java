package es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.web.mvc.dto;

import es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.web.validation.NumeroHabitacion;
import jakarta.validation.constraints.*;

public record HabitacionRequest(
        @NotBlank(message = "{habitacion.valid.numero.no_vacio}")
        @NumeroHabitacion(message = "{habitacion.valid.numero.formato}")
        String numero,
        @NotBlank(message = "{habitacion.valid.tipo.no_vacio}")
        String tipo,
        @Min(value = 15, message = "{habitacion.valid.temperatura.min}")
        @Max(value = 30, message = "{habitacion.valid.temperatura.max}")
        double temperatura,
        @Min(value = 0, message = "{habitacion.valid.precio.min}")
        double precio) {
}