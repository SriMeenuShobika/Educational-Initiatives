// ConsoleObserver.java
public class ConsoleObserver implements ConflictNotifier {
    @Override
    public void update(String message) {
        System.out.println("🚨 CONFLICT ALERT: " + message);
    }
}