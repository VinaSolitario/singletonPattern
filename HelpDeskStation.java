// Represents a help desk station
public class HelpDeskStation {
    private String stationName;
    private QueueSystem queueSystem;

    public HelpDeskStation(String stationName) {
        this.stationName = stationName;
        this.queueSystem = QueueSystem.getInstance();
    }

    // Serve the next customer
    public void serveNextCustomer() {
        int nextCustomer = queueSystem.callNext();
        if (nextCustomer != -1) {
            System.out.println(stationName + " is serving customer number " + nextCustomer);
        } else {
            System.out.println(stationName + ": No customers in queue.");
        }
    }

    // Reset the queue
    public void resetQueue(int startingNumber) {
        System.out.println(stationName + ": Resetting queue to start from " + startingNumber);
        queueSystem.resetQueue(startingNumber);
    }

    // Check the current status of the queue
    public void checkQueueStatus() {
        System.out.println(stationName + " checking queue status:");
        queueSystem.displayQueueStatus();
    }
}
