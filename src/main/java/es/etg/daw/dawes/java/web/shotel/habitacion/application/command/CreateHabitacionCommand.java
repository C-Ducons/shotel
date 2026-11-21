package es.etg.daw.dawes.java.web.shotel.habitacion.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class CreateHabitacionCommand {
    private String numero;
    private String tipo;
    private double temperatura;
    private double precio;
}