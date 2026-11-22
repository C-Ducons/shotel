# 4. Conclusiones, Referencias y Anexos

## Conclusiones (individuales)
El desarrollo de **SHotel** me ha permitido consolidar el trabajo con **Spring Boot** aplicando **Clean Architecture** y **Vertical Slicing** de principio a fin. Separar el dominio de la infraestructura exige crear más clases al inicio, pero facilita enormemente localizar errores, añadir validaciones a medida y entender exactamente qué responsabilidad tiene cada paquete. Además, resolver problemas reales como el `Content-Type` entre formularios HTML y `@RequestBody` o gestionar el proyecto con **Git Flow** ha reforzado la parte práctica de cara a proyectos reales.

## Referencias y bibliografía
- Documentación oficial de Spring Boot: [https://docs.spring.io/spring-boot/](https://docs.spring.io/spring-boot/)
- Documentación oficial de MapStruct: [https://mapstruct.org/documentation/stable/reference/html/](https://mapstruct.org/documentation/stable/reference/html/)
- Documentación de Jakarta Bean Validation: [https://beanvalidation.org/](https://beanvalidation.org/)
- Apuntes y práctica de referencia de clase (*Desarrollo Web en Entorno Servidor*, IES Enrique Tierno Galván).

## Anexos
- **Repositorio GitHub:** [https://github.com/C-Ducons/shotel](https://github.com/C-Ducons/shotel)
- **Comandos útiles de verificación:**
  - Listar clases del proyecto: `find src -name "*.java"`
  - Ejecutar compilación sin arrancar servidor: `./mvnw clean compile`