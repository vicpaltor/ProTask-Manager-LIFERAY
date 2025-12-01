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

```text
ProTask-Manager/
├── bundles/                 # Servidor Liferay Tomcat (Git ignored)
├── configs/                 # Configuraciones de entorno (Docker, Local, Prod)
├── modules/                 # Código Fuente OSGi
│   └── protask/             # Módulo principal de Tareas
│       ├── protask-api/     # Interfaces y Modelos (Exportado)
│       └── protask-service/ # Implementación, Capa de Persistencia y SQL
├── themes/                  # Temas visuales (Frontend)
└── build.gradle             # Configuración global de Gradle

## 🚀 Guía de Instalación y Despliegue

Sigue estos pasos para levantar el entorno de desarrollo local.

### 1. Requisitos Previos
*   Java JDK 17 configurado en el `PATH`.
*   Docker Desktop instalado y corriendo.
*   Git.

### 2. Clonar el Repositorio
```bash
git clone https://github.com/tu-usuario/ProTask-Manager.git
cd ProTask-Manager
