const DATA_ROOT = "../../../git-testingground";

// UI references
const listEl = document.getElementById("personList");
const cardEl = document.getElementById("card");
const errorEl = document.getElementById("error");
const listStatusEl = document.getElementById("listStatus");
const searchInput = document.getElementById("searchInput");
const prevBtn = document.getElementById("prevBtn");
const nextBtn = document.getElementById("nextBtn");

// App state (all people, filtered list, selected card)
let people = [];
let filteredPeople = [];
let selectedId = null;

const normalizeName = (person) =>
  `${person.vorname ?? ""} ${person.nachname ?? ""}`.trim();

const formatValue = (value) => {
  if (value === null || value === undefined) return "-";
  if (Array.isArray(value)) return value.join(", ");
  if (typeof value === "object") return JSON.stringify(value);
  return String(value);
};

const setError = (message) => {
  errorEl.textContent = message;
  errorEl.hidden = !message;
};

// Fetch JSON with basic HTTP error handling.
const fetchJson = async (url) => {
  const response = await fetch(url);
  if (!response.ok) {
    throw new Error(`${response.status} ${response.statusText}`);
  }
  return response.json();
};

const getSelectedIndex = () =>
  filteredPeople.findIndex(
    (person) => (person._source || normalizeName(person)) === selectedId
  );

const updateNavButtons = () => {
  const index = getSelectedIndex();
  prevBtn.disabled = index <= 0;
  nextBtn.disabled = index === -1 || index >= filteredPeople.length - 1;
};

const renderList = () => {
  listEl.innerHTML = "";

  if (filteredPeople.length === 0) {
    if (people.length === 0) {
      listStatusEl.textContent = "Keine Daten vorhanden.";
    } else {
      listStatusEl.textContent = `0 Treffer von ${people.length}`;
    }
    updateNavButtons();
    return;
  }

  listStatusEl.textContent =
    filteredPeople.length === people.length
      ? `${people.length} Personen`
      : `${filteredPeople.length} Treffer von ${people.length}`;
  filteredPeople.forEach((person, index) => {
    const li = document.createElement("li");
    const button = document.createElement("button");
    button.type = "button";
    button.className = "person-button";
    button.textContent = normalizeName(person) || "Unbekannter Name";
    if ((person._source || normalizeName(person)) === selectedId) {
      button.classList.add("active");
    }
    button.addEventListener("click", () => selectByIndex(index));
    li.appendChild(button);
    listEl.appendChild(li);
  });

  updateNavButtons();
};

const renderCard = (person) => {
  cardEl.innerHTML = "";

  const title = document.createElement("h3");
  title.textContent = normalizeName(person) || "Unbekannte Person";
  cardEl.appendChild(title);

  const meta = document.createElement("p");
  meta.className = "meta";
  meta.textContent = person._source
    ? `Datei: ${person._source}`
    : "";
  if (meta.textContent) {
    cardEl.appendChild(meta);
  }

  const kv = document.createElement("dl");
  kv.className = "kv";

  const keys = Object.keys(person).filter(
    (key) =>
      !["vorname", "nachname"].includes(key) &&
      !key.startsWith("_")
  );

  keys.sort((a, b) => {
    if (a === "email") return -1;
    if (b === "email") return 1;
    return a.localeCompare(b, "de");
  });

  if (keys.length === 0) {
    const empty = document.createElement("p");
    empty.className = "placeholder";
    empty.textContent = "Keine weiteren Attribute gefunden.";
    cardEl.appendChild(empty);
    return;
  }

  keys.forEach((key) => {
    const dt = document.createElement("dt");
    dt.textContent = key;
    const dd = document.createElement("dd");
    dd.textContent = formatValue(person[key]);
    kv.appendChild(dt);
    kv.appendChild(dd);
  });

  cardEl.appendChild(kv);
};

const selectByIndex = (index) => {
  if (index < 0 || index >= filteredPeople.length) return;
  const person = filteredPeople[index];
  selectedId = person._source || normalizeName(person);
  renderList();
  renderCard(person);
};

const applyFilter = () => {
  const query = searchInput.value.trim().toLowerCase();
  filteredPeople = people.filter((person) =>
    normalizeName(person).toLowerCase().includes(query)
  );
  if (
    filteredPeople.length > 0 &&
    !filteredPeople.some(
      (person) => (person._source || normalizeName(person)) === selectedId
    )
  ) {
    selectedId = filteredPeople[0]._source || normalizeName(filteredPeople[0]);
  }
  renderList();
  if (filteredPeople.length > 0) {
    const index = getSelectedIndex();
    if (index >= 0) {
      renderCard(filteredPeople[index]);
    }
  } else {
    cardEl.innerHTML =
      '<p class="placeholder">Keine Person ausgewaehlt.</p>';
  }
};

// Load registry + detail files, then render list and first card.
const loadData = async () => {
  listStatusEl.textContent = "Lade Daten...";
  setError("");

  try {
    const registry = await fetchJson(`${DATA_ROOT}/all-persons.json`);
    const entries = Array.isArray(registry.personen) ? registry.personen : [];
    const withFiles = entries.filter((person) => person.jsonfile);

    if (withFiles.length === 0) {
      listStatusEl.textContent = "Keine Personen mit Detaildatei gefunden.";
      return;
    }

    const details = await Promise.all(
      withFiles.map(async (person) => {
        const detail = await fetchJson(`${DATA_ROOT}/${person.jsonfile}`);
        return { ...detail, _source: person.jsonfile };
      })
    );

    people = details;
    selectedId = people[0]._source || normalizeName(people[0]);
    applyFilter();
  } catch (error) {
    listStatusEl.textContent = "";
    setError(
      `Fehler beim Laden der Daten. Stelle sicher, dass ein lokaler Webserver laeuft. (${error.message})`
    );
    cardEl.innerHTML =
      '<p class="placeholder">Daten konnten nicht geladen werden.</p>';
  }
};

searchInput.addEventListener("input", applyFilter);

prevBtn.addEventListener("click", () => {
  const index = getSelectedIndex();
  if (index > 0) {
    selectByIndex(index - 1);
  }
});

nextBtn.addEventListener("click", () => {
  const index = getSelectedIndex();
  if (index >= 0 && index < filteredPeople.length - 1) {
    selectByIndex(index + 1);
  }
});

loadData();
