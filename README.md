# SpringBoot_UserManagement
Erstellung einer Benutzerverwaltung in einer Webumgebung.
Dabei wird ein View für die Anmeldung bestehender Benutzer generiert.
Neue User müssen zunächst von einem Administrator erstellt werden.
In der Benutzerverwaltung findet man eine Auflistung aller Benutzer und deren Eigenschaften. Diese können von einem Admin oder HR bearbeitet und aktualisiert werden.

## Inhaltsverzeichnis

- [Inhalte](#Inhalte)
- [Hinweise](#Hinweise)
- [Lastenheft](LastenheftV1.pdf)
- [Diagramme](#Diagramme)
- [Help](auth/HELP.md)

## Inhalte
- Sign-In
- neue User erstellen -> Admin
- User-Daten pflegen/aktualisieren, editieren -> Admin, HR
- User aktivieren/deaktivieren
- user löschen (ausblenden)


## Diagramme
- [Use-Case-Diagramm](Diagramme/UseCase-Diagramm.drawio) -> neue User erstellen
- [Sequenzdiagramm](Diagramme/Sequenzdiagramm.drawio)
- [User-Fluss-Diagramm](Diagramme/Userflowchart)


## Hinweise

Diese Software ist nur ein Modul eines leichtgewichtigen Enterprise Portals.
Es ist eigenständig und von den anderen Modulen, wie ToDo-Liste, Krankschreibung, etc. abgetrennt.
Eine Implementierung in das Gesamtprojekt "Enterprise Portal" ist nicht angedacht.
