package core;

import java.util.List;

public class IDRetrieval implements TicketRetrievalStrategy  {

  @Override
  public String retrieveTicket(TicketPool ticketPool) {
    List<String> tickets = ticketPool.getTickets();
    tickets.sort(String::compareTo);
    return tickets.isEmpty() ? null : tickets.get(0);
  }
}
