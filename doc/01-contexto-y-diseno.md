# 1. Contexto de la aplicación y Diseño

## Contexto de la aplicación

### Mundo real del problema
En la operativa diaria de un hotel, recepción y mantenimiento necesitan controlar no solo el inventario de habitaciones y tarifas, sino también parámetros domóticos como la climatización previa a la llegada del huésped. Cuando estos datos se gestionan en hojas de cálculo o sistemas cerrados heredados, es habitual introducir formatos de habitación erróneos, temperaturas fuera de rango o tarifas negativas.

### Qué aplicaciones existen
En el sector hotelero existen PMS (*Property Management Systems*) comerciales como **Opera Cloud**, **Cloudbeds** o **Mews**. Son herramientas muy completas, pero pesadas, de pago por licencia, acopladas a ecosistemas cerrados y sobredimensionadas para pequeños hoteles boutique o pruebas de concepto domóticas.

### Por qué SHotel es mejor para este caso
- **Ligera y enfocada:** cubre el ciclo CRUD completo de habitaciones domóticas sin curva de aprendizaje.
- **Validación estricta en la entrada:** impide registrar números de habitación inválidos o parámetros fuera de rango mediante reglas declarativas y validadores a medida.
- **Preparada para escalar:** su arquitectura desacoplada permite añadir módulos de reservas o sensores IoT reales y sustituir la memoria simulada por una base de datos relacional sin tocar el negocio.

---

## Diseño

### Casos de Uso (Funcionales)
**Actor externo:** Recepcionista / Administrador del hotel (a través del navegador web o cliente HTTP).

| ID   | Caso de Uso           | Actor         | Descripción |
|------|-----------------------|---------------|-------------|
| CU-1 | Listar habitaciones   | Administrador | Consulta todas las habitaciones disponibles en el sistema. |
| CU-2 | Crear habitación      | Administrador | Da de alta una habitación indicando número, tipo, temperatura y precio. |
| CU-3 | Editar habitación     | Administrador | Modifica el tipo, la temperatura y el precio de una habitación existente por su ID. |
| CU-4 | Eliminar habitación   | Administrador | Elimina del inventario una habitación existente por su ID. |

### Requisitos Funcionales (F) y No Funcionales (NF)

| Tipo | ID    | Descripción |
|------|-------|-------------|
| **F**  | RF-01 | El usuario se conecta para consultar el listado completo de habitaciones (`GET /habitaciones`). |
| **F**  | RF-02 | El usuario se conecta para registrar nuevas habitaciones mediante formulario web (`POST /habitaciones`). |
| **F**  | RF-03 | El usuario se conecta para modificar los datos de una habitación existente (`PUT /habitaciones/{id}`). |
| **F**  | RF-04 | El usuario se conecta para eliminar una habitación por su identificador (`DELETE /habitaciones/{id}`). |
| **NF** | RNF-01 | **Arquitectura:** Separación estricta en capas (*Clean Architecture*) organizada por áreas de negocio (*Vertical Slicing*). |
| **NF** | RNF-02 | **Persistencia:** Almacenamiento en memoria simulada con precarga inicial de 3 habitaciones al arrancar. |
| **NF** | RNF-03 | **Integridad:** Validación automática de entrada con mensajes externalizados en `messages.properties` y validador personalizado. |
| **NF** | RNF-04 | **Manejo de errores:** Respuestas homogéneas con fecha, código HTTP y mensaje ante cualquier fallo. |

---

### Arquitectura

El proyecto divide la responsabilidad en tres capas dentro del *slice* `habitacion`, de modo que el dominio no depende de Spring Boot ni de HTTP:

```text
src/main/java/es/etg/daw/dawes/java/web/shotel/
├── ShotelApplication.java
├── common/                          # Componentes transversales (GlobalExceptionHandler)
└── habitacion/
    ├── domain/                      # Núcleo de negocio puro
    │   ├── model/                   # Habitacion (entidad)
    │   ├── repository/              # CRUDRepository, HabitacionRepository (contratos)
    │   └── error/                   # HabitacionNotFoundException
    ├── application/                 # Casos de uso y servicios
    │   ├── command/                 # CreateHabitacionCommand, EditHabitacionCommand
    │   ├── usecase/                 # Create, Find, Edit, DeleteHabitacionUseCase
    │   └── service/                 # Create, Find, Edit, DeleteHabitacionService
    └── infraestructure/             # Adaptadores externos (Spring MVC, MapStruct, memoria)
        ├── config/                  # Configuración de beans
        ├── db/                      # HabitacionFactory, HabitacionRepositoryMockImpl
        ├── mapper/                  # HabitacionMapper (MapStruct)
        └── web/mvc/
            ├── controller/          # HabitacionController
            ├── dto/                 # HabitacionRequest, HabitacionResponse
            └── validation/          # Anotación y validador personalizado