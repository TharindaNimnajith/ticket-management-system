/*
package logging.java;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    @org.junit.jupiter.api.Test
    void log() {
    }

    @org.junit.jupiter.api.Test
    void logMessage() {
    }
}
*/

package logging;

import core.IDRetrieval;
import core.TicketPool;

public class LoggerTest {

  public static void main(String[] args) {
    TicketPool ticketPool = new TicketPool();

    // Add tickets and verify logs
    ticketPool.addTickets("Ticket-1");
    ticketPool.addTickets("Ticket-2");

    // Remove tickets and verify logs
    ticketPool.removeTicket(new IDRetrieval());
    ticketPool.removeTicket(new IDRetrieval());
  }
}
