/*
package core.java;

import core.java.TicketOperation;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import logging.java.Logger;

public class TicketPool implements TicketOperation {

    private final List<String> tickets = Collections.synchronizedList(new LinkedList<>());

    @Override
    public synchronized void addTickets(String ticket) {
        tickets.add(ticket);
        Logger.logMessage(ticket,"add");
    }

    @Override
    public synchronized String removeTicket()  {
        String ticket = tickets.isEmpty() ? null : tickets.remove(0);

        if (ticket != null) {
           Logger.logMessage(ticket,"remove");
        } else {
            System.out.println("TicketPool is empty ");
        }

        return ticket;
    }

    public synchronized List<String> getTickets() {
        return tickets;
    }
}
*/

package core;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import logging.Logger;

public class TicketPool implements TicketOperation {

  private final List<String> tickets = Collections.synchronizedList(new LinkedList<>());

  private int addedTicketsCount = 0;
  private int removedTicketsCount = 0;

  @Override
  public synchronized void addTickets(String ticket) {
    tickets.add(ticket);
    addedTicketsCount++;
    Logger.logMessage(ticket, ": added");
  }

  @Override
  public synchronized String removeTicket(TicketRetrievalStrategy ticketRetrievalStrategy) {
    String ticket;


    if (tickets.isEmpty()) {
      ticket = null;
    } else {
      ticket = ticketRetrievalStrategy.retrieveTicket(this);
      tickets.remove(ticket);
      removedTicketsCount++;
    }

    Logger.logMessage(ticket, "removed");

    return ticket;
  }

  public int getTicketCount() {
    return tickets.size();
  }

  public int getAddedTicketsCount() {
    return addedTicketsCount;
  }

  public int getRemovedTicketsCount() {
    return removedTicketsCount;
  }

  public List<String> getTickets() {
    return tickets;
  }
}
