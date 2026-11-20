package es.etg.daw.dawes.java.web.shotel.habitacion.domain.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class Habitacion {

    // Atributos
    private int id;
    private String numero;
    private String tipo;
    private double temperatura;
    private double precio;
    private LocalDateTime createdAt;

}