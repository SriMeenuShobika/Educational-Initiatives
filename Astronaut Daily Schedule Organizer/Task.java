// Task.java
import java.time.LocalTime;

public class Task implements Comparable<Task> {
    private final String description;
    private final LocalTime startTime;
    private final LocalTime endTime;
    private final String priority;

    // Constructor (used by TaskFactory)
    public Task(String desc, LocalTime start, LocalTime end, String prio) {
        this.description = desc;
        this.startTime = start;
        this.endTime = end;
        this.priority = prio;
    }

    public LocalTime getStartTime() { return startTime; }
    public LocalTime getEndTime() { return endTime; }

    public String getDescription() { return description; }

    // Logic to check for time overlap: [start1, end1) and [start2, end2)
    public boolean conflictsWith(Task other) {
        return this.startTime.isBefore(other.endTime) && other.startTime.isBefore(this.endTime);
    }

    @Override
    public String toString() {
        return String.format("%s-%s: %s [Priority: %s]", startTime, endTime, description, priority);
    }

    // Mandatory sorting requirement: Tasks are sorted by start time
    @Override
    public int compareTo(Task other) {
        return this.startTime.compareTo(other.startTime);
    }
}