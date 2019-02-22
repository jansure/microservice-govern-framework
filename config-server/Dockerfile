FROM java:8

VOLUME /tmp

COPY target/config-server-0.0.1-SNAPSHOT.jar ./config.jar

ENTRYPOINT ["java","-jar","config.jar"]

