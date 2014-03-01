Narrative:
Registierungen von Kunden

Scenario: Kunde registriert sich erfolgreich

Gegeben ein neuer Kunde mit EMail eberhard.wolff@gmail.com und Vorname Eberhard und Name Wolff
Wenn der Kunde sich registriert
Dann sollte ein Kunde mit der EMail eberhard.wolff@gmail.com existieren und es sollte kein Fehler gemeldet werden

Gegeben ein neuer Kunde mit EMail HURZ und Vorname Eberhard und Name Wolff
Wenn der Kunde sich registriert
Dann sollte ein Fehler gemeldet werden
