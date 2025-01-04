package threads;

import core.TicketPool;

class FastVendorTest {

  public static void main(String[] args) {
    TicketPool ticketpool = new TicketPool();
    Thread fastVendor = new Thread(new FastVendor(5, ticketpool));
    fastVendor.start();
  }
}
