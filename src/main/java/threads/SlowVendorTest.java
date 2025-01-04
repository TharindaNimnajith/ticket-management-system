package threads;

import core.TicketPool;

class SlowVendorTest {

  public static void main(String[] args) {
    TicketPool ticketpool = new TicketPool();
    Thread slowVendor = new Thread(new SlowVendor(10, ticketpool));
    slowVendor.start();
  }
}
