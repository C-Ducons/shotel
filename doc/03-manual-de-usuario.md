# 3. Manual de Usuario

## 1. Arrancar la aplicación
1. Descarga o clona el repositorio y abre una terminal en la raíz del proyecto.
2. Ejecuta `./mvnw spring-boot:run` (en Windows: `mvnw.cmd spring-boot:run`).
3. Espera a ver el mensaje `Started ShotelApplication` en la consola.

## 2. Consultar habitaciones
Abre en tu navegador:
- `http://localhost:8080/habitaciones`

Verás el listado actual en formato JSON.

## 3. Crear una habitación
1. Abre `http://localhost:8080/formulario-crear-habitacion.html`.
2. Rellena el **Número** (ej. `401`), selecciona el **Tipo**, indica la **Temperatura (°C)** y el **Precio (€)**.
3. Pulsa **Crear Habitación**. El sistema devolverá los datos de la nueva habitación con su ID asignado.

## 4. Editar una habitación
1. Abre `http://localhost:8080/formulario-editar-habitacion.html`.
2. Introduce el **ID** de la habitación que quieras modificar (puedes consultarlo antes en `/habitaciones`), junto con los nuevos valores.
3. Pulsa **Modificar Habitación**.

## 5. Eliminar una habitación
1. Abre `http://localhost:8080/formulario-borrar-habitacion.html`.
2. Introduce el **ID** de la habitación a eliminar y pulsa **Eliminar Habitación**.
3. Si el ID existe, la pantalla quedará vacía (`204 No Content`) y desaparecerá del listado; si no existe, verás una página de error `404 Not Found`.