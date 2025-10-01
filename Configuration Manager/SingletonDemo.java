// SingletonDemo.java
public class SingletonDemo {
    public static void main(String[] args) {
        System.out.println("--- Testing Singleton Configuration Manager ---");

        // Attempt 1: Get the first instance
        System.out.println("\nRequesting Manager 1...");
        ConfigurationManager manager1 = ConfigurationManager.getInstance();
        System.out.println("Manager 1 instance hash code: " + manager1.hashCode());
        System.out.println("Manager 1: " + manager1.getSetting("DB_URL"));

        // Attempt 2: Get a second instance
        System.out.println("\nRequesting Manager 2...");
        ConfigurationManager manager2 = ConfigurationManager.getInstance();
        System.out.println("Manager 2 instance hash code: " + manager2.hashCode());
        System.out.println("Manager 2: " + manager2.getSetting("APP_VERSION"));

        // Verification: Check if both references point to the same object
        if (manager1 == manager2) {
            System.out.println("\nSUCCESS: Manager 1 and Manager 2 refer to the same object.");
        } else {
            System.out.println("\nFAILURE: Multiple instances exist.");
        }
    }
}