FROM ubuntu                                                                     

RUN apt-get update
RUN apt-get install -y openjdk-11-jre curl
RUN apt-get install -y sqlite3 libsqlite3-dev
RUN mkdir /db

ADD libs/ServerSideApplication-4.0.0-jar-with-dependencies.jar /srv/ServerSideApplication-4.0.0.jar  

WORKDIR /srv                                                                                
EXPOSE 3000
CMD ["java", "-jar", "ServerSideApplication-4.0.0.jar"]