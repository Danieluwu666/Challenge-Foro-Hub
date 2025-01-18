# Challenge Foro Hub

Challenge Foro Hub es una aplicación web desarrollada con Spring Boot que implementa un foro en el que los usuarios pueden autenticarse, crear, listar, actualizar y eliminar temas de discusión (tópicos).

## Características principales

1. **Autenticación de Usuarios:**
   - Implementa un sistema de autenticación basado en JWT (JSON Web Tokens).
   - Gestión de credenciales y roles de usuario.
![Captura de pantalla 2025-01-18 164026](https://github.com/user-attachments/assets/afa3b2bb-91f4-4782-9b25-e58861469574)


2. **Gestión de Tópicos:**
   - Crear, leer, actualizar y eliminar tópicos.
   - Validación de datos para garantizar la integridad de la información.

3. **Manejo de Errores:**
   - Tratamiento centralizado de excepciones comunes, como `EntityNotFoundException` y `MethodArgumentNotValidException`.

4. **Seguridad:**
   - Spring Security para proteger endpoints.
   - Tokens JWT para sesiones seguras.

## Tecnologías utilizadas

- **Java 17**
- **Spring Boot**
  - Spring Web
  - Spring Security
  - Spring Data JPA
- **Jakarta Validation** para validaciones de entrada.
- **Hibernate** para manejo de entidades.
- **H2 Database** (puede ser reemplazado por otras bases de datos).
- **JWT** para autenticación.

## Estructura del proyecto

```plaintext
src/main/java/com/aluracursos/ChallengeForoHub
├── controller
│   ├── AutenticacionController.java
│   ├── TopicoController.java
├── domain
│   └── usuarios
│       ├── Usuario.java
│       ├── UsuarioRepository.java
│       └── DatosAutenticacionUsuario.java
├── dto
│   ├── TopicoCreateDTO.java
│   └── TopicoDTO.java
├── infra
│   ├── errores
│   │   └── TratadorDeErrores.java
│   └── security
│       ├── AutenticacionService.java
│       ├── DatosJWTToken.java
│       └── TokenService.java
├── service
│   └── TopicoService.java
```

## Instalación y configuración

1. Clona este repositorio:
   ```bash
   git clone https://github.com/tu-usuario/challenge-foro-hub.git
   ```

2. Configura tu entorno de desarrollo:
   - Asegúrate de tener Java 17 y Maven instalados.

3. Configura el archivo `application.properties`:
   ```properties
   spring.datasource.url=jdbc:h2:mem:testdb
   spring.datasource.driverClassName=org.h2.Driver
   spring.datasource.username=sa
   spring.datasource.password=password
   spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

   spring.security.jwt.secret-key=tu-clave-secreta
   spring.security.jwt.expiration=86400000
   ```

4. Ejecuta la aplicación:
   ```bash
   mvn spring-boot:run
   ```

5. Accede a la aplicación en [http://localhost:8080](http://localhost:8080).

## Endpoints principales

### Autenticación
- `POST /login`: Autenticar a un usuario y recibir un token JWT.
  - **Request Body:**
    ```json
    {
      "login": "usuario",
      "clave": "contraseña"
    }
    ```
  - **Response:**
    ```json
    {
      "token": "eyJhbGciOiJIUzI1NiIsInR5cCI..."
    }
    ```

### Gestión de tópicos
- `GET /topicos`: Lista todos los tópicos.
- `GET /topicos/{id}`: Obtiene un tópico por su ID.
- `POST /topicos`: Crea un nuevo tópico.
  - **Request Body:**
    ```json
    {
      "titulo": "Título del tópico",
      "mensaje": "Mensaje del tópico",
      "status": "activo",
      "autor": "Nombre del autor",
      "curso": "Curso relacionado"
    }
    ```
- `PUT /topicos/{id}`: Actualiza un tópico existente.
- `DELETE /topicos/{id}`: Elimina un tópico por su ID.

## Manejo de errores

- **404 Not Found:** Cuando no se encuentra un recurso.
- **400 Bad Request:** Cuando los datos de entrada no cumplen con las validaciones.

## Mejoras futuras

- Implementar paginación en los endpoints de listado.
- Agregar soporte para múltiples roles (administrador, moderador, etc.).
- Internacionalización de mensajes de error y respuestas.

## Contribuciones
¡Las contribuciones son bienvenidas! Si deseas colaborar, por favor abre un issue o envía un pull request.
