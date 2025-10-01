// ThirdPartyLogService.java
public class ThirdPartyLogService {
    // This method is different: it requires both the text and a severity level.
    public void writeLog(String text, String severity) {
        System.out.println("3rd Party Log [" + severity + "]: " + text);
    }
    
    public void logError(String text) {
        writeLog(text, "ERROR");
    }
}