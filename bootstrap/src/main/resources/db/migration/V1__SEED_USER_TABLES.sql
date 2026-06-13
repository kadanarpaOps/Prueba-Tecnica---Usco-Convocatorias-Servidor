INSERT INTO T_ROLES (ROLE_ID, ROLE_NAME) VALUES
    (gen_random_uuid(), 'ADMINISTRADOR'),
    (gen_random_uuid(), 'ESTUDIANTE'),
    (gen_random_uuid(), 'DOCENTE')
ON CONFLICT (ROLE_NAME) DO NOTHING;

INSERT INTO T_STATUSES (STATUS_ID, STATUS_NAME) VALUES
                                             (gen_random_uuid(), 'ACTIVO'),
                                             (gen_random_uuid(), 'INACTIVO')
ON CONFLICT (STATUS_NAME) DO NOTHING;
