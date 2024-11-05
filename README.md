# API de Gestión de Franquicias

Esta API permite gestionar franquicias, sucursales y productos. Desarrollada en Spring Boot, la API expone varios endpoints para manejar franquicias, sucursales y productos, utilizando Redis para la persistencia de datos.

## Requisitos

- **Java 17+**
- **Spring Boot 3+**
- **Redis**
- **Docker** (para despliegue opcional)

## Instalación

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/SantiagoCaceres9818/testNequi.git

2. **Configurar Redis**:
```bash
   docker run -d --name redis -p 6379:6379 redis

3. **Configurar el proyecto**:
Revisa el archivo application.properties en el directorio src/main/resources para configurar la conexión a Redis

4. **Compilar y ejecutar el proyecto**:
```bash
    ./mvnw clean install
    ./mvnw spring-boot:run

3. **Estructura el proyecto**:
controller: Contiene los controladores de la API.
service: Lógica de negocio y servicios asociados a la API.
repository: Repositorios para interactuar con Redis.
model: Entidades y modelos de datos.
