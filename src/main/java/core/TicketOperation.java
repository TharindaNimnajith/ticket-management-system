package core;

import java.io.IOException;

public interface TicketOperation {

  void addTickets(String ticket);

  String removeTicket(TicketRetrievalStrategy ticketRetrievalStrategy) throws IOException;
}
