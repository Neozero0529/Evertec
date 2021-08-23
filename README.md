# Evertec :colombia:
Prueba de ingreso Ingeniero de Desarrollo

Usted tiene una tienda muy básica, donde un cliente puede comprar un solo producto
con un valor fijo, el cliente necesita únicamente proporcionar su nombre, dirección de
correo electrónico y su número de celular para efectuar la compra. Una vez un cliente
procede a la compra de su producto, como es debido, su sistema debe saber que se creó
una nueva orden de pedido, asignarle su código único para identificarla y saber si esta se
encuentra pendiente de pago o si ya se ha realizado un pago para poder “despacharla”.

El servicio implementa una base de datos en memoria por lo cual en la ejecucion queda funcional para utilizar los servicios, para consultar los datos directalemnte usar la url: http://localhost:8082/api/v1/h2-console
### Requisitos 📋
- Java 1.8 o superior
- mvn

### Instalación 🔧
1. Clonar el repositorio, **en su lugar de trabajo**.

```sh 
git clone https://github.com/Neozero0529/Evertec.git
```
2. ir al proyecto backend
```sh 
cd Evertec/commons/
```
3. Instalar el componente
```sh 
mvn install
```
2. ir al proyecto backend
```sh 
cd ../Evertec/rest-api-backend/
```
3. Compilar el codigo
```sh 
mvn package
```
4. Ejecutar **SpringBoot**
```sh 
jar -jar tarjet/rest-api-backend.jar
```
5. Ejecutar **SpringBoot**
```sh 
url base para el consumo: http://localhost:8082/api/v1/order 
acepta post get
http://localhost:8082/api/v1/order/{id}
acepta get
```

### Características
- Control de excepciones con respuesta personalizada.
- Generación de uuid por cada transacción, con capacidad de seguimiento en logs y retornando en el servicio.
- Servicio implementado por capas
- Uso de **lombok**
- Uso de **joda time** para formato de tiempo
- Integracion de pruebas junit con prueba al servicio, base de datos y lombok
- Respuesta de los servicios segun el standard de **JSend**
- Validaciones de los DTO
- libreria commons para facilitar la integracion