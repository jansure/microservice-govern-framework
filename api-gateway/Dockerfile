FROM java:8

VOLUME /tmp

COPY target/api-gateway-0.0.1-SNAPSHOT.jar ./api.jar

ENTRYPOINT ["java","-jar","api.jar"]

