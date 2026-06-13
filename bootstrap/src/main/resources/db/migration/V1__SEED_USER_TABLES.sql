INSERT INTO T_ROLES (ROLE_ID, ROLE_NAME) VALUES
    (gen_random_uuid(), 'ADMINISTRADOR'),
    (gen_random_uuid(), 'ESTUDIANTE'),
    (gen_random_uuid(), 'DOCENTE')
ON CONFLICT (ROLE_NAME) DO NOTHING;
