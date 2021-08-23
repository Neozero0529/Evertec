# Evertec :colombia:
Prueba de ingreso Ingeniero de Desarrollo

Usted tiene una tienda muy básica, donde un cliente puede comprar un solo producto
con un valor fijo, el cliente necesita únicamente proporcionar su nombre, dirección de
correo electrónico y su número de celular para efectuar la compra. Una vez un cliente
procede a la compra de su producto, como es debido, su sistema debe saber que se creó
una nueva orden de pedido, asignarle su código único para identificarla y saber si esta se
encuentra pendiente de pago o si ya se ha realizado un pago para poder “despacharla”.

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
jar -jar tarjet/
```

commons