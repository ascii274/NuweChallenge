```
Este es un ejerecicio para poder estar en el Hackaton de MWC 2022,
creado por la web Nuwe.io.
Para saber más sobre el ejercicios leer: README-EXERCISE.md
```
# ProjectName:
> RetoMWC-2022

##Pasos a instalar:

```shell
    # Clone
    clone https://github.com/jcabatay/NuweChallenges.git    
    
     # branch 
    develop       
    
    # jdk 
    17 
```
1. Instalar Mongodb
2. Create database: nuwe-db
3. Create collection: developers
4. Insertar los datos a la base de datos: [Archivo json](https://challenges-asset-files.s3.us-east-2.amazonaws.com/data_sets/mwc22.json)
5. Ó inserta en la BBDD el archivo developer.json ubicado en el directorio resources.

### Dirección servidor Mongo:
* localhost:27017

## Para ejecutar desde IDE ( Intellij )
- Open Edit Run/Debug configurations -> Aplications -> Build and run
- En Cli Arguments poner -> [-lisdev -lisdev -addev] sin llaves

## Para ejecutar desde consola con .jar

1. Crear archivo jar.
2. Desde el directorio generado aplicar los siguientes commandos:

### Comando que lista día
- java -jar RetoMWC-2022.jar com.ascii274.reto -disday

### Comando lista developer
- java -jar RetoMWC-2022.jar com.ascii274.reto -lisdev

### Comando añade developer
- java -jar RetoMWC-2022.jar com.ascii274.reto -addev
 

