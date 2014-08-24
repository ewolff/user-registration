[English](README.md)

# Continuous Integration Setup

Diese Box erzeugt eine Continuous Integration Spielwiese mit den Komponenten Jenkins, Artifactory und SonarQube. 
Du brauchst Vagrant auf deinem Rechner um die Box zu erzeugen. Optional kann das installieren des vagrant-cashier-Plugins 
erneutes Erzeugen der Box beschleunigen, es ist aber nicht zwingend erforderlich.

Das Ausführen von 'vagrant up' in diesem Verzeichnis erzeugt die Box und installiert und konfiguriert alle Komponenten. 
Das kann beim ersten Mal sehr eine ganze Weile dauern!

Anschliessend sind die folgenden Komponenten verfügbar:

* Jenkins ->     localhost:9191
* Artifactory -> localhost:9292
* SonarQube ->   localhost:9393
