// ScheduleManager.java
import java.util.*;
import java.util.logging.*;
import java.time.format.DateTimeParseException;
import java.util.stream.Collectors;

public class ScheduleManager {
    // Singleton Instance (volatile for thread safety in getInstance)
    private static volatile ScheduleManager instance;

    // Data structure: TreeSet keeps tasks sorted by startTime automatically
    private final SortedSet<Task> tasks = new TreeSet<>();

    // Observer List
    private final List<ConflictNotifier> observers = new ArrayList<>();

    // Logging setup
    private static final Logger LOGGER = Logger.getLogger(ScheduleManager.class.getName());

    // Private constructor for Singleton
    private ScheduleManager() {
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("ScheduleManager initialized.");
    }

    // Global access method for Singleton instance
    public static ScheduleManager getInstance() {
        if (instance == null) {
            synchronized (ScheduleManager.class) {
                if (instance == null) {
                    instance = new ScheduleManager();
                }
            }
        }
        return instance;
    }

    // Observer method
    public void addObserver(ConflictNotifier observer) { observers.add(observer); }
    
    // Notify observers of an event
    private void notifyObservers(String message) {
        for (ConflictNotifier observer : observers) {
            observer.update(message);
        }
    }

    // Core Business Logic (CRUD)

    public void addTask(String desc, String start, String end, String prio) {
        try {
            // 1. Creation using Factory Pattern
            Task newTask = TaskFactory.createTask(desc, start, end, prio);

            // 2. Mandatory Validation: Check for overlap
            for (Task existingTask : tasks) {
                if (newTask.conflictsWith(existingTask)) {
                    String conflictMsg = String.format("Task '%s' conflicts with existing task '%s'.", 
                                                        newTask.getDescription(), existingTask.getDescription());
                    
                    LOGGER.warning("Task conflict detected: " + conflictMsg);
                    notifyObservers(conflictMsg); // Notify via Observer Pattern
                    System.out.println("⛔ Operation failed: " + conflictMsg);
                    return;
                }
            }

            // 3. Add task and Log success
            tasks.add(newTask);
            System.out.println("✅ Task added successfully.");
            LOGGER.info("Task added: " + newTask.toString());

        } catch (DateTimeParseException | IllegalArgumentException e) {
            // Gold Standard: Exception Handling and Validations
            System.out.println("❌ Error: " + e.getMessage());
            LOGGER.log(Level.SEVERE, "Task creation failed.", e);
        }
    }

    public void removeTask(String description) {
        // Use stream to find the task by description
        Optional<Task> taskToRemove = tasks.stream()
            .filter(t -> t.getDescription().equalsIgnoreCase(description))
            .findFirst();

        if (taskToRemove.isPresent()) {
            tasks.remove(taskToRemove.get());
            System.out.println("🗑️ Task removed successfully: " + description);
            LOGGER.info("Task removed: " + description);
        } else {
            System.out.println("❌ Error: Task '" + description + "' not found.");
            LOGGER.warning("Attempt to remove non-existent task: " + description);
        }
    }

    public void viewAllTasks() {
        if (tasks.isEmpty()) {
            System.out.println("ℹ️ No tasks scheduled for the day.");
            return;
        }

        System.out.println("\n--- 🧑‍🚀 Astronaut Daily Schedule (Sorted by Time) ---");
        tasks.forEach(task -> System.out.println("   - " + task.toString()));
        System.out.println("-----------------------------------------------------");
    }
}