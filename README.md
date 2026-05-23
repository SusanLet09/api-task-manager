# API Task Manager

API REST desarrollada con Spring Boot para la gestión de tareas, permitiendo realizar operaciones CRUD (Create, Read, Update, Delete) mediante endpoints RESTful.

---

# Tecnologías utilizadas

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2 Database
- Maven
- Lombok
- Bean Validation
- Swagger / OpenAPI
- Git & GitHub

---

# Arquitectura y Patrones Aplicados

La aplicación fue estructurada siguiendo una arquitectura en capas para separar responsabilidades, facilitar el mantenimiento y mejorar la escalabilidad del proyecto.

## Capas utilizadas

- **Controller** → exposición de endpoints REST.
- **Service** → implementación de lógica de negocio.
- **Repository** → acceso a datos mediante JPA.
- **Entity** → representación del modelo de datos.
- **DTOs** → transferencia de datos entre capas.
- **Exceptions** → manejo global de errores.
- **Mapper** → conversión entre Entity y DTO.
- **Enums** → definición de estados fijos de la tarea.
- **Config** → configuración de componentes de la aplicación (Swagger/OpenAPI).

## Patrones implementados

### Repository Pattern

Se utilizó Spring Data JPA para desacoplar el acceso a datos de la lógica de negocio.

### Dependency Injection

Spring Boot gestiona la inyección de dependencias entre controladores, servicios y repositorios mediante el contenedor IoC.

### Unit of Work

El manejo transaccional se implementó utilizando JPA/Hibernate mediante el contexto de persistencia y `@Transactional`.

---

# Funcionalidades

La API permite:

- Crear tareas
- Obtener todas las tareas
- Obtener una tarea por ID
- Actualizar tareas existentes
- Eliminar tareas

---

# Modelo de Tarea

```json
{
  "id": 1,
  "title": "Complete technical challenge",
  "description": "Implement REST API",
  "status": "IN_PROGRESS",
  "creationDate": "2026-05-22T10:00:00"
}
```

## Estados disponibles

- `PENDING`
- `IN_PROGRESS`
- `COMPLETED`

---

# Endpoints

| Método | Endpoint | Descripción |
|---------|-----------|-------------|
| POST | `/api/tasks` | Crear una tarea |
| GET | `/api/tasks` | Obtener todas las tareas |
| GET | `/api/tasks/{id}` | Obtener una tarea por ID |
| PUT | `/api/tasks/{id}` | Actualizar una tarea |
| DELETE | `/api/tasks/{id}` | Eliminar una tarea |

---

# Validaciones implementadas

Se implementaron validaciones utilizando Bean Validation:

- El título no puede estar vacío (`@NotBlank`)
- El título debe tener entre 3 y 100 caracteres (`@Size`)
- La descripción tiene un límite de caracteres
- El estado de la tarea es obligatorio (`@NotNull`)

Además, se implementó manejo global de excepciones mediante `@RestControllerAdvice`.

## Respuestas HTTP manejadas

- `400 Bad Request`
- `404 Not Found`
- `500 Internal Server Error`

---

# Cómo ejecutar el proyecto

## 1. Clonar repositorio

```bash
git clone https://github.com/SusanLet09/api-task-manager.git
```

## 2. Entrar al proyecto

```bash
cd api-task-manager
```

## 3. Ejecutar aplicación

### Windows

```bash
mvnw.cmd spring-boot:run
```

### Linux / Mac

```bash
./mvnw spring-boot:run
```

La aplicación se ejecutará en:

```text
http://localhost:8080
```

---

# Swagger / OpenAPI

La documentación de la API está disponible en:

```text
http://localhost:8080/swagger-ui/index.html
```

Documentación OpenAPI JSON:

```text
http://localhost:8080/api-docs
```

---

# Control de Versiones

El desarrollo del proyecto fue gestionado utilizando Git y GitHub mediante commits descriptivos y ramas feature para cada funcionalidad desarrollada.

## Ramas utilizadas

- `feature/task-entity`
- `feature/task-status-enum`
- `feature/task-repository`
- `feature/task-dto`
- `feature/task-mappers`
- `feature/task-service`
- `feature/task-controller`
- `feature/task-exceptions`
- `feature/swagger-documentation`
- `feature/ci-cd`

---

# CI/CD

Se configuró un pipeline básico de integración continua para automatizar el proceso de compilación (**build**) del proyecto utilizando Maven.

El pipeline ejecuta:

- Instalación de dependencias
- Compilación del proyecto
- Validación del build de la API

## Consideración sobre despliegue en Azure

Debido a restricciones de acceso para la creación de recursos en Azure durante el desarrollo del challenge, el despliegue (deploy) no pudo completarse en un servicio de Azure App Service o Azure Function.

Sin embargo, el proyecto fue estructurado para permitir su despliegue posterior, manteniendo configuración desacoplada y documentación de ejecución local mediante Swagger/OpenAPI.

---

# Justificación de decisiones de diseño

Se utilizó una arquitectura en capas para mantener separadas las responsabilidades del sistema, facilitando el mantenimiento y escalabilidad del proyecto.

El uso de DTOs permitió desacoplar el modelo de persistencia de las respuestas de la API, evitando exponer directamente las entidades de base de datos.

Asimismo, se implementaron mappers para facilitar la conversión entre entidades y objetos de transferencia de datos.

El manejo global de excepciones se implementó para centralizar errores y devolver respuestas HTTP consistentes.

Por último, se incorporó Swagger/OpenAPI para documentar y probar los endpoints de manera rápida y sencilla.

---

# Autor

**Susana Leticia Alvarado Martínez**