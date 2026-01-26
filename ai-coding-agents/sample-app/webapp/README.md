# Kontaktkarten-Webapp

Diese Webapp erstellt automatisch Kontaktkarten aus den JSON-Dateien im Verzeichnis
`git-testingground/`. Sie ist als lokaler Demonstrator fuer AI Coding Agents gedacht.

## Entscheidung: CSS-Variante
Ich nutze **Option A (Vanilla-CSS)**. So bleiben Layout, Farben und Interaktion vollstaendig
transparent und didaktisch nachvollziehbar (CSS Grid, Custom Properties, eigene Komponenten)
- ohne externe UI-Abhaengigkeiten.

## Features
- Zwei-Spalten-Layout: Personenliste links, Kontaktkarte rechts
- Dynamisches Rendering aller Attribute (unbekannte Schluessel werden angezeigt)
- Suche nach Namen sowie "Zurueck"/"Weiter" Navigation
- Verstaendliche Fehlermeldung bei Ladeproblemen

## Lokale Ausfuehrung
```bash
cd swt-lucke-public-ws2526
python3 -m http.server
```

Dann im Browser oeffnen:
```
http://localhost:8000/ai-coding-agents/sample-app/webapp/index.html
```

## Datenquelle
- Registry: `git-testingground/all-persons.json`
- Detaildateien: `git-testingground/<vorname><nachname>.json`
