#Baseimage /it has to be in any dockerfile
FROM openjdk:17
#to  direct any folder
WORKDIR /user/app
#will get jar file and copy to image
COPY ./target/Spring-24-Docker-0.0.1-SNAPSHOT.jar  /user/app
#willprovideexacutableapplicationwhencontainerstartstherun
ENTRYPOINT ["java","-jar", "Spring-24-Docker-0.0.1-SNAPSHOT.jar"]