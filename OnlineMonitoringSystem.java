// Represents the online monitoring system
public class OnlineMonitoringSystem {
    private QueueSystem queueSystem;

    public OnlineMonitoringSystem() {
        this.queueSystem = QueueSystem.getInstance();
    }

    // Display the current queue status
    public void displayQueueStatus() {
        System.out.println("---- Online Monitoring System ----");
        queueSystem.displayQueueStatus();
        System.out.println("----------------------------------");
    }

    // Display the next customer to be served
    public void displayNextInQueue() {
        int currentNumber = queueSystem.getCurrentNumber();
        System.out.println("Next customer to be served: " + (currentNumber + 1));
    }
}
