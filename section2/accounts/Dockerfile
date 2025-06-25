# to run my application we need the java 17 jdk
FROM openjdk:17-jdk-slim
# who maintains this application
LABEL "maintained by"="rohitprashar712@gmail.com"
# copy the jar from os to docker
COPY /build/libs/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar
# run the image ie running the application
ENTRYPOINT ["java","-jar","accounts-0.0.1-SNAPSHOT.jar"]
