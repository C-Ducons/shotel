package es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.web.validation;

import java.lang.annotation.*;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NumeroHabitacionValidator.class)
@Documented
public @interface NumeroHabitacion {
    String message() default "{habitacion.valid.numero.formato}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}