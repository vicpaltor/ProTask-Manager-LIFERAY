# 🚀 ProTask Manager - Liferay DXP Application

[![Liferay](https://img.shields.io/badge/Liferay-7.4_CE-blue.svg)](https://liferay.dev/)
[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Status](https://img.shields.io/badge/Status-Stable-green.svg)]()

**ProTask Manager** es una solución modular completa ("Full Stack") desarrollada sobre **Liferay DXP 7.4**.
Este proyecto demuestra la implementación de una arquitectura limpia siguiendo los estándares OSGi de Liferay, desde la capa de persistencia hasta la exposición de APIs Headless y la interfaz de usuario.

---

## ⭐️ Características Técnicas (Technical Highlights)

Este repositorio demuestra dominio en las siguientes áreas clave de Liferay:

*   **Arquitectura Modular OSGi:** Separación estricta entre definición de API (`-api`), implementación de negocio (`-service`) e interfaz de usuario (`-web`).
*   **Liferay Service Builder:** Modelado de datos avanzado, gestión de transacciones y generación de capa de persistencia (Hibernate/JPA).
*   **Headless API / JSONWS:** Exposición de servicios RESTful seguros para consumo externo (Mobile/SPA), configurando contextos JAX-RS/JSONWS personalizados.
*   **MVC Portlet:** Desarrollo de interfaz de usuario utilizando el patrón Modelo-Vista-Controlador de Liferay.
*   **Validaciones y Seguridad:**
    *   Implementación de **ServiceContext** para auditoría automática (userId, companyId, scopeGroupId).
    *   Validaciones de negocio robustas en capa de servicio.
    *   Control de acceso a nivel de método (`@AccessControlled`).
*   **Frontend:** Uso de **JSP**, **Taglibs de Liferay (AUI/Clay)** y gestión de internacionalización (`Language.properties`) con soporte Unicode.

---

## 🏗 Estructura del Proyecto

```text
ProTask-Manager/
├── modules/
│   ├── protask/
│   │   ├── protask-api/      # Interfaces, Excepciones y Modelos (OSGi Exported)
│   │   └── protask-service/  # Lógica de Negocio, Validaciones y Persistencia SQL
│   └── protask-web/          # Controlador MVC, Action Commands y Vistas JSP
├── configs/                  # Configuraciones de entorno (Docker)
└── bundles/                  # Liferay Server Runtime

````
---

## 🚀 Instalación y Despliegue

Sigue estos pasos para levantar el entorno de desarrollo local.

### 1. Requisitos Previos
*   Java JDK 17 configurado en el PATH.
*   Docker Desktop instalado y corriendo.
*   Git.

### 2. Clonar el Repositorio
```bash
git clone https://github.com/tu-usuario/ProTask-Manager.git
cd ProTask-Manager
````
### 3. Configurar la Base de Datos (Docker)
El proyecto requiere una instancia de PostgreSQL. Ejecuta el siguiente comando para levantar el contenedor:

```bash
docker run --name liferay-postgres -e POSTGRES_USER=liferay -e POSTGRES_PASSWORD=liferay -e POSTGRES_DB=lportal -p 5433:5432 -d postgres:14
```
> **Nota:** Se utiliza el puerto local **5433** para evitar conflictos con instalaciones previas de Postgres.

### 4. Inicializar el Servidor Liferay
Descarga el bundle de Tomcat/Liferay necesario (si no existe):

```bash
./gradlew :modules:protask:deploy
./gradlew :modules:protask-web:deploy
./gradlew initBundle
```

### 5. Ejemplo de Uso de API (Headless)
AEl sistema expone endpoints para integración con terceros.

```properties
Request:
GET /api/jsonws/protask.task/get-all-tasks
```
Response:
```properties
[
{
"taskId": 101,
"title": "Revisión de Código",
"description": "Validar pull request de integración",
"status": 0,
"dueDate": 1764633600000,
"userName": "Test Test"
}
]
```


## 👤 Autor

**Víctor Manuel Palos Torres** - *Desarrollador Java & Liferay*
[LinkedIn](https://www.linkedin.com/in/victor-palos/) | [GitHub](https://github.com/vicpaltor)

