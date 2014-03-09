Szenario: Kunde registriert sich erfolgreich

Gegeben ein neuer Kunde mit EMail eberhard.wolff@gmail.com Vorname Eberhard Name Wolff
Wenn der Kunde sich registriert
Dann sollte ein Kunde mit der EMail eberhard.wolff@gmail.com existieren
Und sollte kein Fehler gemeldet werden

Szenario: EMail invalide

Gegeben ein neuer Kunde mit EMail HURZ Und Vorname Eberhard Und Name Wolff
Wenn der Kunde sich registriert
Dann sollte ein Fehler gemeldet werden

Szenario: Nur ein Kunde mit einer EMail

Gegeben ein neuer Kunde mit EMail eberhard.wolff@gmail.com Vorname Eberhard Name Wolff
Und ein anderer Kunde mit EMail eberhard.wolff@gmail.com Vorname Bill Name Gates
Wenn der Kunde sich registriert
Und der andere Kunde sich registriert
Dann sollte die Registrierung des anderen Kunden nicht erfolgreich sein

Szenario: Nach Loeschen existiert der Kunde nicht mehr

Gegeben ein neuer Kunde mit EMail eberhard.wolff@gmail.com Vorname Eberhard Name Wolff
Wenn der Kunde sich registriert
Und der Kunde dann geloescht wird
Dann sollte kein Kunde mit der EMail eberhard.wolff@gmail.com existieren