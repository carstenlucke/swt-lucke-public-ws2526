# SWT Lucke Public WS2526

Dieses Repository bündelt Material und Übungsaufgaben für die Lehrveranstaltung Softwaretechnik (SWT) bei Prof. Carsten Lucke. Es deckt mehrere Aspekte der Vorlesung ab: Design-Pattern-Implementierungen, Unit Testing sowie Git/GitHub-Übungen.

## Aufbau

| Pfad | Thema | Beschreibung |
| --- | --- | --- |
| `src/de/thm/swep/simucharacter` | Strategy Pattern (Übung) | SimUCharacter bildet ein Übungsbeispiel zum Strategy Pattern. Studierende können eigene Charakter-Strategien implementieren und austauschen. |
| `src/de/thm/swep/simuduck` | Strategy Pattern (Vorlesung) | SimUDuck zeigt das Vorlesungsbeispiel zum Strategy Pattern und dient als Referenz für die Implementierung mit austauschbaren Verhalten. |
| `src/de/thm/swep/unittesting` | Modul- und Unit-Testing | Enthält Beispiele für Unit-Tests, Teststrategien und modulare Tests, inklusive Beispielcode für Testframeworks. |
| `git-testingground` | Git/GitHub-Training | Ein abgesicherter Bereich, um Git-Befehle, Workflows und Merge-Konfliktlösungen zu üben. Enthält eine detaillierte Aufgabenbeschreibung. |

## Nutzung

1. **Repository klonen**
   ```bash
   git clone https://github.com/carstenlucke/swt-lucke-public-ws2526.git
   cd swt-lucke-public-ws2526
   ```
2. **IDE/Editor wählen** – Empfohlen werden IntelliJ IDEA oder Visual Studio Code (mit Java- und Git-Unterstützung).
3. **Teilbereiche bearbeiten**
   - Strategy-Pattern-Beispiele in den `simucharacter`- und `simuduck`-Paketen studieren oder erweitern.
   - Unit-Tests unter `unittesting` ausführen bzw. ergänzen. Abhängig vom Build-System (z. B. Maven/Gradle) die passenden Testbefehle nutzen.
   - Git-Workflows gemäß `git-testingground/README.md` einüben.

## Ziele pro Themenbereich

- **Design Patterns**: Verständnis des Strategy Patterns, Implementierung eigener Strategien, Austausch von Verhalten zur Laufzeit.
- **Unit Testing**: Schreiben und Strukturieren von Modultests, sinnvolle Testfälle definieren und Testframeworks sicher anwenden.
- **Versionsverwaltung**: Praktische Übung mit Git-Workflows (Clone, Branching, Commit, Push/Pull, Merge-Konflikte), sowie Nutzung von GitHub Pull Requests.

## Weiterführende Hinweise

- Der Code dient als Ausgangspunkt für Übungen; Forks oder eigene Branches sind willkommen.
- Dokumentation und Hinweise in den Unterordnern lesen, bevor Änderungen vorgenommen werden.
- Für Fragen oder Feedback bitte Issues bzw. Pull Requests auf GitHub nutzen.

### Collaborator-Einladung

> **Wichtig:** Wer Zugriff als Collaborator benötigt, schickt mir bitte von seiner THM-MND-Mailadresse eine kurze Nachricht mit dem GitHub-Nutzernamen; ich nehme euch anschließend auf.
