package threads;

import core.TicketPool;
import logging.Logger;

public class SlowVendor extends Vendor {

  public SlowVendor(int ticketReleaseRate, TicketPool ticketPool) {
    super(ticketPool, ticketReleaseRate / 2);
  }

  @Override
  public void run() {
    super.run();
    Logger.log("Slow vendor released tickets");
  }
}
