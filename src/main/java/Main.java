import config.Configuration;
import core.Stats;
import core.TicketPool;
import logging.Logger;
import threads.Customer;
import threads.Vendor;
import ui.CommandLineInterface;

public class Main {

  public static void main(String[] args) {
    Configuration config = CommandLineInterface.configureSystem2();
    // Calls the method to collect config details from the user through the CLI

    TicketPool ticketPool = new TicketPool();

    Thread vendor = new Thread(new Vendor(ticketPool, config.getTicketReleaseRate()));
    Thread customer = new Thread(new Customer(ticketPool));
    Thread stats = new Thread(new Stats(ticketPool));

    vendor.start();
    customer.start();
    stats.start();

    // start() method invokes the run() method of the respective thread objects vendor and customer
    try {
      vendor.join();
      customer.join();
      stats.join();
      // Join method is used to pause the main thread until vendor and customer threads finish
    } catch (InterruptedException e) {
      Logger.log("Main.Main thread interrupted."); // If main thread is interrupted
    }

    Logger.log("System terminated.");
  }
}
