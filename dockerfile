# Usamos una imagen base oficial de Maven con Java incluido
FROM maven:3.8.4-openjdk-11

# Directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiamos el archivo pom.xml y los archivos de código fuente local al directorio de trabajo del contenedor
COPY pom.xml ./
COPY src ./src

# Opcionalmente, podríamos agregar una fase de descarga de dependencias para aprovechar la cache de Docker
# Esto puede mejorar el tiempo de construcción si las dependencias no cambian
RUN mvn dependency:go-offline

# Compilamos el proyecto. Este paso ejecutará las pruebas y otras verificaciones si están configuradas en el pom.xml
RUN mvn package -DskipTests

# El puerto en el que corre la aplicación, ajustar según sea necesario
EXPOSE 8080

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "target/nombre-de-tu-app.jar"]