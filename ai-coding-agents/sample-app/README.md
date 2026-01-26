# Task Management System

Eine einfache Konsolenanwendung zur Verwaltung von Aufgaben, entwickelt als Demo für AI Coding Agents im Rahmen der Lehrveranstaltung Softwaretechnik.

## Funktionen

- ✅ Neue Aufgaben erstellen (mit Titel und Beschreibung)
- ✅ Alle Aufgaben anzeigen
- ✅ Aufgaben als erledigt markieren
- ✅ Aufgaben löschen
- ✅ Automatische ID-Vergabe
- ✅ Zeitstempel bei Erstellung

## Technische Details

### Architektur

Die Anwendung folgt einer klaren Trennung zwischen verschiedenen Komponenten:

- **Task.java** - Model-Klasse, repräsentiert eine einzelne Aufgabe
- **TaskManager.java** - Repository-Klasse, verwaltet alle Aufgaben
- **TaskManagerApp.java** - View/Controller, Benutzeroberfläche und Interaktionslogik

### Design-Prinzipien

- **Separation of Concerns**: Klare Trennung zwischen Daten (Model), Logik (Manager) und Präsentation (App)
- **Repository Pattern**: TaskManager kapselt die Datenverwaltung
- **Immutability**: Task-IDs und Erstellungsdatum sind unveränderlich
- **Optional-Pattern**: Verwendung von Optional für die Suche nach Tasks

## Kompilierung und Ausführung

### Voraussetzungen

- Java 8 oder höher

### Kompilieren

```bash
cd ai-coding-agents/sample-app
javac -d bin src/main/java/de/thm/swep/taskmanager/*.java
```

### Ausführen

```bash
cd ai-coding-agents/sample-app
java -cp bin de.thm.swep.taskmanager.TaskManagerApp
```

Alternativ (aus dem Wurzelverzeichnis):

```bash
javac -d ai-coding-agents/sample-app/bin ai-coding-agents/sample-app/src/main/java/de/thm/swep/taskmanager/*.java
java -cp ai-coding-agents/sample-app/bin de.thm.swep.taskmanager.TaskManagerApp
```

## Beispiel-Nutzung

```
=== Task Management System ===
Willkommen!

--- Hauptmenü ---
1. Neue Aufgabe erstellen
2. Alle Aufgaben anzeigen
3. Aufgabe als erledigt markieren
4. Aufgabe löschen
5. Beenden

Wählen Sie eine Option: 1

Titel: Java lernen
Beschreibung (optional): Strategy Pattern und Design Patterns verstehen
Aufgabe erstellt mit ID: 1

--- Hauptmenü ---
1. Neue Aufgabe erstellen
2. Alle Aufgaben anzeigen
3. Aufgabe als erledigt markieren
4. Aufgabe löschen
5. Beenden

Wählen Sie eine Option: 2

--- Alle Aufgaben ---
[1] [ ] Java lernen - Strategy Pattern und Design Patterns verstehen (erstellt: 26.01.2026 00:15)

Gesamt: 1 Aufgabe(n)

--- Hauptmenü ---
1. Neue Aufgabe erstellen
2. Alle Aufgaben anzeigen
3. Aufgabe als erledigt markieren
4. Aufgabe löschen
5. Beenden

Wählen Sie eine Option: 3

ID der zu erledigenden Aufgabe: 1
Aufgabe 1 wurde als erledigt markiert.

--- Hauptmenü ---
1. Neue Aufgabe erstellen
2. Alle Aufgaben anzeigen
3. Aufgabe als erledigt markieren
4. Aufgabe löschen
5. Beenden

Wählen Sie eine Option: 2

--- Alle Aufgaben ---
[1] [X] Java lernen - Strategy Pattern und Design Patterns verstehen (erstellt: 26.01.2026 00:15)

Gesamt: 1 Aufgabe(n)
```

## Struktur

```
sample-app/
├── README.md
└── src/
    └── main/
        └── java/
            └── de/
                └── thm/
                    └── swep/
                        └── taskmanager/
                            ├── Task.java            # Model-Klasse
                            ├── TaskManager.java     # Repository/Manager
                            └── TaskManagerApp.java  # Hauptanwendung
```

## Entwickelt von

AI Coding Agent für die Lehrveranstaltung Softwaretechnik bei Prof. Carsten Lucke
