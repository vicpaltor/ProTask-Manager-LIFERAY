$readmeContent = @"
# 📋 ProTask Manager - Sistema de Gestión de Tareas en Liferay DXP

> **Estado del Proyecto:** 🚧 En Desarrollo (Fase de Persistencia completada)

**ProTask Manager** es una aplicación modular desarrollada sobre la plataforma **Liferay Portal 7.4 (Community Edition)**. Su objetivo es gestionar tareas y eventos empresariales utilizando la arquitectura OSGi estándar de Liferay, persistencia robusta y una interfaz moderna.

Este proyecto sirve como demostración práctica de arquitectura de software en Liferay, implementando patrones como **Service Builder**, **MVC Portlet** e integración con **Base de Datos externa**.

---

## 🛠️ Stack Tecnológico

*   **Plataforma:** Liferay Portal 7.4 CE GA132.
*   **Lenguaje:** Java 17 (OpenJDK).
*   **Gestión de Construcción:** Gradle (Liferay Workspace).
*   **Base de Datos:** PostgreSQL 14 (Contenerizada en Docker).
*   **Arquitectura:** OSGi Modular (API/Service split).
*   **Herramientas:** Blade CLI, Docker Desktop, IntelliJ IDEA.

---

## 📂 Estructura del Proyecto

El proyecto sigue la estructura estándar de un **Liferay Workspace**:

ProTask-Manager/
├── bundles/                 # Servidor Liferay Tomcat (Git ignored)
├── configs/                 # Configuraciones de entorno (Docker, Local, Prod)
├── modules/                 # Código Fuente OSGi
│   └── protask/             # Módulo principal de Tareas
│       ├── protask-api/     # Interfaces y Modelos (Exportado)
│       └── protask-service/ # Implementación, Capa de Persistencia y SQL
├── themes/                  # Temas visuales (Frontend)
└── build.gradle             # Configuración global de Gradle

---


## 🚀 Guía de Instalación y Despliegue

Sigue estos pasos para levantar el entorno de desarrollo local.

### 1. Requisitos Previos
*   Java JDK 17 configurado en el PATH.
*   Docker Desktop instalado y corriendo.
*   Git.

### 2. Clonar el Repositorio
\`\`\`bash
git clone https://github.com/tu-usuario/ProTask-Manager.git
cd ProTask-Manager
\`\`\`

### 3. Configurar la Base de Datos (Docker)
El proyecto requiere una instancia de PostgreSQL. Ejecuta el siguiente comando para levantar el contenedor:

\`\`\`bash
docker run --name liferay-postgres \
  -e POSTGRES_USER=liferay \
  -e POSTGRES_PASSWORD=liferay \
  -e POSTGRES_DB=lportal \
  -p 5433:5432 \
  -d postgres:14
\`\`\`
> **Nota:** Se utiliza el puerto local **5433** para evitar conflictos con instalaciones previas de Postgres.

### 4. Inicializar el Servidor Liferay
Descarga el bundle de Tomcat/Liferay necesario (si no existe):

\`\`\`bash
./gradlew initBundle
\`\`\`

### 5. Configuración del Portal
Asegúrate de tener el archivo bundles/portal-ext.properties con la conexión a BD:

\`\`\`properties
jdbc.default.driverClassName=org.postgresql.Driver
jdbc.default.url=jdbc:postgresql://localhost:5433/lportal
jdbc.default.username=liferay
jdbc.default.password=liferay
setup.wizard.enabled=false
\`\`\`

### 6. Despliegue de Módulos (Backend)
Compila y despliega la capa de persistencia (Service Builder):

\`\`\`bash
./gradlew :modules:protask:deploy
\`\`\`
*Verifica en los logs que aparece: STARTED com.miempresa.protask.service_1.0.0*

### 7. Ejecutar
Arranca el servidor desde la carpeta bin de Tomcat o mediante IntelliJ. Accede a:
*   **URL:** http://localhost:8080
*   **Usuario:** test@liferay.com
*   **Clave:** test

---

## 🗃️ Modelo de Datos (Entity: Task)

La entidad principal Task ha sido generada mediante **Liferay Service Builder** (service.xml), garantizando:
*   Inyección de dependencias OSGi.
*   Capa de persistencia Hibernate/JPA optimizada.
*   Caché de segundo nivel automática.

**Campos principales:**
*   taskId (PK, Long)
*   title (String)
*   description (String)
*   dueDate (Date)
*   status (int)
*   auditFields (userId, createDate, etc.)

---

## 📈 Roadmap del Proyecto

*   [x] **Fase 1:** Configuración de entorno y Workspace.
*   [x] **Fase 2:** Conexión a Base de Datos y Service Builder.
*   [ ] **Fase 3:** Lógica de Negocio (API Local).
*   [ ] **Fase 4:** Desarrollo Frontend (MVC Portlet & JSPs).
*   [ ] **Fase 5:** Interacción Usuario-Servidor (Action Commands).
*   [ ] **Fase 6:** API REST (Headless).

---

## 👤 Autor

**Víctor** - *Desarrollador Java & Liferay*
[LinkedIn](tu-url-de-linkedin) | [GitHub](https://github.com/vicpaltor)
"@

$readmeContent | Set-Content -Path "README.md" -Encoding UTF8
Write-Host "✅ Archivo README.md creado con éxito en la carpeta actual." -ForegroundColor Green
