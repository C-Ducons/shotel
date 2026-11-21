package es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.web.mvc.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import es.etg.daw.dawes.java.web.shotel.habitacion.application.command.CreateHabitacionCommand;
import es.etg.daw.dawes.java.web.shotel.habitacion.application.command.EditHabitacionCommand;
import es.etg.daw.dawes.java.web.shotel.habitacion.application.service.*;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.model.Habitacion;
import es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.mapper.HabitacionMapper;
import es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.web.mvc.dto.HabitacionRequest;
import es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.web.mvc.dto.HabitacionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/habitaciones")
@RequiredArgsConstructor
public class HabitacionController {

    private final CreateHabitacionService createHabitacionService;
    private final FindHabitacionService findHabitacionService;
    private final EditHabitacionService editHabitacionService;
    private final DeleteHabitacionService deleteHabitacionService;
    private final HabitacionMapper habitacionMapper;

    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public HabitacionResponse createHabitacion(@Valid @RequestBody HabitacionRequest request) {
        CreateHabitacionCommand comando = habitacionMapper.toCommand(request);
        Habitacion habitacion = createHabitacionService.createHabitacion(comando);
        return habitacionMapper.toResponse(habitacion);
    }

    @GetMapping
    @ResponseBody
    public List<HabitacionResponse> allHabitaciones() {
        return findHabitacionService.findAll().stream()
                .map(habitacionMapper::toResponse)
                .toList();
    }

    @PutMapping("/{id}")
    @ResponseBody
    public HabitacionResponse editHabitacion(@PathVariable int id, @Valid @RequestBody HabitacionRequest request) {
        EditHabitacionCommand comando = habitacionMapper.toCommand(id, request);
        Habitacion habitacion = editHabitacionService.update(comando);
        return habitacionMapper.toResponse(habitacion);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabitacion(@PathVariable int id) {
        deleteHabitacionService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
