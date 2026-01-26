package de.thm.swep.taskmanager;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Repräsentiert eine einzelne Aufgabe im Task Management System.
 * Diese Klasse folgt dem Model-Konzept und enthält alle relevanten Daten einer Aufgabe.
 */
public class Task {
    private final int id;
    private String title;
    private String description;
    private boolean completed;
    private final LocalDateTime createdAt;

    /**
     * Konstruktor für eine neue Aufgabe.
     * 
     * @param id Die eindeutige ID der Aufgabe
     * @param title Der Titel der Aufgabe (Pflichtfeld)
     * @param description Die Beschreibung der Aufgabe (optional)
     */
    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.completed = false;
        this.createdAt = LocalDateTime.now();
    }

    // Getter und Setter
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    /**
     * Gibt eine formatierte Darstellung der Aufgabe zurück.
     * 
     * @return String-Repräsentation der Aufgabe
     */
    @Override
    public String toString() {
        String statusSymbol = completed ? "X" : " ";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        String formattedDate = createdAt.format(formatter);
        
        String result = String.format("[%d] [%s] %s", id, statusSymbol, title);
        if (description != null && !description.isEmpty()) {
            result += " - " + description;
        }
        result += String.format(" (erstellt: %s)", formattedDate);
        
        return result;
    }
}
