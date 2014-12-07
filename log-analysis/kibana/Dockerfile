FROM tomcat
RUN apt-get install -qq -y wget
RUN wget -nv https://download.elasticsearch.org/kibana/kibana/kibana-3.1.0.tar.gz ; tar xzf kibana-3.1.0.tar.gz -C /var/lib/tomcat7/webapps
ADD index.html /var/lib/tomcat7/webapps/ROOT/
CMD JAVA_HOME=/usr/lib/jvm/java-7-openjdk-amd64 CATALINA_BASE=/var/lib/tomcat7 CATALINA_HOME=/usr/share/tomcat7 /usr/share/tomcat7/bin/catalina.sh run
EXPOSE 8080