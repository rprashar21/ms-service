The H2 console is accessible at http://localhost:8085/h2-console for database management.

# swagger ui is available at http://localhost:8085/swagger-ui/index.html 
# for swagger ui we just need to add a simple dependency - implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.9'


# to build a jar file    ./gradlew clean build
# to run the appilication got to build/libs folder and run this command --> java -jar accounts-0.0.1-SNAPSHOT.jar

# building the docker image -- got the root folder in which we have dockerfile 
docker build . -t rondocker2191/accounts:v1 -- image created docker.io/rondocker2191/accounts:v1

docker images
REPOSITORY                                TAG          IMAGE ID       CREATED              SIZE
rondocker2191/accounts                    v1           61ee1bc5014f   About a minute ago   753MB

# to run this use
docker run -d -p 8089:8085 rondocker2191/accounts:v1

# now we can build cocker images using build packs whihc is easier and better way of building images you will see the differenece 
./gradlew bootBuildImage --imageName=rondocker2191/accounts:v2
REPOSITORY                                 TAG          IMAGE ID       CREATED             SIZE
rondocker2191/accounts                     v2           cbc7935f422d   45 years ago        556MB this has less size becoz 

# we can also build the images using google jib we need to add the below plugin
# plugins {
id 'com.google.cloud.tools.jib' version '3.4.5'
}
./gradlew jib --image=rondocker2191/accounts:v3

# push the docker image
docker image push 

# some docker compose commands
start in background
docker-compose up -d

docker-compose up

