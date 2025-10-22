# Product Service REST 
## Descripción
Servicio REST para la gestión de productos, construido con Spring Boot.
Implementa un CRUD completo (crear, listar, editar y borrar) siguiendo arquitectura hexagonal y vertical slicing.

El proyecto aplica buenas prácticas de diseño: Repository pattern, DTOs, Commands, y inyección de dependencias.

Capas y responsabilidades:

**Dominio** (domain)

- Entidades (Producto)
- Repositorios (Repository)
- Excepciones de negocio (Error)

**Aplicación** (application)

- Casos de uso (UseCase)
- Servicios (Service) que conectan el controlador con el dominio
- Comandos (Command) para encapsular datos

**Infraestructura** (infrastructure)

- Controladores REST (web/rest)
- DTOs (web/dto) transportan los datos entre las capas
- Mappers (mapper) para convertir entre dominio y DTOs
- Repositorios de prueba (db/repository/mock)
- Configuración de beans para inyección de dependencias (config)

Vertical Slicing

Cada feature (productos, usuarios, etc.) contiene sus propias capas, facilitando modularidad y mantenibilidad.
