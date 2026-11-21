package es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.web.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NumeroHabitacionValidator implements ConstraintValidator<NumeroHabitacion, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) return false;
        // 3 dígitos empezando por planta 1-9 (ej. 101, 204)
        return value.matches("^[1-9][0-9]{2}$");
    }
}