// ConfigurationManager.java
public class ConfigurationManager {
    // 1. The private static instance of the class (the single instance)
    // volatile ensures visibility across threads, necessary for the double-checked locking below.
    private static volatile ConfigurationManager instance;

    // A dummy configuration property
    private String databaseUrl;

    // 2. Private constructor to prevent direct instantiation (new ConfigurationManager())
    private ConfigurationManager() {
        // Initialization logic: This block runs ONLY ONCE.
        System.out.println("Configuration Manager Initialized. (Loading settings...)");
        this.databaseUrl = "jdbc:mysql://localhost:3306/app_db";
    }

    // 3. Public static method to get the instance (Global access point)
    public static ConfigurationManager getInstance() {
        // Double-checked locking for thread safety and performance
        if (instance == null) {
            // Synchronize only on the first creation
            synchronized (ConfigurationManager.class) {
                if (instance == null) {
                    // Lazy initialization: instance is created only when requested
                    instance = new ConfigurationManager();
                }
            }
        }
        return instance;
    }

    // Example getter method for configuration data
    public String getSetting(String key) {
        if (key.equalsIgnoreCase("DB_URL")) {
            return "Database URL: " + databaseUrl;
        } else if (key.equalsIgnoreCase("APP_VERSION")) {
            return "Application Version: 1.0.0";
        }
        return "Setting not found.";
    }
}