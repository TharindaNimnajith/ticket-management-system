package core;

import logging.Logger;

public class Stats implements Runnable {

  private final TicketPool ticketPool;

  public Stats(TicketPool ticketPool) {
    this.ticketPool = ticketPool;
  }

  @Override
  public void run() {
    while (true) {
      Logger.log("Ticket Count: " + ticketPool.getTicketCount());
      Logger.log("Ticket Added Count: " + ticketPool.getAddedTicketsCount());
      Logger.log("Ticket Removed Count: " + ticketPool.getRemovedTicketsCount());

      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        Logger.log("Vendor interrupted.");
      }
    }
  }
}
