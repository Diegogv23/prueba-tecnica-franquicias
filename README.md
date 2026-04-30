## API de Franquicias
API REST para la gestión de franquicias, sucursales y productos. Desarrollada con Spring Boot, MongoDB y Clean Architecture.

## Requisitos
Antes de comenzar, asegúrate de tener instaladas las siguientes herramientas en tu equipo:
*   **Java 17**: Necesario para ejecutar el núcleo de la aplicación.
*   **Docker Desktop**: Para levantar la base de datos de manera automática.
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

He configurado todo para que el despliegue sea lo más sencillo posible:

### Paso A: Levantar la Base de Datos (Docker)
Asegúrate de tener Docker abierto y ejecuta:
```bash
docker-compose up -d
```
¿Qué hace esto? Crea un contenedor con MongoDB configurado y listo para recibir datos, sin que tengas que instalar la base de datos manualmente.

### Paso B: Iniciar la API
En la misma terminal, ejecuta:

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

## 5. Contacto

Si tienes dudas o comentarios no dudes en contactarme 

Juan Diego Gutierrez Venegas 

- diegogv231200@gmail.com