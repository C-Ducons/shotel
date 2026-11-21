package es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import es.etg.daw.dawes.java.web.shotel.habitacion.application.command.CreateHabitacionCommand;
import es.etg.daw.dawes.java.web.shotel.habitacion.application.command.EditHabitacionCommand;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.model.Habitacion;
import es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.web.mvc.dto.HabitacionRequest;
import es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.web.mvc.dto.HabitacionResponse;

@Mapper(componentModel = "spring")
public interface HabitacionMapper {
    CreateHabitacionCommand toCommand(HabitacionRequest request);

    HabitacionResponse toResponse(Habitacion habitacion);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "request.tipo", target = "tipo")
    @Mapping(source = "request.temperatura", target = "temperatura")
    @Mapping(source = "request.precio", target = "precio")
    EditHabitacionCommand toCommand(int id, HabitacionRequest request);
}