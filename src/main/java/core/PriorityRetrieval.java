package core;

import java.util.List;

public class PriorityRetrieval implements TicketRetrievalStrategy  {

    @Override
    public String retrieveTicket(TicketPool ticketPool) {
      List<String> tickets = ticketPool.getTickets();

      // Check for VIP tickets
      for (String ticket : tickets) {
        if (ticket.contains("VIP")) {
          return ticket;
        }
      }

      // If no VIP tickets, fall back to ID-based retrieval
      tickets.sort(String::compareTo);
      return tickets.isEmpty() ? null : tickets.get(0);
    }
}
