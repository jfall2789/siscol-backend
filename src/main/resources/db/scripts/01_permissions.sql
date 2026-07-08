-- ===========================================================
-- SisCol
-- Script: 01_permissions.sql
-- Descripción: Catálogo inicial de permisos del sistema
-- ===========================================================

INSERT INTO permissions (name, description, code)
VALUES

-- ===============================
-- USUARIOS
-- ===============================

('Crear Usuario','Permite registrar usuarios','USER_CREATE'),
('Consultar Usuarios','Permite visualizar usuarios','USER_VIEW'),
('Actualizar Usuario','Permite actualizar usuarios','USER_UPDATE'),
('Eliminar Usuario','Permite eliminar usuarios','USER_DELETE'),

-- ===============================
-- ROLES
-- ===============================

('Crear Rol','Permite registrar roles','ROLE_CREATE'),
('Consultar Roles','Permite visualizar roles','ROLE_VIEW'),
('Actualizar Rol','Permite actualizar roles','ROLE_UPDATE'),
('Eliminar Rol','Permite eliminar roles','ROLE_DELETE'),

-- ===============================
-- INCIDENCIAS
-- ===============================

('Registrar Incidencia','Permite registrar incidencias','INCIDENT_CREATE'),
('Consultar Incidencias','Permite visualizar incidencias','INCIDENT_VIEW'),
('Actualizar Incidencia','Permite actualizar incidencias','INCIDENT_UPDATE'),
('Eliminar Incidencia','Permite eliminar incidencias','INCIDENT_DELETE'),

-- ===============================
-- REQUERIMIENTOS
-- ===============================

('Registrar Requerimiento','Permite registrar requerimientos','REQUIREMENT_CREATE'),
('Consultar Requerimientos','Permite visualizar requerimientos','REQUIREMENT_VIEW'),
('Actualizar Requerimiento','Permite actualizar requerimientos','REQUIREMENT_UPDATE'),
('Eliminar Requerimiento','Permite eliminar requerimientos','REQUIREMENT_DELETE'),

-- ===============================
-- REPORTES
-- ===============================

('Visualizar Reportes','Permite visualizar reportes','REPORT_VIEW');