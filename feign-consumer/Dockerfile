FROM java:8

VOLUME /tmp

COPY target/feign-consumer-0.0.1-SNAPSHOT.jar ./feign.jar

ENTRYPOINT ["java","-jar","feign.jar"]

