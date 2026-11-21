package es.etg.daw.dawes.java.web.shotel.habitacion.application.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.Accessors;

@Getter
@AllArgsConstructor
@Accessors(fluent = true)
public class EditHabitacionCommand {
    private int id;
    private String tipo;
    private double temperatura;
    private double precio;
}