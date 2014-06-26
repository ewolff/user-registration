FROM ubuntu-update
MAINTAINER eberhard.wolff@gmail.com
RUN apt-get install -y openjdk-7-jre-headless
CMD /usr/bin/java -Dgraphite.enabled=true -Dgraphite.host=graphite -Dgraphite.port=2003 -jar /target/user-registration-application-0.0.1-SNAPSHOT.war
EXPOSE 8080