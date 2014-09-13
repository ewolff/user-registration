Elasticsearch / Logstash / Kibana /Redis zur Analyse von Log-Dateien
===============

[German / Deutsch](LIESMICH.md) 

Im Vergleich zu dem Setup im Verzeichnis log-analysis werden die
Log-Daten bei diesem Beispiel zunächst in Redis geschrieben, ohne dass
sie geparst werden. Dadurch finden in diesem Teil der Anwendung kein
komplexen Operationen mehr statt und die CPU wird entlastet. Redis ist
eine NoSQL-In-Memory-Datenbank und dient als Buffer: Wenn sehr viele
Log-Nachrichten geschrieben werden, können sie zwischengespeichert
werden. Aus dem Redis werden die Log-Nachrichten dann entgegegen
genommen und anschließend durch Logstash geparst. Diese Lösung kann
also ein Vorbild für leistungsfähigere Installationen des ELK-Stacks sein.

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

