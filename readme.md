# POC for spring reactive with docker 

This is a POC for getting started with Spring boot reactive and Docker

## Installation and running

Prerequisite: Docker for windows installed (if you are on windows machine). Apache Maven installed locally. 

Maven way of building
```mvn
mvn clean install
```

Docker way of building
```docker
docker build -t poc/spring-boot-reactive-docker .
```

Build Docker image using maven
```docker
mvn com.spotify:dockerfile-maven-plugin:build
Optionally pass the path to the file as : -Ddockerfile.repository=myorg/myapp
```


Run some containers
```docker
docker run --name spring-reactive-instance-1 -d -p 8080:8080 poc/spring-boot-reactive-docker
docker run --name spring-reactive-instance-2 -d -p 8081:8080 poc/spring-boot-reactive-docker
```

Miscellaneous commands to explore around
```docker
docker ps
docker ps -a
docker image ls
docker container stop spring-reactive-instance-1
docker container ls -a
docker container rm spring-reactive-instance-1
docker exec -it spring-reactive-instance-1 sh
```

Reference

https://spring.io/guides/gs/reactive-rest-service/

https://spring.io/guides/gs/spring-boot-docker/

https://spring.io/guides/topicals/spring-boot-docker
