package de.thm.swep.taskmanager;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Verwaltet alle Tasks und bietet CRUD-Operationen.
 * Diese Klasse implementiert das Repository Pattern und ist verantwortlich
 * für die Datenverwaltung der Tasks.
 */
public class TaskManager {
    private final List<Task> tasks;
    private int nextId;

    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.nextId = 1;
    }

    /**
     * Erstellt eine neue Aufgabe.
     * 
     * @param title Der Titel der Aufgabe
     * @param description Die Beschreibung der Aufgabe
     * @return Die neu erstellte Aufgabe
     */
    public Task createTask(String title, String description) {
        Task task = new Task(nextId++, title, description);
        tasks.add(task);
        return task;
    }

    /**
     * Gibt alle Aufgaben zurück.
     * 
     * @return Liste aller Aufgaben
     */
    public List<Task> getAllTasks() {
        return new ArrayList<>(tasks);
    }

    /**
     * Sucht eine Aufgabe anhand ihrer ID.
     * 
     * @param id Die ID der gesuchten Aufgabe
     * @return Optional mit der Aufgabe, falls gefunden
     */
    public Optional<Task> findTaskById(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
    }

    /**
     * Markiert eine Aufgabe als erledigt.
     * 
     * @param id Die ID der Aufgabe
     * @return true, wenn die Aufgabe gefunden und markiert wurde
     */
    public boolean completeTask(int id) {
        Optional<Task> taskOpt = findTaskById(id);
        if (taskOpt.isPresent()) {
            taskOpt.get().setCompleted(true);
            return true;
        }
        return false;
    }

    /**
     * Löscht eine Aufgabe.
     * 
     * @param id Die ID der zu löschenden Aufgabe
     * @return true, wenn die Aufgabe gefunden und gelöscht wurde
     */
    public boolean deleteTask(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

    /**
     * Gibt die Anzahl der Aufgaben zurück.
     * 
     * @return Anzahl der Aufgaben
     */
    public int getTaskCount() {
        return tasks.size();
    }
}
