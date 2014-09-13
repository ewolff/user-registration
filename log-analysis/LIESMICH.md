Elasticsearch / Logstash / Kibana zur Analyse von Log-Dateien
===============

[German / Deutsch](LIESMICH.md) 

Dieses Projekt erzeugt eine VM mit der Anwendung in einem
Docker-Container und jeweils einen weiteren Docker-Container für
Elasticseach, Logstash und Kibana. Logstash parst die Log-Dateien der
Anwendung, Elasticsearch speichert die entstehenden Daten und Kibana
dient zur Analyse.


Zum Ausführen:

- Installiere Maven, siehe http://maven.apache.org/download.cgi#Installation
- Installiere Vagrant, siehe
  http://docs.vagrantup.com/v2/installation/index.html
- Installiere Virtual Box von https://www.virtualbox.org/wiki/Downloads
- Gehe zum übergeordneten Verzeichnis und führe dort `mvn install` aus
- Wechsel zum Verzeichnis mit diesem Liesmich.md und führe `vagrant
   up` aus.

Das Ergebnis:

- Eine VirtualBox VM wird von Vagrant gestartet
- Docker wird in der VM gestartet
- Die Anwendung steht unter http://localhost:8081/ zur Verfügung.
- Kibana steht unter http://localhost:8080/ zur Verfügung.
- Elasticsearch steht unter Port 9200 zur Verfügung.

