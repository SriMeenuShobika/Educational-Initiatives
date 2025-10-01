// TaskFactory.java
import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class TaskFactory {
    // Factory method to create and validate Task objects
    public static Task createTask(String description, String startTimeStr, String endTimeStr, String priority) throws DateTimeParseException, IllegalArgumentException {
        LocalTime startTime;
        LocalTime endTime;

        try {
            // Parses time assuming HH:MM format
            startTime = LocalTime.parse(startTimeStr);
            endTime = LocalTime.parse(endTimeStr);
        } catch (DateTimeParseException e) {
            throw new DateTimeParseException("Invalid time format. Please use HH:MM (e.g., 08:30).", startTimeStr + " / " + endTimeStr, 0);
        }

        if (startTime.isAfter(endTime) || startTime.equals(endTime)) {
            throw new IllegalArgumentException("End time must be after start time.");
        }

        return new Task(description, startTime, endTime, priority);
    }
}