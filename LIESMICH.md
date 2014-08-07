User Registration
===========

Diese ist ein einfaches Beispiel für die grundlegenden technischen
Features einer Anwendung, die in einer Continuous-Delivery-Pipeline
laufen soll. Es ist eine Basis für eigene Experimente.

Die Anwendung ist in Java geschrieben und nutzt Spring Boot. Um sie zu
kompilieren und alle Tests auszuführen:

- Installiere Maven
- Führe `mvn install` in diesem Verzeichnis aus.

Als Teil der Maven-Builds werden die folgenden Projekte gebaut:

- Das Unterverzeichnis `user-registration-application` enthält die
Anwendung selber. Sie wird kompiliert und die Unit-Tests werden
ausgeführt.
- Im Unterverzeichnis `user-registration-acceptancetest-jbehave`
  befinden sich automatisierte Akzeptanztests, die mit JBehave
  implementiert sind. Mit diesem Werkzeug können Tests als Stories in
  natürlicher Sprache geschrieben werden.
- Das Unterverzeichnis `user-registration-acceptancetest-selenium`
  enthält automatisierte Akzeptanztests, die mit Selenium
  implementiert sind. Sie testen die Anwendung durch die Web-GUI.
- Schließlich enthält das Verzeichnis  `user-registration-capacitytest-gatling` 
  automatisierte Kapazitätstests mit Gatling. SIe nutzen die Web GUI
  für die Tests.

Zustäzlich zu diesen Maven-Projekten gibt es noch einige weitere
Projekte:

- Das Unterverzeichnis `docker` enthält ein Setup, um die Anwendung in
  einem Docker-Container innerhalb einer Vagrant-Box zu
  installieren. Docker ist ein leichtgewichtiger Ansatz, der Linux
  Container nutzt, um Anwendungen in einer eigenen Umgebung zu
  installieren. Diese Umgebungen sind fast gleichwertig mit virtuellen
  Maschinen. Vagrant macht das Nutzen dieser Technologien wesentlich
  einfacher.
- Das Verzeichnis `graphite` enthält ein Setup, um die Anwendung
  ablaufen zu lassen und mit Hilfe von Graphite die
  Monitoring-Informationen anzuzeigen.
- Im Unterverzeichnis `log-analysis` findet sich ein Setup, um die
  Anwendung ablaufen zu lassen und die Log-Informationen mit Logstash
  zu analysieren Die Informationen werden dann in Elasticsearch
  gespeichert und können mit Kibana analysisert werden.
- Im Unterverzeichnis `chef` steht eine Beispiel für ein Setup mit
  Chef zur Verfügung - es nutzt allerdings nicht die Beispielanwendung.

Bevor man diese Projekte nutzen kann, muss zunächst der Maven-Build
des Basis-Projekts durchlaufen. Weitere Informationen finden sich im
LIESMICH.md im jeweiligen Unterverzeichnis.

Der Code steht unter Apache-2.0-Lizenz - siehe die Datei LICENSE
in diesem Verzeichnis.

HINWEIS: Dieses Beispiel ist nicht für Produktionsumgebungen
geeignet. Beispielsweise laufen einige Prozesse als root und sind
durch das Netz direkt ansprechbar. Das führt zu einem
Sicherheitsrisiko und muss in Produktionsumgebungen vermieden werden.
