# FROM maven:3.6.3-openjdk-11-slim as build
FROM maven:3.6.3-jdk-11 as build
ARG GITHUB_USERNAME
ARG GITHUB_TOKEN
ENV USERNAME=$GITHUB_USERNAME TOKEN=$GITHUB_TOKEN
WORKDIR /home/maven/e-invoice
COPY . .
WORKDIR /home/maven/e-invoice
# RUN apt-get update && apt-get install -y  --no-install-recommends software-properties-common git && rm -rf /var/lib/apt/lists/*
RUN mvn scm:bootstrap

FROM adoptopenjdk/openjdk11:x86_64-debianslim-jre-11.0.6_10
ENV E_INVOICE_HOME /srv/webapps/mydomain.com/e-invoice
WORKDIR $E_INVOICE_HOME
COPY --from=build /home/maven/e-invoice/target/checkout/target/gs-reactive-rest-service-0.1.0.jar .
RUN apt-get update && apt-get install -y  --no-install-recommends software-properties-common telnet iputils-ping wget curl vim unzip tzdata && rm -rf /var/lib/apt/lists/* &&  ln -snf /usr/share/zoneinfo/$TZ /etc/localtime  && echo ${TZ} > /etc/timezone
# RUN curl -O "https://download.newrelic.com/newrelic/java-agent/newrelic-agent/4.5.0/newrelic-java.zip" && unzip newrelic-java.zip && rm newrelic-java.zip
# COPY misc/newrelic/newrelic.yml newrelic/
# RUN mkdir conf && touch conf/secret.properties
ENV TZ=Asia/Kolkata
# COPY conf $ORDER_HOME/conf/
ENTRYPOINT ["sh", "-c"]
# CMD [ "java -Xms1536m -Xmx1536m -XX:+UseG1GC -jar  -javaagent:${ORDER_HOME}/newrelic/newrelic.jar  -Dnewrelic.environment=${RUN_ENV} gs-reactive-rest-service-0.1.0.jar"]
CMD [ "java -Xms1536m -Xmx1536m -XX:+UseG1GC -jar gs-reactive-rest-service-0.1.0.jar"]
