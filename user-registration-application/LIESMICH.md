Die Anwendung
==========

Die Anwendung selbst enthält nur Funktionalitäten, um User zu
registrieren. Die User werden dann in einer In-Memory-Datenbank gespeichert.

- Die Anwendung kann gestartet werden mit `mvn spring-boot:run`
- ...oder man kann das WAR direkt starten `java -jar user-registration-application-0.0.1-SNAPSHOT.war`
- ...oder man kann das WAR in einen Servlet-3.0-kompatiblen Container
  wie Tomcat deployen.

Die Anwendung nutzt Spring Boot. Für das Web Interface werd
Thymeleaf-Templates genutzt.
