<h1 align="center">SHotel — Gestión de Hotel Domótico</h1>

<p align="center">
  <img src="doc/images/hotel.jpeg" alt="SHotel" width="640">
</p>

<p align="center">
  Aplicación web para gestionar las habitaciones y parámetros domóticos de un hotel inteligente,<br>
  construida con Spring Boot, <em>Vertical Slicing</em> y Clean Architecture.
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Versi%C3%B3n-1.0.0-blue" alt="Versión 1.0.0">
  <img src="https://img.shields.io/badge/Java-17-ED8B00?logo=openjdk&logoColor=white" alt="Java 17">
  <img src="https://img.shields.io/badge/Spring_Boot-4.1.1-6DB33F?logo=springboot&logoColor=white" alt="Spring Boot 4.1.1">
  <img src="https://img.shields.io/badge/MapStruct-1.6.3-E5742A" alt="MapStruct 1.6.3">
  <img src="https://img.shields.io/badge/Maven-wrapper-C71A36?logo=apachemaven&logoColor=white" alt="Maven">
</p>

---

## Ficha del proyecto

| Campo          | Detalle                                      |
|----------------|----------------------------------------------|
| **Aplicación** | SHotel (Smart Hotel Domótico)                |
| **Versión**    | `1.0.0`                                      |
| **Integrante** | Carlos [Tu Apellido]                         |
| **Módulo**     | Desarrollo Web en Entorno Servidor (2º DAW)  |

## Sobre el proyecto

SHotel gestiona el catálogo y los parámetros domóticos (temperatura, tipo de estancia y tarifa) de las habitaciones de un hotel inteligente mediante una aplicación web con Spring Boot. Está diseñada con **Vertical Slicing** y **Clean Architecture** para poder crecer por áreas de negocio (reservas, huéspedes, sensores) y cambiar el sistema de persistencia sin modificar la lógica de negocio.

## Funcionalidades

| Funcionalidad        | Endpoint                    | Detalle                                            |
|----------------------|-----------------------------|----------------------------------------------------|
| Listar Habitaciones  | `GET /habitaciones`         | Devuelve el catálogo completo en formato JSON      |
| Crear Habitación     | `POST /habitaciones`        | Valida los datos (incluyendo validación a medida) y asigna ID |
| Editar Habitación    | `PUT /habitaciones/{id}`    | Actualiza tipo, temperatura y precio               |
| Eliminar Habitación  | `DELETE /habitaciones/{id}` | Elimina la habitación indicada                     |

Todos los errores se gestionan de forma centralizada devolviendo el código HTTP correspondiente (`400`, `404` o `500`) con fecha y mensaje descriptivo.

## Navegación a la documentación (`doc/`)

| Documento | Contenido |
|-----------|-----------|
| [1. Contexto y Diseño](doc/01-contexto-y-diseno.md) | Problema real, comparativa, casos de uso, requisitos F/NF, arquitectura, errores y plan de pruebas |
| [2. Implementación y Pruebas](doc/02-implementacion-y-pruebas.md) | Entorno, versiones, puesta en producción, capturas de ejecución, pruebas y elementos destacables |
| [3. Manual de Usuario](doc/03-manual-de-usuario.md) | Guía paso a paso para arrancar y usar los formularios y endpoints |
| [4. Conclusiones, Referencias y Anexos](doc/04-conclusiones-y-anexos.md) | Conclusiones individuales, bibliografía y anexos |