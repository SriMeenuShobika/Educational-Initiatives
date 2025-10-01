// AstronautScheduleApp.java
import java.util.Scanner;

public class AstronautScheduleApp {
    
    private boolean running = true; // Use boolean flag for control flow
    private final ScheduleManager manager;
    private final Scanner scanner;

    public AstronautScheduleApp() {
        // Get the Singleton instance
        manager = ScheduleManager.getInstance();
        
        // Register the Console Observer
        manager.addObserver(new ConsoleObserver()); 
        
        // Initialize scanner for input
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("\n-------------------------------------------");
        System.out.println("      ASTRONAUT SCHEDULE ORGANIZER");
        System.out.println("-------------------------------------------");
        System.out.println("1. Add Task");
        System.out.println("2. Remove Task");
        System.out.println("3. View All Tasks");
        System.out.println("4. Exit");
        System.out.print("Enter choice (1-4): ");
    }

    private void handleInput(String choice) {
        try {
            switch (choice.trim()) {
                case "1":
                    System.out.print("Enter Description: "); String desc = scanner.nextLine().trim();
                    System.out.print("Enter Start Time (HH:MM, e.g., 08:30): "); String start = scanner.nextLine().trim();
                    System.out.print("Enter End Time (HH:MM): "); String end = scanner.nextLine().trim();
                    System.out.print("Enter Priority (High/Medium/Low): "); String prio = scanner.nextLine().trim();
                    manager.addTask(desc, start, end, prio);
                    break;
                case "2":
                    System.out.print("Enter Task Description to Remove: "); String removeDesc = scanner.nextLine().trim();
                    manager.removeTask(removeDesc);
                    break;
                case "3":
                    manager.viewAllTasks();
                    break;
                case "4":
                    this.running = false;
                    System.out.println("👋 Exiting application. Mission accomplished.");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice. Please enter a number from 1 to 4.");
            }
        } catch (Exception e) {
            // General exception handler for unexpected issues
            System.out.println("🔥 An unexpected system error occurred: " + e.getMessage());
        }
    }

    public void start() {
        while (running) {
            showMenu();
            if (scanner.hasNextLine()) {
                handleInput(scanner.nextLine());
            }
        }
        scanner.close();
    }

    public static void main(String[] args) {
        // Ensure that the logging system is ready before starting the app
        java.util.logging.LogManager.getLogManager().reset();
        new AstronautScheduleApp().start();
    }
}