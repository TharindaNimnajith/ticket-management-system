package threads;

import core.TicketPool;
import logging.Logger;

public class FastVendor extends Vendor {

  public FastVendor(int ticketReleaseRate, TicketPool ticketPool) {
    super(ticketPool, ticketReleaseRate * 2);
  }

  @Override
  public void run() {
    super.run();
    Logger.log("Fast vendor released tickets");
  }
}
