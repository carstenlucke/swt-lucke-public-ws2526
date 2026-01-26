# Prompt-Spezifikation: Kontaktkarten-Webapp

## Ziel der Aufgabe
Entwickle eine **rein lokale Webanwendung**, die im Browser läuft und für alle Kursteilnehmenden,
die im Repository eine persönliche JSON-Datei hinterlegt haben, automatisch **Kontaktkarten**
erstellt und darstellt.

Die Anwendung dient als **Demonstrator für AI Coding Agents** in einer Vorlesung.

---

## Kontext & Datenbasis

### Repository
- Relevantes Verzeichnis: `git-testingground/`

### Zentrale Registry: `all-persons.json`
- Enthält unter dem Schlüssel `personen` eine Liste von Personenobjekten
- Jedes Objekt enthält:
  - `vorname`
  - `nachname`
  - optional: `jsonfile` (Name der Detaildatei)

**Wichtig**
- Nur Einträge **mit `jsonfile`** haben eine Detaildatei
- Einträge ohne `jsonfile` sind Dummy- oder Platzhalterpersonen

### Persönliche JSON-Dateien
- Dateiname: `<vorname><nachname>.json` (z. B. `carstenlucke.json`)
- Pflichtfelder:
  - `vorname`
  - `nachname`
  - `email`
- Beliebige zusätzliche Felder erlaubt (z. B. `hobby`, `studiengang`, `lieblingssprache`, …)
- Struktur und Schlüssel sind **nicht vorher bekannt**

---

## Anforderungen an die Webanwendung

### 1. Projektstruktur
Lege ein neues Unterverzeichnis an, z. B.:

```text
webapp/
├── index.html
├── style.css
├── app.js
└── README.md
```

---

### 2. HTML (`index.html`)
- Einfache, semantische HTML-Struktur
- Enthält:
  - Überschrift / Titel der App
  - Linke Spalte: Liste der Personen
  - Rechte Spalte: Kontaktkarte der ausgewählten Person
- Bindet `style.css` und `app.js` ein

---

### 3. Styling (`style.css`)
- Übersichtliches Zwei-Spalten-Layout
- Linke Seite: Personenliste
- Rechte Seite: Kontaktkarte
- Kontaktkarte enthält:
  - Name als Überschrift
  - Liste aller weiteren Attribute als Key–Value-Darstellung
- Schlichtes, gut lesbares Design (Abstände, Rahmen, Farben)

---

### 4. Logik (`app.js`)

#### Daten laden
1. Lade `git-testingground/all-persons.json` per `fetch`
2. Filtere alle Personen mit vorhandenem `jsonfile`
3. Lade für jede dieser Personen die entsprechende Detail-JSON-Datei

#### Datenverarbeitung
- Die Schlüssel der JSON-Dateien sind **dynamisch**
- Iteriere über alle Attribute eines Personenobjekts
- Behandle `vorname` und `nachname` besonders (z. B. als Überschrift)

#### Interaktion
- Erzeuge aus den geladenen Daten die Personenliste
- Klick auf einen Namen:
  - Zeigt die zugehörige Kontaktkarte an
- Optional:
  - Next / Previous Buttons
  - Suchfeld für Namen

#### Fehlerbehandlung
- Abfangen von Fetch-Fehlern
- Verständliche Fehlermeldung im UI anzeigen

---

## Lokale Ausführung

Da Browser keine lokalen JSON-Dateien per `file://` laden dürfen:

### Start eines lokalen Webservers (Beispiel)
```bash
cd swt-lucke-public-ws2526
python3 -m http.server
```

### Aufruf im Browser
```
http://localhost:8000/webapp/index.html
```

---

## Technische Vorgaben
- Reines JavaScript (kein Framework)
- Moderne Syntax:
  - `const`, `let`
  - `async / await`
- Klar strukturierter, gut kommentierter Code
\- Fokus auf Verständlichkeit (Lehrbeispiel)

---

## UI‑Design & Framework‑Optionen

Die Benutzeroberfläche der Webapp soll klar und leichtgewichtig sein. Es ist ausdrücklich nicht erwünscht, schwere Frameworks wie Bootstrap oder Tailwind CSS zu nutzen (oft 40–50 KB gzipped). Stattdessen gibt es zwei mögliche Ansätze:

### 1. Eigenes Styling mit Vanilla CSS

- **Flexbox und Grid:** Definiere dein eigenes responsives Zwei‑Spalten‑Layout mit CSS Grid oder Flexbox. Halte die Margen und Abstände konsistent.
- **Typografie und Farben:** Wähle eine gut lesbare Schrift (z. B. System‑Fonts oder Google Fonts). Verwende wenige abgestimmte Farben und achte auf ausreichenden Kontrast für Barrierefreiheit.
- **Komponenten:** Gestalte Karten (Border, Schatten, Padding) und die Personenliste selbst. So hast du vollständige Kontrolle über das Erscheinungsbild und vermeidest Abhängigkeiten.

### 2. Leichtgewichtige CSS‑Frameworks per CDN

Wenn du ein bisschen Unterstützung bei Layout und Standard‑Stilen möchtest, aber kein schweres Framework laden willst, kannst du eines der folgenden sehr kleinen CSS‑Frameworks via CDN einbinden. Jedes lässt sich mit einem einzelnen `<link rel="stylesheet" …>` in der `<head>` deines HTML aktivieren:

