FROM java:8

VOLUME /tmp

COPY target/eureka-server-0.0.1-SNAPSHOT.jar ./eureka.jar

ENTRYPOINT ["java","-jar","eureka.jar"]