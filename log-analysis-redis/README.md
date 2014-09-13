Elasticsearch / Logstash / Kibana / Redis to analyse logs
===============

[German / Deutsch](LIESMICH.md) 

This setup is comparabel to the setup in the directory
log-analysis. But this installation writes the log data in Redis
without parsing it. Therefore no complex operations are done in that
part of the system and it is less CPU consuming. Redis is a NoSQL
database. It is used as a bugger: When a lot of logs are written they
can be stored in Redis. Afterwards logstash reads the logs and parses
them. This installation can be a blueprint for more powerful ELK stack
installations.

To run:

- Install Maven, see http://maven.apache.org/download.cgi#Installation
- Install Vagrant as discussed at
  http://docs.vagrantup.com/v2/installation/index.html
- Install Virtual Box from https://www.virtualbox.org/wiki/Downloads
- Go to parent directory and run `mvn install` there
- Change to the directoriy containing this README.MD and run `vagrant
   up`

The result should be:

- A new VirtualBox VM is fired up by Vagrant
- Docker is installed in the VM
- You can access the application at http://localhost:8081/
- You can access Kibana  at http://localhost:8080/
- Elasticsearch is exposed at port 9200.

