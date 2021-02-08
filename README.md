# Laboratorio 4 - Grupo 1 - Microservicio

### Ejecutar Test Unitarios

Ejecutar en un terminal, desde la raiz de este repositorio, el siguiente comando:

`./mvnw test`

Si tiene maven instalado localmente:

`mvn test`

### Ejecución de la Aplicacion

Ejecutar en un terminal, desde la raiz de este repositorio, el siguiente comando:

`./mvnw spring-boot:run`

Si tiene maven instalado localmente:

`mvn spring-boot:run`

### Descripción

Este servicio se ejecuta en el puerto 8089. Para probar el servicio:

- **Metodo:** GET
- **Endpoint:** `http://localhost:8089/rest/msdxc/dxc?sueldo={{sueldo}}&ahorro={{ahorro}}`