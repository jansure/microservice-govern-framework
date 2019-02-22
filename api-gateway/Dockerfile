FROM java:8

VOLUME /tmp

COPY src/main/java/groovy/filters/post ./groovy/filters/post
COPY src/main/java/groovy/filters/pre ./groovy/filters/pre
COPY target/api-gateway-0.0.1-SNAPSHOT.jar ./api.jar

ENTRYPOINT ["java","-jar","api.jar"]

