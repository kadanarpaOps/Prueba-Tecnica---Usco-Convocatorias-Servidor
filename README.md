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
