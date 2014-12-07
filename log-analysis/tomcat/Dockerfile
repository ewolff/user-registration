FROM java
RUN apt-get install -y -qq tomcat7
CMD JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64 CATALINA_BASE=/var/lib/tomcat7 CATALINA_HOME=/usr/share/tomcat7 /usr/share/tomcat7/bin/catalina.sh run
EXPOSE 8080