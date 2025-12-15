# Git Testingground

In diesem Ordner können Studierende gefahrlos mit Git-Workflows üben.

## Aufgabe

1. Kopiere `user.example.json` oder lege eine neue Datei nach dem Schema `vornameNachname.json` an (z. B. `carstenlucke.json`). Trage deine eigenen Daten ein.
2. Ergänze dich in `all-persons.json` unter `personen` mit Vor- und Nachnamen.
3. Committe beide Änderungen gemeinsam.

## Lernziel

- **Arbeit an separaten Dateien**: Solange jede Person nur ihre eigene JSON-Datei erstellt, entstehen keine Merge-Konflikte – parallel arbeiten ist möglich.
- **Arbeit an gemeinsamen Dateien**: Bei Änderungen an `all-persons.json` bearbeiten alle dieselbe Datei; dadurch können Merge-Konflikte entstehen, die bewusst gelöst werden müssen.

## Schritt-für-Schritt-Anleitung

1. **Vorbereitung**
   - Git installieren: https://git-scm.com/downloads (unter Windows empfiehlt sich zusätzlich Git Bash). Alternativ kann Git in vielen IDEs vorkonfiguriert genutzt werden.
   - Optionale IDE oder Editor: Visual Studio Code (https://code.visualstudio.com/) bietet integrierte Git-Ansicht, ebenso JetBrains IDEs, IntelliJ, WebStorm usw.
2. **Repository klonen**
   - Allgemein: Mit `git clone <url>` wird ein Remote-Repository lokal kopiert, anschließend wechselt man in den Ordner.
   - Für diese Übung:
   ```bash
   git clone https://github.com/carstenlucke/swt-lucke-public-ws2526.git
   cd git-testingground
   ```
3. **Aufgabe bearbeiten**
   - Neue Datei nach Vorgabe anlegen oder `user.example.json` kopieren und anpassen.
   - Dich selbst in `all-persons.json` ergänzen.
4. **Status prüfen**
   ```bash
   git status
   ```
5. **Änderungen zum Commit vormerken**
   ```bash
   git add vornameNachname.json all-persons.json
   ```
6. **Commit erstellen**
   ```bash
   git commit -m "Add <Vorname Nachname>"
   ```
7. **Änderungen hochladen**
   ```bash
   git push
   ```
8. **Aktualisierungen anderer abrufen**
   ```bash
   git pull
   ```
9. **Zusammenarbeit über IDEs**
   - In Visual Studio Code: Quellcodeverwaltung öffnen, Änderungen prüfen, Stage/Commit/Push per Buttons durchführen.
   - In anderen IDEs ähnlich vorgehen; wichtig ist, dass `git add`, `git commit`, `git push` und `git pull` ausgeführt werden.

> Tipp: Wenn `git push` aufgrund neuer Änderungen im Remote nicht funktioniert, zuerst `git pull` ausführen, Konflikte lösen und danach erneut pushen.
