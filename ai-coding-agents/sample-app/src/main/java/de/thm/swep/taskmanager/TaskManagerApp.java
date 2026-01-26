package de.thm.swep.taskmanager;

import java.util.List;
import java.util.Scanner;

/**
 * Hauptklasse für die Konsolenanwendung des Task Management Systems.
 * Diese Klasse implementiert die View und Controller-Logik und 
 * ist verantwortlich für die Benutzerinteraktion.
 */
public class TaskManagerApp {
    private final TaskManager taskManager;
    private boolean running;

    public TaskManagerApp() {
        this.taskManager = new TaskManager();
        this.running = true;
    }

    /**
     * Haupteinstiegspunkt der Anwendung.
     */
    public static void main(String[] args) {
        TaskManagerApp app = new TaskManagerApp();
        app.run();
    }

    /**
     * Startet die Hauptschleife der Anwendung.
     */
    public void run() {
        System.out.println("=== Task Management System ===");
        System.out.println("Willkommen!\n");

        try (Scanner scanner = new Scanner(System.in)) {
            while (running) {
                showMenu();
                int choice = readChoice(scanner);
                handleChoice(choice, scanner);
            }
        }

        System.out.println("Auf Wiedersehen!");
    }

    /**
     * Zeigt das Hauptmenü an.
     */
    private void showMenu() {
        System.out.println("\n--- Hauptmenü ---");
        System.out.println("1. Neue Aufgabe erstellen");
        System.out.println("2. Alle Aufgaben anzeigen");
        System.out.println("3. Aufgabe als erledigt markieren");
        System.out.println("4. Aufgabe löschen");
        System.out.println("5. Beenden");
        System.out.print("\nWählen Sie eine Option: ");
    }

    /**
     * Liest die Benutzereingabe für die Menüauswahl.
     * 
     * @param scanner Der Scanner für die Eingabe
     * @return Die gewählte Option oder -1 bei ungültiger Eingabe
     */
    private int readChoice(Scanner scanner) {
        try {
            String input = scanner.nextLine();
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    /**
     * Verarbeitet die Menüauswahl des Benutzers.
     * 
     * @param choice Die gewählte Menüoption
     * @param scanner Der Scanner für die Eingabe
     */
    private void handleChoice(int choice, Scanner scanner) {
        System.out.println();
        switch (choice) {
            case 1:
                createNewTask(scanner);
                break;
            case 2:
                showAllTasks();
                break;
            case 3:
                markTaskAsCompleted(scanner);
                break;
            case 4:
                deleteTask(scanner);
                break;
            case 5:
                running = false;
                break;
            default:
                System.out.println("Ungültige Option. Bitte wählen Sie eine Zahl zwischen 1 und 5.");
        }
    }

    /**
     * Erstellt eine neue Aufgabe basierend auf Benutzereingaben.
     * 
     * @param scanner Der Scanner für die Eingabe
     */
    private void createNewTask(Scanner scanner) {
        System.out.print("Titel: ");
        String title = scanner.nextLine().trim();

        if (title.isEmpty()) {
            System.out.println("Fehler: Titel darf nicht leer sein.");
            return;
        }

        System.out.print("Beschreibung (optional): ");
        String description = scanner.nextLine().trim();

        Task task = taskManager.createTask(title, description);
        System.out.println("Aufgabe erstellt mit ID: " + task.getId());
    }

    /**
     * Zeigt alle vorhandenen Aufgaben an.
     */
    private void showAllTasks() {
        List<Task> tasks = taskManager.getAllTasks();

        if (tasks.isEmpty()) {
            System.out.println("Keine Aufgaben vorhanden.");
            return;
        }

        System.out.println("--- Alle Aufgaben ---");
        for (Task task : tasks) {
            System.out.println(task);
        }
        System.out.println("\nGesamt: " + tasks.size() + " Aufgabe(n)");
    }

    /**
     * Markiert eine Aufgabe als erledigt.
     * 
     * @param scanner Der Scanner für die Eingabe
     */
    private void markTaskAsCompleted(Scanner scanner) {
        System.out.print("ID der zu erledigenden Aufgabe: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (taskManager.completeTask(id)) {
                System.out.println("Aufgabe " + id + " wurde als erledigt markiert.");
            } else {
                System.out.println("Fehler: Aufgabe mit ID " + id + " wurde nicht gefunden.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Fehler: Ungültige ID.");
        }
    }

    /**
     * Löscht eine Aufgabe.
     * 
     * @param scanner Der Scanner für die Eingabe
     */
    private void deleteTask(Scanner scanner) {
        System.out.print("ID der zu löschenden Aufgabe: ");
        try {
            int id = Integer.parseInt(scanner.nextLine());
            if (taskManager.deleteTask(id)) {
                System.out.println("Aufgabe " + id + " wurde gelöscht.");
            } else {
                System.out.println("Fehler: Aufgabe mit ID " + id + " wurde nicht gefunden.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Fehler: Ungültige ID.");
        }
    }
}
