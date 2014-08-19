#!/bin/sh
apt-get update
apt-get dist-upgrade -y
apt-get install -y openjdk-7-jre-headless
apt-get install -y tomcat7
cp /vagrant/user-registration-application-0.0.1-SNAPSHOT.war /var/lib/tomcat7/webapps/