- **Milligram (≈ 2 KB)** – Ein minimalistisches Framework mit responsive Grid, Typografie‑Defaults, Formular‑ und Button‑Stilen. Es hat keine JavaScript‑Abhängigkeiten und wiegt nur etwa 2 KB【575549284374480†L165-L181】. Ideal für performante Seiten; du kannst es via CDN in der Kopfzeile einbinden.
- **Water.css (≈ 2.2 KB)** – Ein klassloses Framework, das rohe HTML‑Elemente automatisch ansprechend stylt und sogar einen Dark‑Mode mitbringt【575549284374480†L214-L233】. Du schreibst semantisches HTML ohne extra Klassen; Water.css kümmert sich um die Optik.
- **Pure.css (≈ 3.7 KB)** – Bietet ein winziges responsives Grid sowie grundlegende Form‑ und Button‑Styles【575549284374480†L248-L279】. Es wird von großen Projekten eingesetzt, weil es stabil und extrem schlank ist.
- **Chota (≈ 3 KB)** – Ein sehr kleines Framework mit eingebautem Dark‑Mode, responsivem Grid und CSS‑Variablen für die Anpassung【575549284374480†L296-L315】. Es hat sinnvolle Klassennamen (`.container`, `.button`, `.input`) und ist perfekt für schnelle MVPs.
- **Pico CSS (≈ 7.7 KB)** – Ein etwas umfangreicheres, aber immer noch kleines Framework für semantisches HTML mit automatischer Dark/Light‑Erkennung und CSS‑Variablen für einfache Anpassungen【575549284374480†L421-L446】. Es ist besonders geeignet, wenn du modernere Komponenten benötigst, ohne ein großes Framework zu importieren.

Alle genannten Frameworks können über CDNs wie jsDelivr oder cdnjs eingebunden werden. Du kannst sie auch kombinieren: Nutze z. B. Milligram für Layout und schreibe eigene Styles für die Kontaktkarten. Achte darauf, nur das zu importieren, was du brauchst.


---

## Zusammenfassung
Die Anwendung ist bewusst **einfach**, aber realistisch:
- echte Dateien
- echte Constraints
- offene Datenstrukturen

Sie eignet sich ideal, um zu demonstrieren, wie **AI Coding Agents** aus einer Spezifikation
eigenständig lauffähige Software erzeugen.


---

## UI-Design-Vorgaben & CSS-Optionen

Die Anwendung soll **bewusst leichtgewichtig** bleiben. Ziel ist ein klares, funktionales UI
ohne komplexe Build-Schritte oder schwere Frameworks.

❌ **Nicht erlaubt**
- Bootstrap
- Tailwind CSS (inkl. DaisyUI)
- Material UI
- sonstige komponentenlastige Frameworks

Erlaubt sind **entweder pures Vanilla-CSS** oder **sehr schlanke CSS-Frameworks**, die direkt
über ein CDN eingebunden werden können.

---

### Option A: Reines Vanilla-CSS (empfohlen für Lehrzwecke)

Diese Option ist didaktisch besonders wertvoll.

**Vorgaben**
- Nutzung moderner CSS-Features:
  - Flexbox oder CSS Grid
  - CSS Custom Properties (`--primary-color`, …)
- Keine Präprozessoren (kein SCSS/Less)
- Klar benannte Klassen (z. B. `.sidebar`, `.card`, `.person-list`)

**Empfohlene UI-Elemente**
- Zwei-Spalten-Layout (Liste links, Detailkarte rechts)
- Hover- und Active-Zustände für Listeneinträge
- Dezente Kartenoptik (Border, Shadow, Padding)
- Responsives Verhalten (Spalten untereinander auf schmalen Viewports)

---

### Option B: Sehr leichtgewichtiges CSS-Framework (via CDN)

Alternativ darf **ein einziges** der folgenden Frameworks genutzt werden.

#### 1. Milligram
- ca. **2 KB gzipped**
- Klassisch, minimalistisch
- Gutes Grid-System, Form- und Typografie-Defaults

```html
<link rel="stylesheet"
      href="https://cdnjs.cloudflare.com/ajax/libs/milligram/1.4.1/milligram.min.css">
```

---

#### 2. Water.css
- ca. **2.2 KB**
- **Classless CSS**: stylt pures HTML ohne Klassen

```html
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/water.css@2/out/water.css">
```

---

#### 3. Pure.css
- ca. **3.7 KB**
- Sehr leichtes Grid- und Layout-System

```html
<link rel="stylesheet"
      href="https://unpkg.com/purecss@3.0.0/build/pure-min.css">
```

---

#### 4. Chota
- ca. **3 KB**
- Modern, mit CSS-Variablen und Dark-Mode-Unterstützung

```html
<link rel="stylesheet" href="https://unpkg.com/chota@latest">
```

---

#### 5. Pico CSS
- ca. **7–8 KB**
- Classless + konfigurierbar
- Sehr gutes Default-Design

```html
<link rel="stylesheet" href="https://unpkg.com/@picocss/pico@latest/css/pico.min.css">
```

---

### Entscheidungsvorgabe für den Agenten

Der Agent soll sich **explizit für genau eine Variante entscheiden** und diese Entscheidung
kurz im README begründen.

---

### Didaktischer Hinweis

Dieses Kapitel ist absichtlich detailliert:
- Es zwingt den Agenten zu einer **Design-Entscheidung**
- Es verhindert reflexartiges „Bootstrap einbinden“
- Es eignet sich zur Diskussion von Overengineering, Bundle-Größe und Kontrolle
