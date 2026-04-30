## API de Franquicias
API REST para la gestión de franquicias, sucursales y productos. Desarrollada con Spring Boot, MongoDB y Clean Architecture.

## Requisitos
Antes de comenzar, asegúrate de tener instaladas las siguientes herramientas en tu equipo:
*   **Java 17**: Necesario para ejecutar el núcleo de la aplicación.
*   **Conexión a Internet**: Requerida para que la aplicación se comunique con el clúster de base de datos alojado en la nube.
*   **Git**: Para clonar el proyecto en tu máquina local.

---

## 1. Descarga e Instalación

Sigue estos pasos para tener el proyecto listo en tu computadora:

1.1  **Clonar el repositorio:**
Abre una terminal y ejecuta el siguiente comando:
```bash
git clone [https://github.com/Diegogv23/prueba-tecnica-franquicias.git](https://github.com/Diegogv23/prueba-tecnica-franquicias.git)
```
1.2  **Entrar a la carpeta:**
```bash
    cd prueba-tecnica-franquicias
```

---

##  2. Cómo Ejecutar la Aplicación

Como valor agregado para la resolución de esta prueba técnica, la base de datos se encuentra provisionada en la nube usando MongoDB Atlas. Esto facilita la ejecución local, ya que no es necesario levantar contenedores de Docker ni configurar motores de base de datos; la aplicación se conectará automáticamente al servidor remoto.

Para iniciar la API, simplemente abre tu terminal en la raíz del proyecto y ejecuta:

```bash
./mvnw spring-boot:run
```
(Si usas Windows y el comando falla, intenta con 
```bash
mvnw.cmd spring-boot:run)
 ```
Cuando veas el mensaje Started FranquiciasApplication, la API estará en línea!

---
## 3. Cómo usar la API (Swagger UI)

Para facilitar la interacción con los endpoints sin necesidad de herramientas externas como Postman, he implementado Swagger. Esto permite probar cada función directamente desde el navegador.

### 3.1 Abre tu navegador preferido.

### 3.2 Ingresa a la siguiente dirección:

http://localhost:8080/webjars/swagger-ui/index.html

Desde aquí podrás:

* **Crear Franquicias:** Usando el endpoint POST.

* **Gestionar Sucursales:** Agregar nuevas sedes a una franquicia.

* **Controlar Inventario:** Agregar productos, eliminar y actualizar el stock.

* **Consultar Top Stock:** Ver qué producto lidera cada sucursal de una franquicia puntual.

---

## 4. Pruebas Unitarias

La calidad del código está respaldada por pruebas unitarias. Para ejecutarlas y verificar que todo funciona correctamente, usa:
```bash
./mvnw test
```

---
## 5. Monitoreo y Trazabilidad (Uptime Kuma)

Para garantizar la alta disponibilidad del servicio, he incluido un contenedor de **Uptime Kuma**.
* 5.1 Ejecuta `docker-compose up -d`.
* 5.2 Accede a `http://localhost:3001` para ver el estado de salud de la API en tiempo real.

---

## 6. Decisiones de Arquitectura y Diseño 

Para esta solución, no solo me enfoqué en cumplir los requisitos, sino en aplicar estándares de nivel empresarial:

*   **Arquitectura Limpia (Hexagonal):** Dividí el proyecto en capas (*Domain, Application, Infrastructure*) para desacoplar la lógica de negocio de las herramientas externas. Esto permite, por ejemplo, cambiar la base de datos o el framework web sin tocar una sola línea de la lógica de las franquicias.
*   **Programación Reactiva (Spring WebFlux):** Implementé un paradigma no bloqueante. A diferencia de las APIs tradicionales, esta arquitectura permite manejar miles de peticiones simultáneas con un consumo de memoria mínimo, ideal para sistemas de alta concurrencia.
*   **Persistencia Híbrida Cloud:** Utilicé **MongoDB Atlas** para asegurar que los datos estén disponibles en la nube, cumpliendo con estándares de escalabilidad y alta disponibilidad.
*   **Observabilidad:** Implementé **Spring Boot Actuator** y **Uptime Kuma** para demostrar cómo se gestiona un servicio en un entorno real de producción, monitoreando el estado de salud (*Health Checks*) constantemente.
*   **Logging Estructurado:** Configuración de Logback para una trazabilidad clara y profesional en consola.

---
## 7. Contacto

Si tienes dudas o comentarios no dudes en contactarme 

Juan Diego Gutierrez Venegas 

- diegogv231200@gmail.com