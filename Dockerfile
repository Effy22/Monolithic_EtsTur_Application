FROM amazoncorretto:21.0.2-alpine3.19
COPY build/libs/Monolithic_EtsTur_Application-v.0.1.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]