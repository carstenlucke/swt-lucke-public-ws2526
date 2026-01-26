# Sample App - Task Management System

## Aufgabenbeschreibung

Erstelle eine einfache Aufgabenverwaltungs-Anwendung (Task Management System) als Demonstration für AI Coding Agents.

## Anforderungen

### Funktionale Anforderungen

1. **Task-Verwaltung**
   - Tasks können erstellt werden (mit Titel und Beschreibung)
   - Tasks können als erledigt markiert werden
   - Tasks können gelöscht werden
   - Alle Tasks können aufgelistet werden

2. **Task-Eigenschaften**
   - ID (automatisch generiert)
   - Titel (Pflichtfeld)
   - Beschreibung (optional)
   - Status (offen/erledigt)
   - Erstellungsdatum

### Nicht-funktionale Anforderungen

1. **Implementierung**
   - Programmiersprache: Java
   - Einfache Konsolenanwendung
   - Objektorientiertes Design
   - Verwendung von Design Patterns wo sinnvoll

2. **Code-Qualität**
   - Gut lesbarer, dokumentierter Code
   - Sinnvolle Methodennamen
   - Kommentare wo notwendig

3. **Struktur**
   - Klare Trennung von Model, View und Logic
   - Einfache Benutzerführung über die Konsole

## Beispiel-Interaktion

```
=== Task Management System ===
1. Neue Aufgabe erstellen
2. Alle Aufgaben anzeigen
3. Aufgabe als erledigt markieren
4. Aufgabe löschen
5. Beenden

Wählen Sie eine Option: 1
Titel: Java lernen
Beschreibung: Strategy Pattern verstehen
Aufgabe erstellt mit ID: 1

Wählen Sie eine Option: 2
--- Alle Aufgaben ---
[1] [ ] Java lernen - Strategy Pattern verstehen
```

## Abgabe

Der Code soll im Ordner `ai-coding-agents/sample-app/` abgelegt werden.
