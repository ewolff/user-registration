Narrative:
Registierungen von Kunden

Scenario: Kunde registriert sich erfolgreich

Gegeben ein neuer Kunde mit EMail eberhard.wolff@gmail.com Vorname Eberhard Name Wolff
Wenn der Kunde sich registriert
Dann sollte ein Kunde mit der EMail eberhard.wolff@gmail.com existieren
und es sollte kein Fehler gemeldet werden

Scenario: EMail invalide

Gegeben ein neuer Kunde mit EMail HURZ und Vorname Eberhard und Name Wolff
Wenn der Kunde sich registriert
Dann sollte ein Fehler gemeldet werden

Scenario: Nur ein Kunde mit einer EMail

Gegeben ein neuer Kunde mit EMail eberhard.wolff@gmail.com Vorname Eberhard Name Wolff
und ein anderer Kunde mit EMail eberhard.wolff@gmail.com Vorname Bill Name Gates
Wenn der Kunde sich registriert
und der andere Kunde sich registriert
Dann sollte die Registrierung des anderen Kunden nicht erfolgreich sein

Scenario: Nach Loeschen existiert der Kunde nicht mehr

Gegeben ein neuer Kunde mit EMail eberhard.wolff@gmail.com Vorname Eberhard Name Wolff
Wenn der Kunde sich registriert
und der Kunde dann geloescht wird
Dann sollte kein Kunde mit der EMail eberhard.wolff@gmail.com existieren