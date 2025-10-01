// LoggerAdapter.java
public class LoggerAdapter implements LegacyLogger {
    // Hold a reference to the Adaptee (the class being adapted)
    private ThirdPartyLogService thirdPartyService;

    public LoggerAdapter(ThirdPartyLogService service) {
        this.thirdPartyService = service;
    }

    // This method is the "adapter" logic.
    // It maps the simple logMessage call (LegacyLogger) 
    // to the more complex writeLog call (ThirdPartyLogService).
    @Override
    public void logMessage(String message) {
        // We assume any logMessage from the legacy system is an "INFO" level event.
        System.out.print("Adapter translating call... ");
        thirdPartyService.writeLog(message, "INFO");
    }
}