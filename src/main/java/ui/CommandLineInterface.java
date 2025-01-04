package ui;

import config.Configuration;
import exceptions.InvalidConfigurationException;
import java.util.Scanner;
import logging.Logger;

public class CommandLineInterface {

  private CommandLineInterface() {

  }

  private static int getInput(Scanner scanner, String prompt) {
    int value;

    while (true) {
      System.out.print(prompt);

      try {
        value = Integer.parseInt(scanner.nextLine());

        // if (value > 0) {
        //     return value;
        // } else {
        //     System.out.println("Value must be positive. Try again.");
        // }

        return value;
      } catch (NumberFormatException e) {
        System.out.println("Invalid input. Please enter a number.");
      }
    }
  }

  public static Configuration configureSystem() {
    Scanner scanner = new Scanner(System.in);
    Logger.log("Starting system configuration...");

    Configuration config = null;

    while (config == null) {
      try {
        int totalTickets = getInput(scanner, "Enter Total Tickets: ");
        int ticketReleaseRate = getInput(scanner, "Enter Ticket Release Rate: ");
        int customerRetrievalRate = getInput(scanner, "Enter Customer Retrieval Rate: ");
        int maxTicketCapacity = getInput(scanner, "Enter Max Ticket Capacity: ");

        config = new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);
      } catch (InvalidConfigurationException e) {
        System.out.println("Invalid configuration. Try again.");
        Logger.log(e.getMessage());
      }
    }

    return config;
  }

  public static Configuration configureSystem2() {
    Scanner scanner = new Scanner(System.in);
    Logger.log("Starting system configuration...");

    Configuration config = new Configuration();

    int totalTickets = getInput(scanner, "Enter Total Tickets: ");

    while (true) {
      try {
        config.setTotalTickets(totalTickets);
        break;
      } catch (InvalidConfigurationException e) {
        System.out.println("Invalid Total Tickets configuration. Try again.");
        Logger.log(e.getMessage());
        totalTickets = getInput(scanner, "Enter Total Tickets: ");
      }
    }

    int ticketReleaseRate = getInput(scanner, "Enter Ticket Release Rate: ");

    while (true) {
      try {
        config.setTicketReleaseRate(ticketReleaseRate);
        break;
      } catch (InvalidConfigurationException e) {
        System.out.println("Invalid Ticket Release Rate configuration. Try again.");
        Logger.log(e.getMessage());
        ticketReleaseRate = getInput(scanner, "Enter Ticket Release Rate: ");
      }
    }

    int customerRetrievalRate = getInput(scanner, "Enter Customer Retrieval Rate: ");

    while (true) {
      try {
        config.setCustomerRetrievalRate(customerRetrievalRate);
        break;
      } catch (InvalidConfigurationException e) {
        System.out.println("Invalid Customer Retrieval Rate configuration. Try again.");
        Logger.log(e.getMessage());
        customerRetrievalRate = getInput(scanner, "Enter Customer Retrieval Rate: ");
      }
    }

    int maxTicketCapacity = getInput(scanner, "Enter Max Ticket Capacity: ");

    while (true) {
      try {
        config.setMaxTicketCapacity(maxTicketCapacity);
        break;
      } catch (InvalidConfigurationException e) {
        System.out.println("Invalid Max Ticket Capacity configuration. Try again.");
        Logger.log(e.getMessage());
        maxTicketCapacity = getInput(scanner, "Enter Max Ticket Capacity: ");
      }
    }

    return config;
  }
}
