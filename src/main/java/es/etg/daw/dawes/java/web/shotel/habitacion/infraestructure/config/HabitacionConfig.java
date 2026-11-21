package es.etg.daw.dawes.java.web.shotel.habitacion.infraestructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import es.etg.daw.dawes.java.web.shotel.habitacion.application.service.*;
import es.etg.daw.dawes.java.web.shotel.habitacion.application.usecase.*;
import es.etg.daw.dawes.java.web.shotel.habitacion.domain.repository.HabitacionRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class HabitacionConfig {

    private final HabitacionRepository habitacionRepository;

    @Bean
    public CreateHabitacionUseCase createHabitacionUseCase() {
        return new CreateHabitacionUseCase(habitacionRepository);
    }

    @Bean
    public CreateHabitacionService createHabitacionService() {
        return new CreateHabitacionService(createHabitacionUseCase());
    }

    @Bean
    public FindHabitacionUseCase findHabitacionUseCase() {
        return new FindHabitacionUseCase(habitacionRepository);
    }

    @Bean
    public FindHabitacionService findHabitacionService() {
        return new FindHabitacionService(findHabitacionUseCase());
    }

    @Bean
    public EditHabitacionUseCase editHabitacionUseCase() {
        return new EditHabitacionUseCase(habitacionRepository);
    }

    @Bean
    public EditHabitacionService editHabitacionService() {
        return new EditHabitacionService(editHabitacionUseCase());
    }

    @Bean
    public DeleteHabitacionUseCase deleteHabitacionUseCase() {
        return new DeleteHabitacionUseCase(habitacionRepository);
    }

    @Bean
    public DeleteHabitacionService deleteHabitacionService() {
        return new DeleteHabitacionService(deleteHabitacionUseCase());
    }
}