FROM java:8

VOLUME /tmp

COPY target/ribbon-consumer-0.0.1-SNAPSHOT.jar ./ribbon.jar

ENTRYPOINT ["java","-jar","ribbon.jar"]

