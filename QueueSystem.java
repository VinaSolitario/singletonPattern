import java.util.LinkedList;
import java.util.Queue;

// Singleton class for the centralized queue system
public class QueueSystem {
    private static QueueSystem instance;
    private int currentNumber;
    private int nextNumber;
    private Queue<Integer> queue;

    // Private constructor for Singleton
    private QueueSystem() {
        this.currentNumber = 0;
        this.nextNumber = 1;
        this.queue = new LinkedList<>();
    }

    // Get the single instance of QueueSystem
    public static synchronized QueueSystem getInstance() {
        if (instance == null) {
            instance = new QueueSystem();
        }
        return instance;
    }

    // Issue a new ticket and add to the queue
    public synchronized int issueTicket() {
        queue.add(nextNumber);
        System.out.println("Ticket issued: " + nextNumber);
        return nextNumber++;
    }

    // Call the next customer in the queue
    public synchronized int callNext() {
        if (!queue.isEmpty()) {
            currentNumber = queue.poll();
            return currentNumber;
        } else {
            System.out.println("Queue is empty.");
            return -1;
        }
    }

    // Reset the queue starting from a specific number
    public synchronized void resetQueue(int startingNumber) {
        this.currentNumber = startingNumber - 1;
        this.nextNumber = startingNumber;
        this.queue.clear();
        System.out.println("Queue has been reset to start from " + startingNumber);
    }

    // Display the current status of the queue
    public synchronized void displayQueueStatus() {
        System.out.println("Current Number: " + currentNumber);
        System.out.println("Next Number to be issued: " + nextNumber);
        System.out.println("People in queue: " + queue);
    }

    // Get the current number being served
    public synchronized int getCurrentNumber() {
        return currentNumber;
    }
}
