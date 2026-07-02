# SisCol

## Sistema de Gestión de Incidencias para Instituciones Educativas

SisCol es una aplicación web desarrollada con Spring Boot para gestionar incidencias, requerimientos y usuarios dentro de una institución educativa.

---

## Objetivo

Digitalizar el proceso de registro, seguimiento y atención de incidencias, permitiendo una gestión eficiente mediante roles y permisos.

---

## Tecnologías

- Java 17
- Spring Boot 3
- Spring Security
- Spring Data JPA
- Hibernate
- PostgreSQL 18
- Maven
- Lombok
- JWT

---

## Arquitectura

Arquitectura multicapa (Layered Architecture):

- Controller
- Service
- Repository
- Entity
- DTO
- Security

Organización por módulos (Feature Packages).

---

## Estructura del proyecto

pe.edu.grupo1.siscol

- auth
- user
- incident
- requirement
- assignment
- attachment
- notification
- reporting
- security
- shared
- config
- exception

---

## Base de datos

Motor:

PostgreSQL 18

ORM:

Hibernate

---

## Estado del proyecto

### Sprint 1

- [x] Configuración del proyecto
- [x] PostgreSQL
- [x] BaseEntity
- [x] Role
- [ ] Permission
- [ ] RolePermission
- [ ] User
- [ ] Login JWT

---

## Integrantes

Grupo 1

- Juan Francisco Amézquita
- Apaza Uscamayta, Eva Yoana
- Barreda Sotomayor Stephanie
- Cuba Samamé, David Salomon
- Cueva Mamani, Heber
- Diaz Gomez, Waldir Wily

## Autor



Maestría en Tecnologías de la Información y Comunicación en Gestión y Educación

Universidad Nacional de San Agustín Arequipa Perú