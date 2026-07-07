-- ===========================================================
-- SisCol
-- Script: 02_role_permissions.sql
-- Descripción: Asignación inicial de permisos por rol
-- ===========================================================

-- =====================================
-- ADMIN
-- =====================================

INSERT INTO role_permissions (role_id, permission_id)
VALUES
    (1,1),
    (1,2),
    (1,3),
    (1,4),
    (1,5),
    (1,6),
    (1,7),
    (1,8),
    (1,9),
    (1,10),
    (1,11),
    (1,12),
    (1,13),
    (1,14),
    (1,15),
    (1,16),
    (1,17);

-- =====================================
-- USER (Director / Docente)
-- =====================================

INSERT INTO role_permissions (role_id, permission_id)
VALUES
    (2,9),   -- INCIDENT_CREATE
    (2,10),  -- INCIDENT_VIEW
    (2,11),  -- INCIDENT_UPDATE

    (2,13),  -- REQUIREMENT_CREATE
    (2,14),  -- REQUIREMENT_VIEW
    (2,15);  -- REQUIREMENT_UPDATE

-- =====================================
-- SUPPORT
-- =====================================

INSERT INTO role_permissions (role_id, permission_id)
VALUES
    (3,10),  -- INCIDENT_VIEW
    (3,11),  -- INCIDENT_UPDATE
    (3,12),  -- INCIDENT_DELETE

    (3,14),  -- REQUIREMENT_VIEW
    (3,15),  -- REQUIREMENT_UPDATE
    (3,16),  -- REQUIREMENT_DELETE

    (3,17);  -- REPORT_VIEW