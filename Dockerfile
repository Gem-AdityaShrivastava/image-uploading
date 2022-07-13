FROM openjdk:11
EXPOSE 8080
ADD target/imageuploading-0.0.1-SNAPSHOT.jar imageuploading-0.0.1-SNAPSHOT.jar


# an entrypoint is an instruction used to set executables that will always run when the container is initiated
ENTRYPOINT ["java","-jar","/imageuploading-0.0.1-SNAPSHOT.jar"]