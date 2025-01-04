/*
package threads;

import logging.java.Logger;

public class Customer implements Runnable {

    private final TicketRetrievalStrategy retrievalStrategy;

    public Customer (TicketRetrievalStrategy retrievalStrategy) {
        this.retrievalStrategy = retrievalStrategy;
    }

    @Override
    public void run() {
        while (true) {
            String ticket = retrievalStrategy.retrieveTicket(ticketPool);

            if (ticket != null) {
                Logger.log("Customer retrieved: " + ticket);
            } else {
                Logger.log("Customer found no tickets available.");
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Logger.log("Customer interrupted.");
            }
        }
    }

    @Override
    public void handleTickets() {
        run();
    }
}
*/

/*
package threads;

import core.java.TicketPool;
import logging.java.Logger;

public class Customer implements Runnable {

    private final TicketRetrievalStrategy retrievalStrategy;

    public Customer(TicketRetrievalStrategy retrievalStrategy) {
        this.retrievalStrategy = retrievalStrategy;
    }

    @Override
    public void run() {
        while (true) {
            TicketPool ticketPool = new TicketPool();
            String ticket = retrievalStrategy.retrieveTicket(ticketPool);

            if (ticket != null) {
                Logger.log("Customer retrieved: " + ticket);
            } else {
                Logger.log("Customer found no tickets available.");
                break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Logger.log("Customer interrupted.");
            }
        }
    }
}
*/

package threads;

import core.AbstractTicketHandler;
import core.IDRetrieval;
import core.TicketPool;
import core.TicketRetrievalStrategy;
import logging.Logger;

public class Customer extends AbstractTicketHandler implements Runnable {

  private final TicketRetrievalStrategy ticketRetrievalStrategy;

  public Customer(TicketPool ticketPool) {
    super(ticketPool);
    this.ticketRetrievalStrategy = new IDRetrieval();
  }

  public Customer(TicketPool ticketPool, TicketRetrievalStrategy ticketRetrievalStrategy) {
    super(ticketPool);
    this.ticketRetrievalStrategy = ticketRetrievalStrategy;
  }

  @Override
  public void run() {
    while (true) {
      String ticket = ticketPool.removeTicket(ticketRetrievalStrategy);

      if (ticket != null) {
        Logger.log("Customer retrieved: " + ticket);
      } else {
        Logger.log("Customer found no tickets available.");
        // break;
      }

      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        Logger.log("Customer interrupted.");
      }
    }
  }

  @Override
  public void handleTickets() {
    run();
  }
}
