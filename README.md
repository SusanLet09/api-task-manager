# API Task Manager

Challenge técnico desarrollado con Spring Boot para la gestión de tareas mediante una API REST.

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

La aplicación fue estructurada siguiendo una arquitectura en capas para separar responsabilidades y facilitar el mantenimiento del código.

## Capas utilizadas

- Controllers → exposición de endpoints REST
- Services → lógica de negocio
- Repositories → acceso a datos
- Entities → modelo de datos
- DTOs → transferencia de datos
- Exceptions → manejo global de errores

## Patrones implementados

### Repository Pattern
Se utilizó Spring Data JPA para desacoplar el acceso a datos de la lógica de negocio.

### Dependency Injection
Spring Boot maneja la inyección de dependencias entre controladores, servicios y repositorios.

### Unit of Work
El manejo transaccional se realizó mediante JPA/Hibernate utilizando el contexto de persistencia de Spring.

---

# Funcionalidades

## Gestión de tareas

- Crear tarea
- Obtener todas las tareas
- Obtener tarea por ID
- Actualizar tarea
- Eliminar tarea

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

---

# Endpoints

| Método | Endpoint | Descripción |
|---|---|---|
| POST | /api/tasks | Crear tarea |
| GET | /api/tasks | Obtener todas las tareas |
| GET | /api/tasks/{id} | Obtener tarea por ID |
| PUT | /api/tasks/{id} | Actualizar tarea |
| DELETE | /api/tasks/{id} | Eliminar tarea |

---

# Validaciones implementadas

- El título no puede estar vacío
- Validación de payloads de entrada
- Manejo global de excepciones
- Respuestas HTTP adecuadas:
    - 400 Bad Request
    - 404 Not Found
    - 500 Internal Server Error

---

# Cómo ejecutar el proyecto

## Clonar repositorio

```bash
git clone https://github.com/SusanLet09/api-task-manager.git
```

## Entrar al proyecto

```bash
cd api-task-manager
```

## Ejecutar aplicación

Linux / Mac:

```bash
./mvnw spring-boot:run
```

Windows:

```bash
mvnw.cmd spring-boot:run
```

---

# Swagger / OpenAPI

Documentación disponible en:

```text
http://localhost:8080/swagger-ui/index.html
```

---

# Control de Versiones

El proyecto fue gestionado utilizando Git y GitHub mediante commits descriptivos y ramas feature para cada funcionalidad desarrollada.

Ejemplos de ramas utilizadas:

- feature/task-entity
- feature/task-repository
- feature/task-service
- feature/task-controller
- feature/task-validation
- feature/swagger-docs

---

# CI/CD

Se configuró un pipeline básico en Azure DevOps para automatizar el proceso de build de la aplicación utilizando Maven.

---

# Autor

Susana Leticia Alvarado Martínez