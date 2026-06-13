# API Sistema de Convocatorias USCO

- Script de Inicialización de Proyecto:
> [!NOTE]
> Se debe tener instalado y configurado el spring-cli en el entorno operativo.
```shell
spring init -d web,lombok,data-mongodb --build maven -l java -b 4.0.5 -g co.edu.usco.convocations.server -a Usco-Convocations-API --description "Usco Convocations API Rest that contains business logic, PostgreSQL Connection and offers endpoints to call each respective business functionality" -p jar -j 17 Prueba-Tecnica---Usco-Convocatorias-Servidor
```
- Workflows añadidos:
  - Validación de Calidad de Código mediante Sonarqube.
  - Validación de Commits válidos que incluyas Código de Historias de Jira.

## Dependencias

- Spring Web
- Lombok

## Scripts Inicialización de Base de Datos
- La base de datos se creó con anterioridad desde el portal de [PgAdmin4](https://pgadmin.daisyflows.top/).
- Se encuentran todos en el siguiente [Enlace]().

## Protección de ramas
Se ha optado por proteger las ramas principales y añadirles requisitos para cada PR de la siguiente manera.
- `Settings` → `Rules|Rulesets` → `New branch ruleset`
Para `develop`:
```text
Ruleset Name: Restrict Develop
☑ Enforcement status: Active
☑ Target branches: develop, develop/*, develop/**/*
☑ Restrict creations
☑ Restrict deletions
☑ Require a pull request before merging
☑ Require status check to pass:
    ☑ Require branches to be up to date before merging
    ☑ Status check that are required: Commit Jira Validation, SonarQube Code Analysis
☑ Block force pushes
```
Para `main`:
```text
Ruleset Name: Restrict Main
☑ Enforcement status: Active
☑ Target branches: main, main/**, main/**/*
☑ Restrict creations
☑ Restrict deletions
☑ Require a pull request before merging
☑ Require status check to pass:
    ☑ Require branches to be up to date before merging
    ☑ Status check that are required: SonarQube Code Analysis
☑ Block force pushes
```
Para cualquier rama que no sea `feature` o `bugfix`:
```text
Ruleset Name: Restrict Creations
☑ Enforcement status: Active
☑ Target branches:
    ☑ Applies to: *, */*, */**/*
    ☑ Skips: feature/*, bugfix/*
☑ Restrict creations
```

## Keycloak
El realm y cliente se configuraron bajo el siguiente [Enlace](https://keycloak.daisyflows.top/)
- Realm: `Usco_Convocatorias_DEV` para Desarrollo
- Vida de Access Token: 1 Minutos
- Vida de Refresh Token: 5 Minutos