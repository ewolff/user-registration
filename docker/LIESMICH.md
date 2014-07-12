Beispiel mit Docker
==============

Dieses Projekt erzeugt eine VM mit der Anwendung in einem
Docker-Container. 

Zum Ausführen:

- Installiere Vagrant, siehe
  http://docs.vagrantup.com/v2/installation/index.html
- Installiere Virtual Box von https://www.virtualbox.org/wiki/Downloads
- Gehe zum übergeordneten Verzeichnis und führe dort `mvn install` aus
- Wechsel zum Verzeichnis mit diesem Liesmich.md und führe `vagrant
   up` aus.

Das Ergebnis:

- Eine VirtualBox VM wird von Vagrant gestartet
- Docker wird in der VM gestartet
- Die Anwendung steht unter http://localhost:8090/ zur Verfügung.

