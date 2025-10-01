// AdapterDemo.java
public class AdapterDemo {
    public static void main(String[] args) {
        System.out.println("--- System Initialization ---");
        
        // 1. Instantiate the Adaptee (the modern logging tool)
        ThirdPartyLogService newService = new ThirdPartyLogService();

        // 2. Instantiate the Adapter, passing in the Adaptee
        LegacyLogger adapter = new LoggerAdapter(newService);

        System.out.println("\n--- Client Code Using Legacy Interface ---");

        // Client code only knows about the LegacyLogger interface.
        // It calls logMessage, but the adapter internally uses the new service.
        adapter.logMessage("Successful database connection established.");
        adapter.logMessage("Data processed successfully.");

        System.out.println("\n--- Direct Call to New Service (for comparison) ---");
        // We can also call the new service directly if we want different functionality.
        newService.logError("CRITICAL: Server timeout detected.");
    }
}