// Main application
public class PagIbigApp {
    public static void main(String[] args) {
        // Initialize the centralized queue system and components
        QueueSystem queueSystem = QueueSystem.getInstance();
        
        HelpDeskStation desk1 = new HelpDeskStation("Desk 1");
        HelpDeskStation desk2 = new HelpDeskStation("Desk 2");
        HelpDeskStation desk3 = new HelpDeskStation("Desk 3");

        OnlineMonitoringSystem onlineMonitor = new OnlineMonitoringSystem();
        
        // Issue initial tickets (1, 2, 3)
        queueSystem.issueTicket(); // Ticket 1
        queueSystem.issueTicket(); // Ticket 2
        queueSystem.issueTicket(); // Ticket 3
        
        // Serve customers at desks
        desk1.serveNextCustomer(); // Desk 1 serves Ticket 1
        desk2.serveNextCustomer(); // Desk 2 serves Ticket 2
        
        // Display queue status online
        onlineMonitor.displayQueueStatus();
        
        // Reset queue from Desk 3 to start from 3
        desk3.resetQueue(3);
        
        // Display queue status after reset
        onlineMonitor.displayQueueStatus();

        // Issue new tickets (3, 4, 5)
        queueSystem.issueTicket(); // Ticket 3
        queueSystem.issueTicket(); // Ticket 4
        queueSystem.issueTicket(); // Ticket 5
        
        // Serve customers after reset
        desk1.serveNextCustomer(); // Desk 1 serves Ticket 3
        desk2.serveNextCustomer(); // Desk 2 serves Ticket 4
        
        // Final queue status
        onlineMonitor.displayQueueStatus();
    }
}
